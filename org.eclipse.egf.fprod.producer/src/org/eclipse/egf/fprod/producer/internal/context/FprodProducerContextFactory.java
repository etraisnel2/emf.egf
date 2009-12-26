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
package org.eclipse.egf.fprod.producer.internal.context;

import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fprod.FactoryComponentInvocation;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.Task;
import org.eclipse.egf.model.fprod.TaskInvocation;
import org.eclipse.egf.producer.context.IModelElementProductionContext;
import org.eclipse.egf.producer.internal.context.FactoryComponentProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FprodProducerContextFactory {

  private FprodProducerContextFactory() {
    // Prevent Instantiation
  }

  // FactoryComponent

  public static FactoryComponentProductionContext createContext(IModelElementProductionContext<?> parent, FactoryComponent element, ProjectBundleSession projectBundleSession) {
    return new FactoryComponentProductionContext(parent, element, projectBundleSession);
  }

  // Task

  public static TaskProductionContext createContext(Task element, ProjectBundleSession projectBundleSession) {
    return new TaskProductionContext(element, projectBundleSession);
  }

  public static TaskProductionContext createContext(IModelElementProductionContext<?> parent, Task element, ProjectBundleSession projectBundleSession) {
    return new TaskProductionContext(parent, element, projectBundleSession);
  }

  // ProductionPlan

  public static ProductionPlanProductionContext createContext(IModelElementProductionContext<?> parent, ProductionPlan element, ProjectBundleSession projectBundleSession) {
    return new ProductionPlanProductionContext(parent, element, projectBundleSession);
  }

  // FactoryComponentInvocation

  public static FactoryComponentInvocationProductionContext createContext(IModelElementProductionContext<?> parent, FactoryComponentInvocation element, ProjectBundleSession projectBundleSession) {
    return new FactoryComponentInvocationProductionContext(parent, element, projectBundleSession);
  }

  // TaskInvocation

  public static TaskInvocationProductionContext createContext(IModelElementProductionContext<?> parent, TaskInvocation element, ProjectBundleSession projectBundleSession) {
    return new TaskInvocationProductionContext(parent, element, projectBundleSession);
  }

}
