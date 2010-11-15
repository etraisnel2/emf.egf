/**
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.core.session;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.core.EGFCoreDebug;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.baseadaptor.BaseData;
import org.eclipse.osgi.framework.internal.core.AbstractBundle;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.osgi.service.resolver.ExportPackageDescription;
import org.eclipse.osgi.service.resolver.ImportPackageSpecification;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;

/**
 * @author Xavier Maysonnave
 * 
 */
public final class ProjectBundleSession {

    private static final String EGF_TARGET_BUNDLE_PRIORITY = "egf.target.bundle.priority"; //$NON-NLS-1$

    public static String PROJECT_BUNDLE_SESSION = "org.eclipse.egf.core.project.bundle.session"; //$NON-NLS-1$

    private BundleContext _context;

    private Map<String, Bundle> _projectBundles = new HashMap<String, Bundle>();

    private List<String> _uninstalled = new UniqueEList<String>();

    private Boolean runtimeBundlePriority;

    public static String getLocation(IPluginModelBase model) throws CoreException {
        if (model == null) {
            return null;
        }
        IResource resource = model.getUnderlyingResource();
        if (resource == null) {
            return null;
        }
        String location = null;
        try {
            location = "reference:" //$NON-NLS-1$
                    + URLDecoder.decode(resource.getProject().getLocationURI().toURL().toExternalForm(), System.getProperty("file.encoding")); //$NON-NLS-1$
        } catch (Throwable t) {
            throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_URLFailure, resource.getProject().getName()), t));
        }
        return location;
    }

    public ProjectBundleSession(BundleContext context) {
        Assert.isNotNull(context);
        _context = context;
    }

    private void installWorkspaceModels(List<Bundle> bundles, List<IPluginModelBase> workspaceModels) throws CoreException {
        if (bundles == null || workspaceModels == null || workspaceModels.size() == 0) {
            return;
        }
        // Install Workspace models
        for (IPluginModelBase workspaceModel : workspaceModels) {
            // Ignore already installed bundle
            if (_projectBundles.get(getLocation(workspaceModel)) != null) {
                continue;
            }
            // Retrieve base location
            String location = getLocation(workspaceModel);
            // Install the bundle
            Bundle bundle = installBundle(location);
            // Add output folders if any
            IProject project = workspaceModel.getUnderlyingResource().getProject();
            addOutputFoldersToBundleClasspath(project, bundle);
            // Store
            bundles.add(bundle);
            if (EGFCoreDebug.isDebugBundleSession()) {
                if (_uninstalled.size() == 0 && _projectBundles.size() == 0) {
                    EGFCorePlugin.getDefault().logInfo("Start ProjectBundleSession..."); //$NON-NLS-1$
                }
            }
            _projectBundles.put(location, bundle);
        }
    }

    /**
     * Installs the bundle corresponding to the model.
     * 
     * @param model
     *          Model of the bundle to be installed.
     */
    private Bundle installBundle(IPluginModelBase model) throws CoreException {

        // We only load workspace model
        if (getLocation(model) == null) {
            return null;
        }

        final String bundleId = BundleHelper.getBundleId(model);
        if (bundleId == null) {
            return null;
        }

        // Gather workspace bundles to install
        final List<IPluginModelBase> workspaceModels = getWorkspaceModelDependencies(model);

        // Check whether or not such workspace models have extension points
        final List<String> registryContributors = new UniqueEList<String>();
        for (IPluginModelBase workspaceModel : workspaceModels) {
            if (workspaceModel.getPluginBase().getExtensions() != null && workspaceModel.getPluginBase().getExtensions().length > 0) {
                String workspaceBundleId = BundleHelper.getBundleId(workspaceModel);
                if (workspaceBundleId != null) {
                    registryContributors.add(workspaceBundleId);
                }
            }
        }

        // State for thread synchronization
        final boolean[] session = new boolean[] {
            false
        };

        // build a listener to wait for asynchronous extensions notifications
        IRegistryEventListener registryListener = null;
        if (registryContributors.isEmpty() == false) {

            registryListener = new IRegistryEventListener() {

                public void removed(IExtension[] extensions) {
                    // Nothing to do
                }

                public void added(IExtension[] extensions) {
                    // Process                
                    for (IExtension extension : extensions) {
                        registryContributors.remove(extension.getContributor().getName());
                        if (registryContributors.isEmpty()) {
                            synchronized (session) {
                                session[0] = true;
                                session.notifyAll();
                            }
                        }
                    }
                }

                public void added(IExtensionPoint[] extensionPoints) {
                    // Nothing to do
                }

                public void removed(IExtensionPoint[] extensionPoints) {
                    // Nothing to do
                }

            };

            // Register
            RegistryFactory.getRegistry().addListener(registryListener);

        }

        // Install workspace bundles
        final List<Bundle> bundles = new UniqueEList<Bundle>();
        internalInstallBundle(bundles, workspaceModels);

        // Wait for extensions notifications if applicable
        if (registryListener != null) {
            synchronized (session) {
                while (session[0] == false) {
                    try {
                        session.wait();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
            // Unregister
            RegistryFactory.getRegistry().removeListener(registryListener);
        }

        // Trace
        if (EGFCoreDebug.isDebugBundleSession()) {
            for (Bundle bundle : bundles) {
                EGFCorePlugin.getDefault().logInfo(NLS.bind("Workspace Bundle ''{0}'' is started.", bundle.getSymbolicName())); //$NON-NLS-1$
            }
        }

        // Return our new bundle
        return Platform.getBundle(bundleId);

    }

    private void internalInstallBundle(List<Bundle> bundles, List<IPluginModelBase> workspaceModels) throws CoreException {

        // Uninstall runtime bundles if any
        uninstallRuntimeBundle(workspaceModels);
        // Install workspace bundles
        final List<Bundle> workspaceBundles = new ArrayList<Bundle>(bundles);
        installWorkspaceModels(bundles, workspaceModels);
        // Refresh installed workspace bundles if any
        if (bundles.isEmpty() == false) {
            refreshPackages(bundles.toArray(new Bundle[bundles.size()]));
        }
        // Start them
        for (Bundle bundle : bundles) {
            try {
                if (bundle.getState() != Bundle.ACTIVE) {
                    bundle.start(Bundle.START_TRANSIENT);
                } else {
                    workspaceBundles.remove(bundle);
                }
            } catch (Throwable t) {
                throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_StartFailure, bundle), t));
            }
        }

    }

    private void uninstallRuntimeBundle(List<IPluginModelBase> workspaceModels) throws CoreException {

        if (workspaceModels == null || workspaceModels.isEmpty()) {
            return;
        }
        List<IPluginModelBase> models = new UniqueEList<IPluginModelBase>();

        // Uninstall Runtime Bundle
        List<Bundle> bundles = new UniqueEList<Bundle>();
        for (IPluginModelBase workspaceModel : workspaceModels) {

            // Ignore already uninstalled bundle
            if (_projectBundles.get(getLocation(workspaceModel)) != null) {
                continue;
            }

            // Uninstall Runtime if any
            String bundleId = BundleHelper.getBundleId(workspaceModel);
            if (bundleId == null) {
                continue;
            }
            Bundle bundle = Platform.getBundle(bundleId);
            if (bundle == null) {
                continue;
            }
            if (bundle.getState() == Bundle.INSTALLED || bundle.getState() == Bundle.RESOLVED || bundle.getState() == Bundle.STARTING || bundle.getState() == Bundle.STOPPING || bundle.getState() == Bundle.ACTIVE) {
                uninstallBundle(bundle);
            }

            // Store
            models.add(workspaceModel);
            _uninstalled.add(bundle.getLocation());
            bundles.add(bundle);

            // Trace
            if (EGFCoreDebug.isDebugBundleSession()) {
                if (_uninstalled.size() == 0) {
                    EGFCorePlugin.getDefault().logInfo("Start ProjectBundleSession..."); //$NON-NLS-1$
                }
            }

        }

        // Refresh uninstalled runtime bundles if any
        if (models.isEmpty() == false) {
            refreshPackages(bundles.toArray(new Bundle[bundles.size()]));
            if (EGFCoreDebug.isDebugBundleSession()) {
                for (IPluginModelBase model : models) {
                    EGFCorePlugin.getDefault().logInfo(NLS.bind("Runtime Bundle ''{0}'' is uninstalled.", BundleHelper.getBundleId(model))); //$NON-NLS-1$
                }
            }
        }

        return;

    }

    private List<IPluginModelBase> getWorkspaceModelDependencies(IPluginModelBase base) throws CoreException {
        List<IPluginModelBase> dependencies = new UniqueEList<IPluginModelBase>();
        // Store base
        dependencies.add(base);
        // Analyse base
        BundleDescription description = base.getBundleDescription();
        if (description == null) {
            return dependencies;
        }
        for (BundleSpecification requiredBundle : description.getRequiredBundles()) {
            for (IPluginModelBase workspaceModel : PluginRegistry.getWorkspaceModels()) {
                if (requiredBundle.isSatisfiedBy(workspaceModel.getBundleDescription())) {
                    dependencies.addAll(getWorkspaceModelDependencies(workspaceModel));
                    break;
                }
            }
        }
        for (ImportPackageSpecification importPackage : description.getImportPackages()) {
            for (IPluginModelBase workspaceModel : PluginRegistry.getWorkspaceModels()) {
                for (ExportPackageDescription export : workspaceModel.getBundleDescription().getExportPackages()) {
                    if (importPackage.isSatisfiedBy(export)) {
                        dependencies.addAll(getWorkspaceModelDependencies(workspaceModel));
                        break;
                    }
                }
            }
        }
        if (isRuntimeBundlePriority()) {
            for (IPluginModelBase innerBase : new ArrayList<IPluginModelBase>(dependencies)) {
                if (Platform.getBundle(innerBase.getBundleDescription().getSymbolicName()) != null) {
                    dependencies.remove(innerBase);
                }
            }
        }
        return dependencies;
    }

    /**
     * Installs the bundle corresponding to the given location. This will fail
     * if
     * the location doesn't point
     * to a valid bundle.
     * 
     * @param location
     *          Location of the bundle to be installed.
     * @return The installed bundle.
     * @throws BundleException
     *           Thrown if the Bundle isn't valid.
     * @throws IllegalStateException
     *           Thrown if the bundle couldn't be installed properly.
     */
    private Bundle installBundle(String location) throws CoreException {
        Bundle bundle = null;
        try {
            bundle = _context.installBundle(location);
        } catch (Throwable t) {
            throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_InstallationFailure, location), t));
        }
        // Not sure if it's needed, anyway we are conservative on that one
        if (bundle == null) {
            throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_InstallationFailure, location), null));
        }
        int state = bundle.getState();
        if (state != Bundle.INSTALLED) {
            throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_IllegalBundleState, bundle, state), null));
        }
        return bundle;
    }

    /**
     * This will set the equinox classpath of <code>bundle</code> to reflect the
     * eclipse classpath of <code>plugin</code>.
     * 
     * @param project
     *          The eclipse plugin which classpath is to be set for its
     *          corresponding equinox bundle.
     * @param bundle
     *          The equinox bundle which classpath is to reflect an eclipse
     *          development plugin.
     */
    private void addOutputFoldersToBundleClasspath(IProject project, Bundle bundle) throws CoreException {
        List<String> outputFolders = JavaHelper.getStringOutputFolders(JavaCore.create(project));
        BaseData bundleData = (BaseData) ((AbstractBundle) bundle).getBundleData();
        StringBuilder classpath = new StringBuilder();
        if (outputFolders.size() == 0) {
            classpath.append("."); //$NON-NLS-1$
        } else {
            for (Iterator<String> it = outputFolders.iterator(); it.hasNext();) {
                if (classpath.length() > 0) {
                    classpath.append(","); //$NON-NLS-1$ 
                }
                classpath.append(it.next());
            }
        }
        bundleData.setClassPathString(classpath.toString());
    }

    /**
     * Returns the bundle corresponding to the IProject if any.
     * 
     * @param id
     *          The plug-in ID of the bundle we seek.
     * @return The bundle corresponding to the given location if any,
     *         <code>null</code> otherwise.
     */
    public Bundle getBundle(String id) throws CoreException {
        if (id == null || id.trim().length() == 0) {
            return null;
        }
        IPluginModelBase model = PluginRegistry.findModel(id.trim());
        if (model == null) {
            return null;
        }
        // Check if we face a non workspace model
        if (model.getUnderlyingResource() == null || isRuntimeBundlePriority()) {
            return Platform.getBundle(id.trim());
        }
        String location = getLocation(model);
        if (location == null) {
            return null;
        }
        // Workspace model
        Bundle bundle = _projectBundles.get(location);
        if (bundle == null) {
            return installBundle(model);
        }
        return bundle;
    }

    /**
     * Returns the bundle corresponding to the IProject if any.
     * 
     * @param project
     *          The IProject of the bundle we seek.
     * @return The bundle corresponding to the given location if any,
     *         <code>null</code> otherwise.
     */
    public Bundle getBundle(IProject project) throws CoreException {
        if (project == null) {
            return null;
        }
        IPluginModelBase model = PluginRegistry.findModel(project);
        if (model == null) {
            return null;
        }
        if (isRuntimeBundlePriority()) {
            String id = BundleHelper.getBundleId(model);
            if (id != null) {
                Bundle bundle = Platform.getBundle(id);
                if (bundle != null) {
                    return bundle;
                }
            }
        }
        String location = getLocation(model);
        if (location == null) {
            return null;
        }
        Bundle bundle = _projectBundles.get(location);
        if (bundle == null) {
            bundle = installBundle(model);
        }
        return bundle;
    }

    /**
     * Refreshes all exported packages of the given bundles. This must be called
     * after installing the bundle.
     * 
     * @param bundles
     *          Bundles which exported packages are to be refreshed.
     */
    private void refreshPackages(Bundle[] bundles) throws CoreException {

        ServiceReference packageAdminReference = _context.getServiceReference(PackageAdmin.class.getName());
        PackageAdmin packageAdmin = null;
        if (packageAdminReference != null) {
            packageAdmin = (PackageAdmin) _context.getService(packageAdminReference);
        }

        if (packageAdmin == null) {
            return;
        }

        // State for thread synchronization        
        final boolean[] framework = new boolean[] {
            false
        };
        // Storage for thread framework exception
        final Throwable[] throwable = new Throwable[1];

        // Listener
        FrameworkListener listener = new FrameworkListener() {

            public void frameworkEvent(FrameworkEvent event) {
                if (event.getType() == FrameworkEvent.PACKAGES_REFRESHED || event.getType() == FrameworkEvent.ERROR) {
                    if (event.getType() == FrameworkEvent.ERROR) {
                        throwable[0] = event.getThrowable();
                    }
                    synchronized (framework) {
                        framework[0] = true;
                        framework.notifyAll();
                    }
                } else if (event.getType() == FrameworkEvent.WARNING) {
                    if (event.getThrowable() != null) {
                        EGFCorePlugin.getDefault().logWarning(event.getThrowable());
                    }
                }
            }

        };
        _context.addFrameworkListener(listener);

        // Refresh packages
        packageAdmin.refreshPackages(bundles);
        synchronized (framework) {
            while (framework[0] == false) {
                try {
                    framework.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
        _context.removeFrameworkListener(listener);
        _context.ungetService(packageAdminReference);

        // Throw a CoreException
        if (throwable[0] != null) {
            throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, EGFCoreMessages.ProjectBundleSession_PackageRefreshFailure, throwable[0]));
        }

    }

    /**
     * This can be used to uninstall all manually loaded bundles from the
     * registry
     * and remove all listeners.
     * It will be called on plugin stopping and is not intended to be called by
     * clients.
     * 
     * @noreference This method is not intended to be referenced by clients.
     */
    public void dispose() throws CoreException {

        // shallow copy our bundle collector
        final List<Bundle> uninstalledBundles = new UniqueEList<Bundle>(_uninstalled.size());

        // Uninstall workspace bundle
        if (_projectBundles.isEmpty() == false || _uninstalled.isEmpty() == false) {

            // Trace
            if (EGFCoreDebug.isDebugBundleSession()) {
                if (_projectBundles.isEmpty() == false || _uninstalled.isEmpty() == false) {
                    EGFCorePlugin.getDefault().logInfo("Dispose ProjectBundleSession..."); //$NON-NLS-1$        
                }
            }

            // Uninstall workspace bundle
            if (_projectBundles.isEmpty() == false) {
                for (Bundle bundle : _projectBundles.values()) {
                    uninstallBundle(bundle);
                }
                // Refresh Packages
                refreshPackages(_projectBundles.values().toArray(new Bundle[_projectBundles.size()]));
                // Tracing            
                if (EGFCoreDebug.isDebugBundleSession()) {
                    if (_projectBundles.isEmpty() == false) {
                        for (Bundle bundle : _projectBundles.values()) {
                            EGFCorePlugin.getDefault().logInfo(NLS.bind("Workspace Bundle ''{0}'' is uninstalled.", bundle.getSymbolicName()), 1); //$NON-NLS-1$
                        }
                    }
                }
            }

            // Install runtime bundle
            if (_uninstalled.isEmpty() == false) {
                for (String location : _uninstalled) {
                    uninstalledBundles.add(installBundle(location));
                }
                // Refresh Packages
                refreshPackages(uninstalledBundles.toArray(new Bundle[uninstalledBundles.size()]));
                // Tracing            
                if (EGFCoreDebug.isDebugBundleSession()) {
                    if (_uninstalled.isEmpty() == false) {
                        for (Bundle bundle : uninstalledBundles) {
                            EGFCorePlugin.getDefault().logInfo(NLS.bind("Runtime Bundle ''{0}'' is installed.", bundle.getSymbolicName()), 1); //$NON-NLS-1$
                        }
                    }
                }
            }

        }

        // Final
        _projectBundles.clear();
        _uninstalled.clear();

    }

    /**
     * Uninstall the given bundle from the context.
     * 
     * @param bundle
     *          The bundle that is to be uninstalled.
     * @throws CoreException
     *           Thrown if a lifecycle issue arises.
     */
    private void uninstallBundle(Bundle bundle) throws CoreException {
        try {
            bundle.uninstall();
        } catch (BundleException be) {
            throw new CoreException(EGFCorePlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.ProjectBundleSession_UninstallationFailure, bundle.getSymbolicName()), be));
        }
    }

    // TODO: not sure if we still need this support while we have now runtime and target platform support
    private boolean isRuntimeBundlePriority() {
        if (runtimeBundlePriority == null) {
            String property = System.getProperty(EGF_TARGET_BUNDLE_PRIORITY);
            runtimeBundlePriority = Boolean.TRUE.toString().equals(property);
        }
        return runtimeBundlePriority;
    }

}
