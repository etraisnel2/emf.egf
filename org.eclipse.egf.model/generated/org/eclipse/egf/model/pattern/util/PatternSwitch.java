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
package org.eclipse.egf.model.pattern.util;

import java.util.List;

import java.util.Map;
import org.eclipse.egf.model.factorycomponent.ModelElement;
import org.eclipse.egf.model.factorycomponent.Viewpoint;

import org.eclipse.egf.model.pattern.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.pattern.PatternPackage
 * @generated
 */
public class PatternSwitch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static PatternPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PatternSwitch() {
        if (modelPackage == null) {
            modelPackage = PatternPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case PatternPackage.PATTERN: {
            Pattern pattern = (Pattern) theEObject;
            T result = casePattern(pattern);
            if (result == null)
                result = casePatternElement(pattern);
            if (result == null)
                result = caseModelElement(pattern);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_METHOD: {
            PatternMethod patternMethod = (PatternMethod) theEObject;
            T result = casePatternMethod(patternMethod);
            if (result == null)
                result = caseModelElement(patternMethod);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_PARAMETER: {
            PatternParameter patternParameter = (PatternParameter) theEObject;
            T result = casePatternParameter(patternParameter);
            if (result == null)
                result = caseModelElement(patternParameter);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_ENGINE: {
            PatternEngine patternEngine = (PatternEngine) theEObject;
            T result = casePatternEngine(patternEngine);
            if (result == null)
                result = caseModelElement(patternEngine);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_LIBRARY: {
            PatternLibrary patternLibrary = (PatternLibrary) theEObject;
            T result = casePatternLibrary(patternLibrary);
            if (result == null)
                result = casePatternElement(patternLibrary);
            if (result == null)
                result = caseModelElement(patternLibrary);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_ELEMENT: {
            PatternElement patternElement = (PatternElement) theEObject;
            T result = casePatternElement(patternElement);
            if (result == null)
                result = caseModelElement(patternElement);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_VIEWPOINT: {
            PatternViewpoint patternViewpoint = (PatternViewpoint) theEObject;
            T result = casePatternViewpoint(patternViewpoint);
            if (result == null)
                result = caseViewpoint(patternViewpoint);
            if (result == null)
                result = caseModelElement(patternViewpoint);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_NATURE: {
            PatternNature patternNature = (PatternNature) theEObject;
            T result = casePatternNature(patternNature);
            if (result == null)
                result = caseModelElement(patternNature);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_CALL: {
            PatternCall patternCall = (PatternCall) theEObject;
            T result = casePatternCall(patternCall);
            if (result == null)
                result = caseCall(patternCall);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PARAMERTER2_PARAMETER_MAP: {
            @SuppressWarnings("unchecked")
            Map.Entry<PatternParameter, PatternParameter> paramerter2ParameterMap = (Map.Entry<PatternParameter, PatternParameter>) theEObject;
            T result = caseParamerter2ParameterMap(paramerter2ParameterMap);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.CALL: {
            Call call = (Call) theEObject;
            T result = caseCall(call);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.METHOD_CALL: {
            MethodCall methodCall = (MethodCall) theEObject;
            T result = caseMethodCall(methodCall);
            if (result == null)
                result = caseCall(methodCall);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case PatternPackage.PATTERN_VARIABLE: {
            PatternVariable patternVariable = (PatternVariable) theEObject;
            T result = casePatternVariable(patternVariable);
            if (result == null)
                result = caseModelElement(patternVariable);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePattern(Pattern object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Method</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Method</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternMethod(PatternMethod object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternParameter(PatternParameter object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Engine</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Engine</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternEngine(PatternEngine object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Library</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Library</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternLibrary(PatternLibrary object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternElement(PatternElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternViewpoint(PatternViewpoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Nature</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Nature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternNature(PatternNature object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternCall(PatternCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Paramerter2 Parameter Map</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Paramerter2 Parameter Map</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParamerter2ParameterMap(Map.Entry<PatternParameter, PatternParameter> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCall(Call object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Method Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Method Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMethodCall(MethodCall object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternVariable(PatternVariable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModelElement(ModelElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Viewpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseViewpoint(Viewpoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object) {
        return null;
    }

} //PatternSwitch
