/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.domain;

import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Domain Gen Packages</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.domain.TypeDomainGenPackages#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomainGenPackages()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidDomainGenPackages'"
 * @generated
 */
public interface TypeDomainGenPackages extends Type {

    /**
     * Returns the value of the '<em><b>Elements</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.egf.model.domain.DomainGenPackage}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Elements</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Elements</em>' reference list.
     * @see org.eclipse.egf.model.domain.DomainPackage#getTypeDomainGenPackages_Elements()
     * @model resolveProxies="false"
     * @generated
     */
    EList<DomainGenPackage> getElements();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true" TBounds="org.eclipse.emf.ecore.EJavaObject"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (Class<T>) org.eclipse.egf.model.domain.TypeDomainGenPackages.class;'"
     * @generated
     */
    <T extends Object> Class<T> getType();

} // TypeDomainGenPackages
