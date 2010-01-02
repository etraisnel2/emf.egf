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
package org.eclipse.egf.model.types.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeAbstractClass;
import org.eclipse.egf.model.types.TypeBigDecimal;
import org.eclipse.egf.model.types.TypeBigInteger;
import org.eclipse.egf.model.types.TypeBoolean;
import org.eclipse.egf.model.types.TypeByte;
import org.eclipse.egf.model.types.TypeCharacter;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeDate;
import org.eclipse.egf.model.types.TypeDouble;
import org.eclipse.egf.model.types.TypeElement;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeGeneratorAdapterFactory;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypeList;
import org.eclipse.egf.model.types.TypeLong;
import org.eclipse.egf.model.types.TypeMap;
import org.eclipse.egf.model.types.TypeObject;
import org.eclipse.egf.model.types.TypeSet;
import org.eclipse.egf.model.types.TypeShort;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.egf.model.types.util.TypesValidator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeAbstractClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeGeneratorAdapterFactoryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeMapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeBigDecimalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeBigIntegerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeBooleanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeByteEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeCharacterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDoubleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeFloatEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeIntegerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeLongEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeShortEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeStringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType eGeneratorAdapterFactoryEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType collectionEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType listEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType setEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.egf.model.types.TypesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TypesPackageImpl() {
    super(eNS_URI, TypesFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TypesPackage init() {
    if (isInited)
      return (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Obtain or create and register package
    TypesPackageImpl theTypesPackage = (TypesPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypesPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theTypesPackage.createPackageContents();

    // Initialize created meta-data
    theTypesPackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put(theTypesPackage, new EValidator.Descriptor() {
      public EValidator getEValidator() {
        return TypesValidator.INSTANCE;
      }
    });

    // Mark meta-data to indicate it can't be changed
    theTypesPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
    return theTypesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeElement() {
    return typeElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeElement_ID() {
    return (EAttribute) typeElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeElement_Name() {
    return (EAttribute) typeElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeElement_Description() {
    return (EAttribute) typeElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType() {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeObject() {
    return typeObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeAbstractClass() {
    return typeAbstractClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeAbstractClass_Value() {
    return (EAttribute) typeAbstractClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeClass() {
    return typeClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeCollection() {
    return typeCollectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeList() {
    return typeListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeSet() {
    return typeSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeGeneratorAdapterFactory() {
    return typeGeneratorAdapterFactoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeMap() {
    return typeMapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeBigDecimal() {
    return typeBigDecimalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeBigDecimal_Value() {
    return (EAttribute) typeBigDecimalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeBigInteger() {
    return typeBigIntegerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeBigInteger_Value() {
    return (EAttribute) typeBigIntegerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeBoolean() {
    return typeBooleanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeBoolean_Value() {
    return (EAttribute) typeBooleanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeByte() {
    return typeByteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeByte_Value() {
    return (EAttribute) typeByteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeCharacter() {
    return typeCharacterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeCharacter_Value() {
    return (EAttribute) typeCharacterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDate() {
    return typeDateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeDate_Value() {
    return (EAttribute) typeDateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDouble() {
    return typeDoubleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeDouble_Value() {
    return (EAttribute) typeDoubleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeFloat() {
    return typeFloatEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeFloat_Value() {
    return (EAttribute) typeFloatEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeInteger() {
    return typeIntegerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeInteger_Value() {
    return (EAttribute) typeIntegerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeLong() {
    return typeLongEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeLong_Value() {
    return (EAttribute) typeLongEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeShort() {
    return typeShortEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeShort_Value() {
    return (EAttribute) typeShortEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeString() {
    return typeStringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeString_Value() {
    return (EAttribute) typeStringEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getEGeneratorAdapterFactory() {
    return eGeneratorAdapterFactoryEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getCollection() {
    return collectionEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getList() {
    return listEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getSet() {
    return setEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypesFactory getTypesFactory() {
    return (TypesFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated)
      return;
    isCreated = true;

    // Create classes and their features
    typeElementEClass = createEClass(TYPE_ELEMENT);
    createEAttribute(typeElementEClass, TYPE_ELEMENT__ID);
    createEAttribute(typeElementEClass, TYPE_ELEMENT__NAME);
    createEAttribute(typeElementEClass, TYPE_ELEMENT__DESCRIPTION);

    typeEClass = createEClass(TYPE);

    typeObjectEClass = createEClass(TYPE_OBJECT);

    typeAbstractClassEClass = createEClass(TYPE_ABSTRACT_CLASS);
    createEAttribute(typeAbstractClassEClass, TYPE_ABSTRACT_CLASS__VALUE);

    typeClassEClass = createEClass(TYPE_CLASS);

    typeCollectionEClass = createEClass(TYPE_COLLECTION);

    typeListEClass = createEClass(TYPE_LIST);

    typeSetEClass = createEClass(TYPE_SET);

    typeGeneratorAdapterFactoryEClass = createEClass(TYPE_GENERATOR_ADAPTER_FACTORY);

    typeMapEClass = createEClass(TYPE_MAP);

    typeBigDecimalEClass = createEClass(TYPE_BIG_DECIMAL);
    createEAttribute(typeBigDecimalEClass, TYPE_BIG_DECIMAL__VALUE);

    typeBigIntegerEClass = createEClass(TYPE_BIG_INTEGER);
    createEAttribute(typeBigIntegerEClass, TYPE_BIG_INTEGER__VALUE);

    typeBooleanEClass = createEClass(TYPE_BOOLEAN);
    createEAttribute(typeBooleanEClass, TYPE_BOOLEAN__VALUE);

    typeByteEClass = createEClass(TYPE_BYTE);
    createEAttribute(typeByteEClass, TYPE_BYTE__VALUE);

    typeCharacterEClass = createEClass(TYPE_CHARACTER);
    createEAttribute(typeCharacterEClass, TYPE_CHARACTER__VALUE);

    typeDateEClass = createEClass(TYPE_DATE);
    createEAttribute(typeDateEClass, TYPE_DATE__VALUE);

    typeDoubleEClass = createEClass(TYPE_DOUBLE);
    createEAttribute(typeDoubleEClass, TYPE_DOUBLE__VALUE);

    typeFloatEClass = createEClass(TYPE_FLOAT);
    createEAttribute(typeFloatEClass, TYPE_FLOAT__VALUE);

    typeIntegerEClass = createEClass(TYPE_INTEGER);
    createEAttribute(typeIntegerEClass, TYPE_INTEGER__VALUE);

    typeLongEClass = createEClass(TYPE_LONG);
    createEAttribute(typeLongEClass, TYPE_LONG__VALUE);

    typeShortEClass = createEClass(TYPE_SHORT);
    createEAttribute(typeShortEClass, TYPE_SHORT__VALUE);

    typeStringEClass = createEClass(TYPE_STRING);
    createEAttribute(typeStringEClass, TYPE_STRING__VALUE);

    // Create data types
    collectionEDataType = createEDataType(COLLECTION);
    listEDataType = createEDataType(LIST);
    setEDataType = createEDataType(SET);
    eGeneratorAdapterFactoryEDataType = createEDataType(EGENERATOR_ADAPTER_FACTORY);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized)
      return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters
    ETypeParameter typeEClass_T = addETypeParameter(typeEClass, "T"); //$NON-NLS-1$
    ETypeParameter typeObjectEClass_T = addETypeParameter(typeObjectEClass, "T"); //$NON-NLS-1$
    ETypeParameter typeAbstractClassEClass_T = addETypeParameter(typeAbstractClassEClass, "T"); //$NON-NLS-1$
    addETypeParameter(collectionEDataType, "E"); //$NON-NLS-1$
    addETypeParameter(listEDataType, "E"); //$NON-NLS-1$
    addETypeParameter(setEDataType, "E"); //$NON-NLS-1$

    // Set bounds for type parameters
    EGenericType g1 = createEGenericType(theEcorePackage.getEJavaObject());
    typeEClass_T.getEBounds().add(g1);
    g1 = createEGenericType(theEcorePackage.getEJavaObject());
    typeObjectEClass_T.getEBounds().add(g1);
    g1 = createEGenericType(theEcorePackage.getEJavaObject());
    typeAbstractClassEClass_T.getEBounds().add(g1);

    // Add supertypes to classes
    typeEClass.getESuperTypes().add(this.getTypeElement());
    g1 = createEGenericType(this.getType());
    EGenericType g2 = createEGenericType(typeObjectEClass_T);
    g1.getETypeArguments().add(g2);
    typeObjectEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getType());
    g2 = createEGenericType(typeAbstractClassEClass_T);
    g1.getETypeArguments().add(g2);
    typeAbstractClassEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeAbstractClass());
    g2 = createEGenericType(theEcorePackage.getEJavaObject());
    g1.getETypeArguments().add(g2);
    typeClassEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeAbstractClass());
    g2 = createEGenericType(this.getCollection());
    g1.getETypeArguments().add(g2);
    typeCollectionEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeAbstractClass());
    g2 = createEGenericType(this.getList());
    g1.getETypeArguments().add(g2);
    typeListEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeAbstractClass());
    g2 = createEGenericType(this.getSet());
    g1.getETypeArguments().add(g2);
    typeSetEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeAbstractClass());
    g2 = createEGenericType(this.getEGeneratorAdapterFactory());
    g1.getETypeArguments().add(g2);
    typeGeneratorAdapterFactoryEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeAbstractClass());
    g2 = createEGenericType(theEcorePackage.getEMap());
    g1.getETypeArguments().add(g2);
    typeMapEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEBigDecimal());
    g1.getETypeArguments().add(g2);
    typeBigDecimalEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEBigInteger());
    g1.getETypeArguments().add(g2);
    typeBigIntegerEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(ecorePackage.getEBooleanObject());
    g1.getETypeArguments().add(g2);
    typeBooleanEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEByteObject());
    g1.getETypeArguments().add(g2);
    typeByteEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getECharacterObject());
    g1.getETypeArguments().add(g2);
    typeCharacterEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEDate());
    g1.getETypeArguments().add(g2);
    typeDateEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEDoubleObject());
    g1.getETypeArguments().add(g2);
    typeDoubleEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEFloatObject());
    g1.getETypeArguments().add(g2);
    typeFloatEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEIntegerObject());
    g1.getETypeArguments().add(g2);
    typeIntegerEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getELongObject());
    g1.getETypeArguments().add(g2);
    typeLongEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEShortObject());
    g1.getETypeArguments().add(g2);
    typeShortEClass.getEGenericSuperTypes().add(g1);
    g1 = createEGenericType(this.getTypeObject());
    g2 = createEGenericType(theEcorePackage.getEString());
    g1.getETypeArguments().add(g2);
    typeStringEClass.getEGenericSuperTypes().add(g1);

    // Initialize classes and features; add operations and parameters
    initEClass(typeElementEClass, TypeElement.class, "TypeElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeElement_ID(), theEcorePackage.getEString(), "iD", null, 0, 1, TypeElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getTypeElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TypeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
    initEAttribute(getTypeElement_Description(), theEcorePackage.getEString(), "description", null, 0, 1, TypeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    EOperation op = addEOperation(typeEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(typeEClass_T);
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    addEOperation(typeEClass, theEcorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

    initEClass(typeObjectEClass, TypeObject.class, "TypeObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(typeAbstractClassEClass, TypeAbstractClass.class, "TypeAbstractClass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeAbstractClass_Value(), theEcorePackage.getEString(), "value", null, 0, 1, TypeAbstractClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    initEClass(typeClassEClass, TypeClass.class, "TypeClass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    initEClass(typeCollectionEClass, TypeCollection.class, "TypeCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(typeCollectionEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(this.getCollection());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeListEClass, TypeList.class, "TypeList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(typeListEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(this.getList());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeSetEClass, TypeSet.class, "TypeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(typeSetEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(this.getSet());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeGeneratorAdapterFactoryEClass, TypeGeneratorAdapterFactory.class, "TypeGeneratorAdapterFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(typeGeneratorAdapterFactoryEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(this.getEGeneratorAdapterFactory());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeMapEClass, TypeMap.class, "TypeMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    op = addEOperation(typeMapEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEMap());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeBigDecimalEClass, TypeBigDecimal.class, "TypeBigDecimal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeBigDecimal_Value(), theEcorePackage.getEBigDecimal(), "value", null, 0, 1, TypeBigDecimal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeBigDecimalEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEBigDecimal());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeBigIntegerEClass, TypeBigInteger.class, "TypeBigInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeBigInteger_Value(), theEcorePackage.getEBigInteger(), "value", null, 0, 1, TypeBigInteger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeBigIntegerEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEBigInteger());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeBooleanEClass, TypeBoolean.class, "TypeBoolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeBoolean_Value(), theEcorePackage.getEBooleanObject(), "value", null, 0, 1, TypeBoolean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeBooleanEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEBooleanObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeByteEClass, TypeByte.class, "TypeByte", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeByte_Value(), theEcorePackage.getEByteObject(), "value", null, 0, 1, TypeByte.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeByteEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEByteObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeCharacterEClass, TypeCharacter.class, "TypeCharacter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeCharacter_Value(), theEcorePackage.getECharacterObject(), "value", null, 0, 1, TypeCharacter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeCharacterEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getECharacterObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeDateEClass, TypeDate.class, "TypeDate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeDate_Value(), theEcorePackage.getEDate(), "value", null, 0, 1, TypeDate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeDateEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEDate());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeDoubleEClass, TypeDouble.class, "TypeDouble", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeDouble_Value(), theEcorePackage.getEDoubleObject(), "value", null, 0, 1, TypeDouble.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeDoubleEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEDoubleObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeFloatEClass, TypeFloat.class, "TypeFloat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeFloat_Value(), theEcorePackage.getEFloatObject(), "value", null, 0, 1, TypeFloat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeFloatEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEFloatObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeIntegerEClass, TypeInteger.class, "TypeInteger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeInteger_Value(), theEcorePackage.getEIntegerObject(), "value", null, 0, 1, TypeInteger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeIntegerEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEIntegerObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeLongEClass, TypeLong.class, "TypeLong", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeLong_Value(), theEcorePackage.getELongObject(), "value", null, 0, 1, TypeLong.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeLongEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getELongObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeShortEClass, TypeShort.class, "TypeShort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeShort_Value(), theEcorePackage.getEShortObject(), "value", null, 0, 1, TypeShort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeShortEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEShortObject());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    initEClass(typeStringEClass, TypeString.class, "TypeString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEAttribute(getTypeString_Value(), theEcorePackage.getEString(), "value", null, 0, 1, TypeString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

    op = addEOperation(typeStringEClass, null, "getType", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
    g1 = createEGenericType(theEcorePackage.getEJavaClass());
    g2 = createEGenericType(theEcorePackage.getEString());
    g1.getETypeArguments().add(g2);
    initEOperation(op, g1);

    // Initialize data types
    initEDataType(collectionEDataType, Collection.class, "Collection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(listEDataType, List.class, "List", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(setEDataType, Set.class, "Set", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
    initEDataType(eGeneratorAdapterFactoryEDataType, GeneratorAdapterFactory.class, "EGeneratorAdapterFactory", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createEcoreAnnotations() {
    String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$		
    addAnnotation(typeObjectEClass, source, new String[] { "constraints", "LoadableValue ValidValue" //$NON-NLS-1$ //$NON-NLS-2$
    });
    addAnnotation(typeAbstractClassEClass, source, new String[] { "constraints", "LoadableValue ValidValue" //$NON-NLS-1$ //$NON-NLS-2$
    });
  }

} // TypesPackageImpl
