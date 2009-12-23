/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.factorycomponent.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformFactoryComponent;
import org.eclipse.egf.model.edit.EGFModelsEditPlugin;
import org.eclipse.egf.model.editor.EGFModelsEditorPlugin;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * This is the action bar contributor for the FactoryComponent model editor.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class FactoryComponentActionBarContributor extends EditingDomainActionBarContributor implements ISelectionChangedListener {

  /**
   * FactoryComponent Load Resource Action
   * 
   * @generated NOT
   */
  public static class FactoryComponentLoadResourceAction extends LoadResourceAction {

    @Override
    public void run() {
      new ExtendedLoadResourceDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), domain).open();
    }

    /**
     * Extended Load Resource Action
     * 
     * @generated NOT
     */
    public static class ExtendedLoadResourceDialog extends LoadResourceDialog {

      public ExtendedLoadResourceDialog(Shell parent, EditingDomain domain) {
        super(parent, domain);
      }

      @Override
      protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        Composite buttonComposite = (Composite) composite.getChildren()[0];
        Button browseRegisteredFCsButton = new Button(buttonComposite, SWT.PUSH);
        browseRegisteredFCsButton.setText(EGFModelsEditorPlugin.INSTANCE.getString("_UI_BrowseRegisteredFactoryComponents_label"));
        prepareBrowseRegisteredFCsButton(browseRegisteredFCsButton);
        {
          FormData data = new FormData();
          Control[] children = buttonComposite.getChildren();
          data.left = new FormAttachment(0, 0);
          data.right = new FormAttachment(children[0], -CONTROL_OFFSET);
          browseRegisteredFCsButton.setLayoutData(data);
        }
        return composite;
      }

      protected void prepareBrowseRegisteredFCsButton(Button browseRegisteredFCsButton) {
        browseRegisteredFCsButton.addSelectionListener(
          new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
              RegisteredFCDialog registeredFCDialog = new RegisteredFCDialog(getShell());
              registeredFCDialog.open();
              Object[] result = registeredFCDialog.getResult();
              if (result != null) {
                StringBuffer uris = new StringBuffer();
                for (int i = 0, length = result.length; i < length; i++) {
                  uris.append(result[i]);
                  uris.append("  "); //$NON-NLS-1$
                }
                uriField.setText((uriField.getText() + "  " + uris.toString()).trim()); //$NON-NLS-1$
              }
            }
          }
        );
      }
      
    }

    /**
     * Registered FC Dialog
     * 
     * @generated NOT
     */
    public static class RegisteredFCDialog extends ElementListSelectionDialog {

      public RegisteredFCDialog(Shell parent) {
        super(
          parent, 
          new LabelProvider() {
            @Override
            public Image getImage(Object element) {
              return ExtendedImageRegistry.getInstance().getImage(EGFModelsEditPlugin.INSTANCE.getImage("full/obj16/FactoryComponent")); //$NON-NLS-1$
            }
            @Override
            public String getText(Object element) {
              if (element instanceof IPlatformFactoryComponent == false) {
                return super.getText(element);
              }
              return ((IPlatformFactoryComponent) element).getURI().toString();
            }            
          }
        );
        setMultipleSelection(true);
        setMessage(EGFModelsEditorPlugin.INSTANCE.getString("_UI_SelectRegisteredFactoryComponentURI"));
        setFilter("*");
        setTitle(EGFModelsEditorPlugin.INSTANCE.getString("_UI_FactoryComponentSelection_label"));
      }

      protected void updateElements() {
        IPlatformFactoryComponent[] fcs = EGFPlatformPlugin.getDefault().getFactoryComponents();
        Arrays.sort(fcs);
        setListElements(fcs);
      }

      @Override
      protected Control createDialogArea(Composite parent) {
        Composite result = (Composite) super.createDialogArea(parent);
        updateElements();
        return result;
      }

    }

  }

  /**
   * This keeps track of the active editor.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected IEditorPart activeEditorPart;

  /**
   * This keeps track of the current selection provider.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ISelectionProvider selectionProvider;

  /**
   * This action opens the Properties view.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected IAction showPropertiesViewAction = new Action(EGFModelsEditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) //$NON-NLS-1$
  {
    @Override
    public void run() {
      try {
        getPage().showView("org.eclipse.ui.views.PropertySheet"); //$NON-NLS-1$
      } catch (PartInitException exception) {
        EGFModelsEditorPlugin.INSTANCE.log(exception);
      }
    }
  };

  /**
   * This action refreshes the viewer of the current editor if the editor
   * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected IAction refreshViewerAction = new Action(EGFModelsEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) //$NON-NLS-1$
  {
    @Override
    public boolean isEnabled() {
      return activeEditorPart instanceof IViewerProvider;
    }

    @Override
    public void run() {
      if (activeEditorPart instanceof IViewerProvider) {
        Viewer viewer = ((IViewerProvider) activeEditorPart).getViewer();
        if (viewer != null) {
          viewer.refresh();
        }
      }
    }
  };

  /**
   * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateChildAction} corresponding to each descriptor
   * generated for the current selection by the item provider.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected Collection<IAction> createChildActions;

  /**
   * This is the menu manager into which menu contribution items should be added for CreateChild actions.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  protected IMenuManager createChildMenuManager;

  /**
   * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} corresponding to each descriptor
   * generated for the current selection by the item provider.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected Collection<IAction> createSiblingActions;

  /**
   * This is the menu manager into which menu contribution items should be added for CreateSibling actions.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  protected IMenuManager createSiblingMenuManager;

  /**
   * This creates an instance of the contributor. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public FactoryComponentActionBarContributor() {
    super(ADDITIONS_LAST_STYLE);
    loadResourceAction = new FactoryComponentLoadResourceAction();
    validateAction = new ValidateAction();
    controlAction = new ControlAction();
  }

  /**
   * This adds Separators for editor additions to the tool bar.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void contributeToToolBar(IToolBarManager toolBarManager) {
    toolBarManager.add(new Separator("factorycomponent-settings")); //$NON-NLS-1$
    toolBarManager.add(new Separator("factorycomponent-additions")); //$NON-NLS-1$
  }

  /**
   * This adds to the menu bar a menu and some separators for editor additions, as well as the sub-menus for object creation items. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void contributeToMenu(IMenuManager menuManager) {
    super.contributeToMenu(menuManager);

    IMenuManager submenuManager = new MenuManager(
        EGFModelsEditorPlugin.INSTANCE.getString("_UI_FactoryComponentEditor_menu"), "org.eclipse.egf.model.factorycomponentMenuID"); //$NON-NLS-1$ //$NON-NLS-2$
    menuManager.insertAfter("additions", submenuManager); //$NON-NLS-1$
    submenuManager.add(new Separator("settings")); //$NON-NLS-1$
    submenuManager.add(new Separator("actions")); //$NON-NLS-1$
    submenuManager.add(new Separator("additions")); //$NON-NLS-1$
    submenuManager.add(new Separator("additions-end")); //$NON-NLS-1$

    // Prepare for CreateChild item addition or removal.
    //
    createChildMenuManager = new MenuManager(EGFModelsEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item")); //$NON-NLS-1$
    submenuManager.insertBefore("additions", createChildMenuManager); //$NON-NLS-1$

    // Prepare for CreateSibling item addition or removal.
    //
    createSiblingMenuManager = new MenuManager(EGFModelsEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item")); //$NON-NLS-1$
    submenuManager.insertBefore("additions", createSiblingMenuManager); //$NON-NLS-1$

    // Force an update because Eclipse hides empty menus now.
    //
    submenuManager.addMenuListener(new IMenuListener() {
      public void menuAboutToShow(IMenuManager menuManager) {
        menuManager.updateAll(true);
      }
    });

    addGlobalActions(submenuManager);
  }

  /**
   * When the active editor changes, this remembers the change and registers with it as a selection provider.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public void setActiveEditor(IEditorPart part) {
    super.setActiveEditor(part);
    activeEditorPart = part;

    // Switch to the new selection provider.
    //
    if (selectionProvider != null) {
      selectionProvider.removeSelectionChangedListener(this);
    }
    if (part == null) {
      selectionProvider = null;
    } else {
      selectionProvider = part.getSite().getSelectionProvider();
      selectionProvider.addSelectionChangedListener(this);

      // Fake a selection changed event to update the menus.
      //
      if (selectionProvider.getSelection() != null) {
        selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
      }
    }
  }

  /**
   * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener},
   * handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying for the children and siblings
   * that can be added to the selected object and updating the menus accordingly.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void selectionChanged(SelectionChangedEvent event) {
    // Remove any menu items for old selection.
    //
    if (createChildMenuManager != null) {
      depopulateManager(createChildMenuManager, createChildActions);
    }
    if (createSiblingMenuManager != null) {
      depopulateManager(createSiblingMenuManager, createSiblingActions);
    }

    // Query the new selection for appropriate new child/sibling descriptors
    //
    Collection<?> newChildDescriptors = null;
    Collection<?> newSiblingDescriptors = null;

    ISelection selection = event.getSelection();
    if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
      Object object = ((IStructuredSelection) selection).getFirstElement();

      EditingDomain domain = ((IEditingDomainProvider) activeEditorPart).getEditingDomain();

      newChildDescriptors = domain.getNewChildDescriptors(object, null);
      newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
    }

    // Generate actions for selection; populate and redraw the menus.
    //
    createChildActions = generateCreateChildActions(newChildDescriptors, selection);
    createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);

    if (createChildMenuManager != null) {
      populateManager(createChildMenuManager, createChildActions, null);
      createChildMenuManager.update(true);
    }
    if (createSiblingMenuManager != null) {
      populateManager(createSiblingMenuManager, createSiblingActions, null);
      createSiblingMenuManager.update(true);
    }
  }

  /**
   * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in <code>descriptors</code>,
   * and returns the collection of these actions.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection) {
    Collection<IAction> actions = new ArrayList<IAction>();
    if (descriptors != null) {
      for (Object descriptor : descriptors) {
        actions.add(new CreateChildAction(activeEditorPart, selection, descriptor));
      }
    }
    return actions;
  }

  /**
   * This generates a {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each object in <code>descriptors</code>,
   * and returns the collection of these actions.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors, ISelection selection) {
    Collection<IAction> actions = new ArrayList<IAction>();
    if (descriptors != null) {
      for (Object descriptor : descriptors) {
        actions.add(new CreateSiblingAction(activeEditorPart, selection, descriptor));
      }
    }
    return actions;
  }

  /**
   * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.ActionContributionItem}s based on the
   * {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection, by inserting them before the specified
   * contribution item <code>contributionID</code>. If <code>contributionID</code> is <code>null</code>, they are simply added. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected void populateManager(IContributionManager manager, Collection<? extends IAction> actions, String contributionID) {
    if (actions != null) {
      for (IAction action : actions) {
        if (contributionID != null) {
          manager.insertBefore(contributionID, action);
        } else {
          manager.add(action);
        }
      }
    }
  }

  /**
   * This removes from the specified <code>manager</code> all {@link org.eclipse.jface.action.ActionContributionItem}s based on the
   * {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   */
  protected void depopulateManager(IContributionManager manager, Collection<? extends IAction> actions) {
    if (actions != null) {
      IContributionItem[] items = manager.getItems();
      for (int i = 0; i < items.length; i++) {
        // Look into SubContributionItems
        //
        IContributionItem contributionItem = items[i];
        while (contributionItem instanceof SubContributionItem) {
          contributionItem = ((SubContributionItem) contributionItem).getInnerItem();
        }

        // Delete the ActionContributionItems with matching action.
        //
        if (contributionItem instanceof ActionContributionItem) {
          IAction action = ((ActionContributionItem) contributionItem).getAction();
          if (actions.contains(action)) {
            manager.remove(contributionItem);
          }
        }
      }
    }
  }

  /**
   * This populates the pop-up menu before it appears.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void menuAboutToShow(IMenuManager menuManager) {
    super.menuAboutToShow(menuManager);
    MenuManager submenuManager = null;

    submenuManager = new MenuManager(EGFModelsEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item")); //$NON-NLS-1$
    populateManager(submenuManager, createChildActions, null);
    menuManager.insertBefore("edit", submenuManager); //$NON-NLS-1$

    submenuManager = new MenuManager(EGFModelsEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item")); //$NON-NLS-1$
    populateManager(submenuManager, createSiblingActions, null);
    menuManager.insertBefore("edit", submenuManager); //$NON-NLS-1$
  }

  /**
   * This inserts global actions before the "additions-end" separator.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void addGlobalActions(IMenuManager menuManager) {
    menuManager.insertAfter("additions-end", new Separator("ui-actions")); //$NON-NLS-1$ //$NON-NLS-2$
    menuManager.insertAfter("ui-actions", showPropertiesViewAction); //$NON-NLS-1$

    refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());
    menuManager.insertAfter("ui-actions", refreshViewerAction); //$NON-NLS-1$

    super.addGlobalActions(menuManager);
  }

  /**
   * This ensures that a delete action will clean up all references to deleted objects.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean removeAllReferencesOnDelete() {
    return true;
  }

}