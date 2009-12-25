/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model;

import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.common.activator.EGFEclipsePlugin;
import org.eclipse.egf.model.context.IModelProductionContextFactory;
import org.eclipse.egf.model.internal.context.ModelProductionContextFactory;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 * This is the central singleton for the Fcore model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class EGFModelsPlugin extends EMFPlugin {

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final EGFModelsPlugin INSTANCE = new EGFModelsPlugin();

    /**
     * IModelProductionContextFactory singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    private static final IModelProductionContextFactory __modelProductionContextFactory = new ModelProductionContextFactory();

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static Implementation plugin;

    /**
     * Create the instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EGFModelsPlugin() {
        super(new ResourceLocator[] {});
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the IModelProductionContextFactory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the singleton model production context factory.
     * @generated NOT
     */
    public static IModelProductionContextFactory getModelProductionContextFactory() {
        return __modelProductionContextFactory;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static class Implementation extends EGFEclipsePlugin {
        /**
         * Creates an instance.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated NOT
         */
        public Implementation() {
            super();
        }

        /**
         * <!-- begin-user-doc -->
         * 
         * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
         *      <!-- end-user-doc -->
         * @generated NOT
         */
        @Override
        public void start(BundleContext context_p) throws Exception {
            super.start(context_p);
            plugin = this;
            // Force EGF Core Platform Plugin initialization
            Bundle platformBundle = Platform.getBundle("org.eclipse.egf.core.platform"); //$NON-NLS-1$
            if (platformBundle != null) {
                try {
                    platformBundle.start(Bundle.START_TRANSIENT);
                } catch (BundleException e) {
                    logError(e);
                }
            }
            // Force EGF Core PDE Plugin initialization
            Bundle pdeBundle = Platform.getBundle("org.eclipse.egf.core.pde"); //$NON-NLS-1$
            if (pdeBundle != null) {
                try {
                    pdeBundle.start(Bundle.START_TRANSIENT);
                } catch (BundleException e) {
                    logError(e);
                }
            }
        }

        /**
         * Stop this bundle.
         * <!-- begin-user-doc -->
         * 
         * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
         *      <!-- end-user-doc -->
         * 
         * @generated NOT
         */
        @Override
        public void stop(BundleContext context_p) throws Exception {
            plugin = null;
            super.stop(context_p);
        }

    }

}
