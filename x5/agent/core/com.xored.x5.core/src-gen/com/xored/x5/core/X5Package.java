/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.x5.core;

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
 * @see com.xored.x5.core.X5Factory
 * @model kind="package"
 * @generated
 */
public interface X5Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xored.com/x5/core.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.xored.x5.core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	X5Package eINSTANCE = com.xored.x5.core.impl.X5PackageImpl.init();

	/**
	 * The meta object id for the '{@link com.xored.x5.core.impl.BaseDataSourceImpl <em>Base Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.x5.core.impl.BaseDataSourceImpl
	 * @see com.xored.x5.core.impl.X5PackageImpl#getBaseDataSource()
	 * @generated
	 */
	int BASE_DATA_SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_SOURCE__ID = 0;

	/**
	 * The feature id for the '<em><b>Options</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_SOURCE__OPTIONS = 1;

	/**
	 * The number of structural features of the '<em>Base Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_SOURCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.xored.x5.core.impl.CompositeDataSourceImpl <em>Composite Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.x5.core.impl.CompositeDataSourceImpl
	 * @see com.xored.x5.core.impl.X5PackageImpl#getCompositeDataSource()
	 * @generated
	 */
	int COMPOSITE_DATA_SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_SOURCE__ID = BASE_DATA_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>Options</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_SOURCE__OPTIONS = BASE_DATA_SOURCE__OPTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_SOURCE__NAME = BASE_DATA_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_SOURCE__BASE = BASE_DATA_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_SOURCE__REFERENCES = BASE_DATA_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATA_SOURCE_FEATURE_COUNT = BASE_DATA_SOURCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.xored.x5.core.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.x5.core.impl.EntryImpl
	 * @see com.xored.x5.core.impl.X5PackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.xored.x5.core.impl.DataSourceReferenceImpl <em>Data Source Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.x5.core.impl.DataSourceReferenceImpl
	 * @see com.xored.x5.core.impl.X5PackageImpl#getDataSourceReference()
	 * @generated
	 */
	int DATA_SOURCE_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_REFERENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_REFERENCE__SOURCE = 1;

	/**
	 * The number of structural features of the '<em>Data Source Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_REFERENCE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link com.xored.x5.core.BaseDataSource <em>Base Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Data Source</em>'.
	 * @see com.xored.x5.core.BaseDataSource
	 * @generated
	 */
	EClass getBaseDataSource();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.x5.core.BaseDataSource#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.xored.x5.core.BaseDataSource#getId()
	 * @see #getBaseDataSource()
	 * @generated
	 */
	EAttribute getBaseDataSource_Id();

	/**
	 * Returns the meta object for the map '{@link com.xored.x5.core.BaseDataSource#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Options</em>'.
	 * @see com.xored.x5.core.BaseDataSource#getOptions()
	 * @see #getBaseDataSource()
	 * @generated
	 */
	EReference getBaseDataSource_Options();

	/**
	 * Returns the meta object for class '{@link com.xored.x5.core.CompositeDataSource <em>Composite Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Data Source</em>'.
	 * @see com.xored.x5.core.CompositeDataSource
	 * @generated
	 */
	EClass getCompositeDataSource();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.x5.core.CompositeDataSource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.xored.x5.core.CompositeDataSource#getName()
	 * @see #getCompositeDataSource()
	 * @generated
	 */
	EAttribute getCompositeDataSource_Name();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.x5.core.CompositeDataSource#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base</em>'.
	 * @see com.xored.x5.core.CompositeDataSource#getBase()
	 * @see #getCompositeDataSource()
	 * @generated
	 */
	EReference getCompositeDataSource_Base();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.x5.core.CompositeDataSource#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see com.xored.x5.core.CompositeDataSource#getReferences()
	 * @see #getCompositeDataSource()
	 * @generated
	 */
	EReference getCompositeDataSource_References();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_Value();

	/**
	 * Returns the meta object for class '{@link com.xored.x5.core.DataSourceReference <em>Data Source Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Source Reference</em>'.
	 * @see com.xored.x5.core.DataSourceReference
	 * @generated
	 */
	EClass getDataSourceReference();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.x5.core.DataSourceReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.xored.x5.core.DataSourceReference#getName()
	 * @see #getDataSourceReference()
	 * @generated
	 */
	EAttribute getDataSourceReference_Name();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.x5.core.DataSourceReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see com.xored.x5.core.DataSourceReference#getSource()
	 * @see #getDataSourceReference()
	 * @generated
	 */
	EReference getDataSourceReference_Source();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	X5Factory getX5Factory();

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
		 * The meta object literal for the '{@link com.xored.x5.core.impl.BaseDataSourceImpl <em>Base Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.x5.core.impl.BaseDataSourceImpl
		 * @see com.xored.x5.core.impl.X5PackageImpl#getBaseDataSource()
		 * @generated
		 */
		EClass BASE_DATA_SOURCE = eINSTANCE.getBaseDataSource();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_DATA_SOURCE__ID = eINSTANCE.getBaseDataSource_Id();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_DATA_SOURCE__OPTIONS = eINSTANCE.getBaseDataSource_Options();

		/**
		 * The meta object literal for the '{@link com.xored.x5.core.impl.CompositeDataSourceImpl <em>Composite Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.x5.core.impl.CompositeDataSourceImpl
		 * @see com.xored.x5.core.impl.X5PackageImpl#getCompositeDataSource()
		 * @generated
		 */
		EClass COMPOSITE_DATA_SOURCE = eINSTANCE.getCompositeDataSource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_DATA_SOURCE__NAME = eINSTANCE.getCompositeDataSource_Name();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_DATA_SOURCE__BASE = eINSTANCE.getCompositeDataSource_Base();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_DATA_SOURCE__REFERENCES = eINSTANCE.getCompositeDataSource_References();

		/**
		 * The meta object literal for the '{@link com.xored.x5.core.impl.EntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.x5.core.impl.EntryImpl
		 * @see com.xored.x5.core.impl.X5PackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY__KEY = eINSTANCE.getEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY__VALUE = eINSTANCE.getEntry_Value();

		/**
		 * The meta object literal for the '{@link com.xored.x5.core.impl.DataSourceReferenceImpl <em>Data Source Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.x5.core.impl.DataSourceReferenceImpl
		 * @see com.xored.x5.core.impl.X5PackageImpl#getDataSourceReference()
		 * @generated
		 */
		EClass DATA_SOURCE_REFERENCE = eINSTANCE.getDataSourceReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SOURCE_REFERENCE__NAME = eINSTANCE.getDataSourceReference_Name();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE_REFERENCE__SOURCE = eINSTANCE.getDataSourceReference_Source();

	}

} //X5Package
