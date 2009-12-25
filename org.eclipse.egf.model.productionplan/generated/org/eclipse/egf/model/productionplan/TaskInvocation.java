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
package org.eclipse.egf.model.productionplan;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.productionplan.TaskInvocation#getTask <em>Task</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.productionplan.ProductionPlanPackage#getTaskInvocation()
 * @model
 * @generated
 */
public interface TaskInvocation extends ProductionPlanInvocation {
  /**
   * Returns the value of the '<em><b>Task</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Task</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Task</em>' reference.
   * @see #setTask(Task)
   * @see org.eclipse.egf.model.productionplan.ProductionPlanPackage#getTaskInvocation_Task()
   * @model required="true"
   * @generated
   */
  Task getTask();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.productionplan.TaskInvocation#getTask <em>Task</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task</em>' reference.
   * @see #getTask()
   * @generated
   */
  void setTask(Task value);

} // TaskInvocation
