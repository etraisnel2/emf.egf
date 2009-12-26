/**
 * <copyright>
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
 * </copyright>
 */

package org.eclipse.egf.producer.orchestration;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.model.fcore.OrchestrationContext;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class OrchestrationProducer {

  public abstract Orchestration getOrchestration();

  protected abstract IModelElementProducerManager<OrchestrationContext> doCreateManager(IModelElementProducerManager<?> parent, Orchestration orchestration) throws InvocationException;

  public IModelElementProducerManager<OrchestrationContext> createManager(IModelElementProducerManager<?> parent, Orchestration orchestration) throws InvocationException {
    if (matchNature(orchestration) == false) {
      throw new InvocationException(NLS.bind(ProducerMessages.Orchestration_type_error, getOrchestration().eClass().getName(), orchestration.eClass().getName()));
    }
    return doCreateManager(parent, orchestration);
  }

  public boolean matchNature(Orchestration orchestration) {
    Assert.isNotNull(orchestration);
    Assert.isNotNull(getOrchestration());
    return getOrchestration().eClass().equals(orchestration.eClass());
  }

}
