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
package org.eclipse.egf.fprod.producer.internal.task;

import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.fprod.producer.internal.invocation.ProductionTaskInvocation;
import org.eclipse.egf.fprod.producer.invocation.ITaskProductionInvocation;
import org.eclipse.egf.fprod.producer.task.IProductionPlanTaskInvocationFactory;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanTaskInvocationFactory implements IProductionPlanTaskInvocationFactory {

  public ITaskProductionInvocation createInvocation(Bundle bundle, ITaskProductionContext context, String value) {
    return new ProductionTaskInvocation(bundle, context, value);
  }

}
