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
 * 
 */
package org.eclipse.egf.core.fcore;

import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.PlatformExtensionPointURI;
import org.eclipse.pde.core.plugin.IPluginElement;

public final class PlatformFcore extends PlatformExtensionPointURI implements IPlatformFcore {

  private String _name;

  public PlatformFcore(IPlatformBundle bundle, IPluginElement element, String id) {
    super(bundle, element, id);
    _name = new Path(getPreviousURI().lastSegment()).removeFileExtension().toString();
  }

  public String getName() {
    return _name;
  }

}
