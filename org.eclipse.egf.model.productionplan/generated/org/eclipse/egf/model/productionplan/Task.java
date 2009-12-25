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

import org.eclipse.egf.model.fcore.Activity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.productionplan.Task#getTaskId <em>Task Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.productionplan.ProductionPlanPackage#getTask()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='task'"
 * @generated
 */
public interface Task extends Activity {
  /**
   * Returns the value of the '<em><b>Task Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Task Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Task Id</em>' attribute.
   * @see #setTaskId(String)
   * @see org.eclipse.egf.model.productionplan.ProductionPlanPackage#getTask_TaskId()
   * @model required="true"
   * @generated
   */
  String getTaskId();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.productionplan.Task#getTaskId <em>Task Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Task Id</em>' attribute.
   * @see #getTaskId()
   * @generated
   */
  void setTaskId(String value);

} // Task
