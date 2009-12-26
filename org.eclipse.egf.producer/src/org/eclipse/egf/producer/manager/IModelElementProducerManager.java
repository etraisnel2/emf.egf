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
package org.eclipse.egf.producer.manager;

import org.eclipse.egf.core.producer.manager.IProducerManager;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.producer.context.IModelElementProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IModelElementProducerManager<T extends ModelElement> extends IProducerManager {

  public String getName();

  public IModelElementProductionContext<T> getProductionContext();

  public IModelElementProducerManager<?> getParent();

}
