/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.x5.common;

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
 * @see com.xored.x5.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "common";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xored.xom/x5/common.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.xored.x5.common";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonPackage eINSTANCE = com.xored.x5.common.impl.CommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.xored.x5.common.Entry <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.x5.common.Entry
	 * @see com.xored.x5.common.impl.CommonPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__SOURCE = 0;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.xored.x5.common.impl.PackageEntryImpl <em>Package Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.x5.common.impl.PackageEntryImpl
	 * @see com.xored.x5.common.impl.CommonPackageImpl#getPackageEntry()
	 * @generated
	 */
	int PACKAGE_ENTRY = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ENTRY__SOURCE = ENTRY__SOURCE;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ENTRY__CONTENT = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_ENTRY_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.xored.x5.common.impl.DataSourceEntryImpl <em>Data Source Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.x5.common.impl.DataSourceEntryImpl
	 * @see com.xored.x5.common.impl.CommonPackageImpl#getDataSourceEntry()
	 * @generated
	 */
	int DATA_SOURCE_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_ENTRY__SOURCE = ENTRY__SOURCE;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_ENTRY__CONTENT = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Source Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_ENTRY_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link com.xored.x5.common.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see com.xored.x5.common.Entry
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.x5.common.Entry#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see com.xored.x5.common.Entry#getSource()
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_Source();

	/**
	 * Returns the meta object for class '{@link com.xored.x5.common.PackageEntry <em>Package Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Entry</em>'.
	 * @see com.xored.x5.common.PackageEntry
	 * @generated
	 */
	EClass getPackageEntry();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.x5.common.PackageEntry#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see com.xored.x5.common.PackageEntry#getContent()
	 * @see #getPackageEntry()
	 * @generated
	 */
	EReference getPackageEntry_Content();

	/**
	 * Returns the meta object for class '{@link com.xored.x5.common.DataSourceEntry <em>Data Source Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Source Entry</em>'.
	 * @see com.xored.x5.common.DataSourceEntry
	 * @generated
	 */
	EClass getDataSourceEntry();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.x5.common.DataSourceEntry#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see com.xored.x5.common.DataSourceEntry#getContent()
	 * @see #getDataSourceEntry()
	 * @generated
	 */
	EReference getDataSourceEntry_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonFactory getCommonFactory();

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
		 * The meta object literal for the '{@link com.xored.x5.common.Entry <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.x5.common.Entry
		 * @see com.xored.x5.common.impl.CommonPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY__SOURCE = eINSTANCE.getEntry_Source();

		/**
		 * The meta object literal for the '{@link com.xored.x5.common.impl.PackageEntryImpl <em>Package Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.x5.common.impl.PackageEntryImpl
		 * @see com.xored.x5.common.impl.CommonPackageImpl#getPackageEntry()
		 * @generated
		 */
		EClass PACKAGE_ENTRY = eINSTANCE.getPackageEntry();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_ENTRY__CONTENT = eINSTANCE.getPackageEntry_Content();

		/**
		 * The meta object literal for the '{@link com.xored.x5.common.impl.DataSourceEntryImpl <em>Data Source Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.x5.common.impl.DataSourceEntryImpl
		 * @see com.xored.x5.common.impl.CommonPackageImpl#getDataSourceEntry()
		 * @generated
		 */
		EClass DATA_SOURCE_ENTRY = eINSTANCE.getDataSourceEntry();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE_ENTRY__CONTENT = eINSTANCE.getDataSourceEntry_Content();

	}

} //CommonPackage
