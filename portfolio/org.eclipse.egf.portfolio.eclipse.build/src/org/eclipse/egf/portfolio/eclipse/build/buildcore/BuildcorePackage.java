/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildcore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcoreFactory
 * @model kind="package"
 * @generated
 */
public interface BuildcorePackage extends EPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "buildcore";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.eclipse.org/egf/1.0.0/buildcore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "buildcore";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    BuildcorePackage eINSTANCE = org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl.init();

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl <em>Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getItem()
     * @generated
     */
    int ITEM = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__NAME = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__DESCRIPTION = 1;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__PROPERTIES = 2;

    /**
     * The number of structural features of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.KeyValueImpl <em>Key Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.KeyValueImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getKeyValue()
     * @generated
     */
    int KEY_VALUE = 1;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KEY_VALUE__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KEY_VALUE__VALUE = 1;

    /**
     * The number of structural features of the '<em>Key Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int KEY_VALUE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl <em>Chain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getChain()
     * @generated
     */
    int CHAIN = 3;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl <em>Job</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getJob()
     * @generated
     */
    int JOB = 6;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl <em>Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStep()
     * @generated
     */
    int STEP = 5;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl <em>SCM</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getSCM()
     * @generated
     */
    int SCM = 8;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getProperty()
     * @generated
     */
    int PROPERTY = 2;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__KEY = KEY_VALUE__KEY;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY__VALUE = KEY_VALUE__VALUE;

    /**
     * The number of structural features of the '<em>Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_FEATURE_COUNT = KEY_VALUE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__DESCRIPTION = ITEM__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__PROPERTIES = ITEM__PROPERTIES;

    /**
     * The feature id for the '<em><b>Jobs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN__JOBS = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Chain</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHAIN_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.AbstractStepContainerImpl <em>Abstract Step Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.AbstractStepContainerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getAbstractStepContainer()
     * @generated
     */
    int ABSTRACT_STEP_CONTAINER = 4;

    /**
     * The feature id for the '<em><b>Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STEP_CONTAINER__STEPS = 0;

    /**
     * The number of structural features of the '<em>Abstract Step Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_STEP_CONTAINER_FEATURE_COUNT = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP__ID = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP__DESCRIPTION = 1;

    /**
     * The number of structural features of the '<em>Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_FEATURE_COUNT = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__DESCRIPTION = ITEM__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__PROPERTIES = ITEM__PROPERTIES;

    /**
     * The feature id for the '<em><b>Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__STEPS = ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Scms</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__SCMS = ITEM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__TRIGGERS = ITEM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Enabled</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB__ENABLED = ITEM_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Job</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JOB_FEATURE_COUNT = ITEM_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepContainerImpl <em>Step Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepContainerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStepContainer()
     * @generated
     */
    int STEP_CONTAINER = 7;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER__ID = STEP__ID;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER__DESCRIPTION = STEP__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER__STEPS = STEP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Step Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_CONTAINER_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>SCM</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCM_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getTrigger()
     * @generated
     */
    int TRIGGER = 9;

    /**
     * The number of structural features of the '<em>Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_FEATURE_COUNT = 0;


    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item
     * @generated
     */
    EClass getItem();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getName()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Name();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getDescription()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Description();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Item#getProperties()
     * @see #getItem()
     * @generated
     */
    EReference getItem_Properties();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue <em>Key Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Key Value</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue
     * @generated
     */
    EClass getKeyValue();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue#getKey()
     * @see #getKeyValue()
     * @generated
     */
    EAttribute getKeyValue_Key();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.KeyValue#getValue()
     * @see #getKeyValue()
     * @generated
     */
    EAttribute getKeyValue_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain <em>Chain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Chain</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain
     * @generated
     */
    EClass getChain();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain#getJobs <em>Jobs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Jobs</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain#getJobs()
     * @see #getChain()
     * @generated
     */
    EReference getChain_Jobs();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer <em>Abstract Step Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Step Container</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer
     * @generated
     */
    EClass getAbstractStepContainer();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer#getSteps <em>Steps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Steps</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer#getSteps()
     * @see #getAbstractStepContainer()
     * @generated
     */
    EReference getAbstractStepContainer_Steps();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job <em>Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Job</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job
     * @generated
     */
    EClass getJob();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getScms <em>Scms</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Scms</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getScms()
     * @see #getJob()
     * @generated
     */
    EReference getJob_Scms();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getTriggers <em>Triggers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Triggers</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getTriggers()
     * @see #getJob()
     * @generated
     */
    EReference getJob_Triggers();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#isEnabled <em>Enabled</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enabled</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#isEnabled()
     * @see #getJob()
     * @generated
     */
    EAttribute getJob_Enabled();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Step <em>Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Step</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Step
     * @generated
     */
    EClass getStep();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Step#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Step#getId()
     * @see #getStep()
     * @generated
     */
    EAttribute getStep_Id();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Step#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Step#getDescription()
     * @see #getStep()
     * @generated
     */
    EAttribute getStep_Description();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.StepContainer <em>Step Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Step Container</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.StepContainer
     * @generated
     */
    EClass getStepContainer();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM <em>SCM</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SCM</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM
     * @generated
     */
    EClass getSCM();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Property <em>Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Property
     * @generated
     */
    EClass getProperty();

    /**
     * Returns the meta object for class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trigger</em>'.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger
     * @generated
     */
    EClass getTrigger();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    BuildcoreFactory getBuildcoreFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl <em>Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ItemImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getItem()
         * @generated
         */
        EClass ITEM = eINSTANCE.getItem();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__NAME = eINSTANCE.getItem_Name();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__DESCRIPTION = eINSTANCE.getItem_Description();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM__PROPERTIES = eINSTANCE.getItem_Properties();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.KeyValueImpl <em>Key Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.KeyValueImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getKeyValue()
         * @generated
         */
        EClass KEY_VALUE = eINSTANCE.getKeyValue();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KEY_VALUE__KEY = eINSTANCE.getKeyValue_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute KEY_VALUE__VALUE = eINSTANCE.getKeyValue_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl <em>Chain</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.ChainImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getChain()
         * @generated
         */
        EClass CHAIN = eINSTANCE.getChain();

        /**
         * The meta object literal for the '<em><b>Jobs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHAIN__JOBS = eINSTANCE.getChain_Jobs();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.AbstractStepContainerImpl <em>Abstract Step Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.AbstractStepContainerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getAbstractStepContainer()
         * @generated
         */
        EClass ABSTRACT_STEP_CONTAINER = eINSTANCE.getAbstractStepContainer();

        /**
         * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_STEP_CONTAINER__STEPS = eINSTANCE.getAbstractStepContainer_Steps();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl <em>Job</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.JobImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getJob()
         * @generated
         */
        EClass JOB = eINSTANCE.getJob();

        /**
         * The meta object literal for the '<em><b>Scms</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOB__SCMS = eINSTANCE.getJob_Scms();

        /**
         * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JOB__TRIGGERS = eINSTANCE.getJob_Triggers();

        /**
         * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JOB__ENABLED = eINSTANCE.getJob_Enabled();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl <em>Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStep()
         * @generated
         */
        EClass STEP = eINSTANCE.getStep();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STEP__ID = eINSTANCE.getStep_Id();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STEP__DESCRIPTION = eINSTANCE.getStep_Description();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepContainerImpl <em>Step Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.StepContainerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getStepContainer()
         * @generated
         */
        EClass STEP_CONTAINER = eINSTANCE.getStepContainer();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl <em>SCM</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.SCMImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getSCM()
         * @generated
         */
        EClass SCM = eINSTANCE.getSCM();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl <em>Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.PropertyImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getProperty()
         * @generated
         */
        EClass PROPERTY = eINSTANCE.getProperty();

        /**
         * The meta object literal for the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl <em>Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.TriggerImpl
         * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.impl.BuildcorePackageImpl#getTrigger()
         * @generated
         */
        EClass TRIGGER = eINSTANCE.getTrigger();

    }

} //BuildcorePackage
