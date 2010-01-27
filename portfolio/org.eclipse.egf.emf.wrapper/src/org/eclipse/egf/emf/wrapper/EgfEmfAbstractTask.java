/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.emf.wrapper;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public abstract class EgfEmfAbstractTask implements ITaskProduction {

  private ResourceSetImpl _resourceSet;

  private Resource _resource;

  private GenModel _genModel;

  public EgfEmfAbstractTask() {
    super();
  }

  public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    _resourceSet = new ResourceSetImpl();
    URI genModelUri = productionContext.getInputValue("genModelURI", URI.class); //$NON-NLS-1$
    _resource = ResourceHelper.loadResource(_resourceSet, genModelUri);
  }

  public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    // TODO have a look at GeneratorUIUtil
    // TODO handle diagnostics and status
    _genModel = (GenModel) _resource.getContents().get(0);
    _genModel.reconcile();
    _genModel.setCanGenerate(true);
    _genModel.setValidateModel(true);
    _genModel.diagnose();
    _genModel.validate();
    Generator generator = GenModelUtil.createGenerator(_genModel);
    for (String projectType : getProjectTypeList()) {
      Monitor emfMonitor = BasicMonitor.toMonitor(new SubProgressMonitor(monitor, 100));
      generator.generate(_genModel, projectType, emfMonitor);
    }
  }

  public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    _resource.unload();
    _resourceSet = null;
  }

  protected abstract ArrayList<String> getProjectTypeList();

}