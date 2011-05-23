/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jsontest;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see jsontest.JsontestFactory
 * @model kind="package"
 * @generated
 */
public interface JsontestPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jsontest";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///jsontest/jsontest.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jsontest";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JsontestPackage eINSTANCE = jsontest.impl.JsontestPackageImpl.init();

	/**
	 * The meta object id for the '{@link jsontest.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsontest.impl.DataImpl
	 * @see jsontest.impl.JsontestPackageImpl#getData()
	 * @generated
	 */
	int DATA = 0;

	/**
	 * The feature id for the '<em><b>Towns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__TOWNS = 0;

	/**
	 * The feature id for the '<em><b>Admin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__ADMIN = 1;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link jsontest.impl.TownImpl <em>Town</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsontest.impl.TownImpl
	 * @see jsontest.impl.JsontestPackageImpl#getTown()
	 * @generated
	 */
	int TOWN = 1;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOWN__USERS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOWN__NAME = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOWN__KIND = 2;

	/**
	 * The feature id for the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOWN__AGE = 3;

	/**
	 * The feature id for the '<em><b>Foundation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOWN__FOUNDATION = 4;

	/**
	 * The number of structural features of the '<em>Town</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOWN_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link jsontest.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsontest.impl.UserImpl
	 * @see jsontest.impl.JsontestPackageImpl#getUser()
	 * @generated
	 */
	int USER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ROLES = 1;

	/**
	 * The feature id for the '<em><b>Dummy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__DUMMY = 2;

	/**
	 * The feature id for the '<em><b>Town</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__TOWN = 3;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link jsontest.TownKind <em>Town Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jsontest.TownKind
	 * @see jsontest.impl.JsontestPackageImpl#getTownKind()
	 * @generated
	 */
	int TOWN_KIND = 3;


	/**
	 * Returns the meta object for class '{@link jsontest.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see jsontest.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for the containment reference list '{@link jsontest.Data#getTowns <em>Towns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Towns</em>'.
	 * @see jsontest.Data#getTowns()
	 * @see #getData()
	 * @generated
	 */
	EReference getData_Towns();

	/**
	 * Returns the meta object for the reference '{@link jsontest.Data#getAdmin <em>Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Admin</em>'.
	 * @see jsontest.Data#getAdmin()
	 * @see #getData()
	 * @generated
	 */
	EReference getData_Admin();

	/**
	 * Returns the meta object for class '{@link jsontest.Town <em>Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Town</em>'.
	 * @see jsontest.Town
	 * @generated
	 */
	EClass getTown();

	/**
	 * Returns the meta object for the containment reference list '{@link jsontest.Town#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see jsontest.Town#getUsers()
	 * @see #getTown()
	 * @generated
	 */
	EReference getTown_Users();

	/**
	 * Returns the meta object for the attribute '{@link jsontest.Town#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jsontest.Town#getName()
	 * @see #getTown()
	 * @generated
	 */
	EAttribute getTown_Name();

	/**
	 * Returns the meta object for the attribute '{@link jsontest.Town#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see jsontest.Town#getKind()
	 * @see #getTown()
	 * @generated
	 */
	EAttribute getTown_Kind();

	/**
	 * Returns the meta object for the attribute '{@link jsontest.Town#getAge <em>Age</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Age</em>'.
	 * @see jsontest.Town#getAge()
	 * @see #getTown()
	 * @generated
	 */
	EAttribute getTown_Age();

	/**
	 * Returns the meta object for the attribute '{@link jsontest.Town#getFoundation <em>Foundation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Foundation</em>'.
	 * @see jsontest.Town#getFoundation()
	 * @see #getTown()
	 * @generated
	 */
	EAttribute getTown_Foundation();

	/**
	 * Returns the meta object for class '{@link jsontest.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see jsontest.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link jsontest.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jsontest.User#getName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Name();

	/**
	 * Returns the meta object for the attribute list '{@link jsontest.User#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Roles</em>'.
	 * @see jsontest.User#getRoles()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Roles();

	/**
	 * Returns the meta object for the attribute '{@link jsontest.User#getDummy <em>Dummy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dummy</em>'.
	 * @see jsontest.User#getDummy()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Dummy();

	/**
	 * Returns the meta object for the container reference '{@link jsontest.User#getTown <em>Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Town</em>'.
	 * @see jsontest.User#getTown()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Town();

	/**
	 * Returns the meta object for enum '{@link jsontest.TownKind <em>Town Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Town Kind</em>'.
	 * @see jsontest.TownKind
	 * @generated
	 */
	EEnum getTownKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JsontestFactory getJsontestFactory();

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
		 * The meta object literal for the '{@link jsontest.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsontest.impl.DataImpl
		 * @see jsontest.impl.JsontestPackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();

		/**
		 * The meta object literal for the '<em><b>Towns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA__TOWNS = eINSTANCE.getData_Towns();

		/**
		 * The meta object literal for the '<em><b>Admin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA__ADMIN = eINSTANCE.getData_Admin();

		/**
		 * The meta object literal for the '{@link jsontest.impl.TownImpl <em>Town</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsontest.impl.TownImpl
		 * @see jsontest.impl.JsontestPackageImpl#getTown()
		 * @generated
		 */
		EClass TOWN = eINSTANCE.getTown();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOWN__USERS = eINSTANCE.getTown_Users();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOWN__NAME = eINSTANCE.getTown_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOWN__KIND = eINSTANCE.getTown_Kind();

		/**
		 * The meta object literal for the '<em><b>Age</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOWN__AGE = eINSTANCE.getTown_Age();

		/**
		 * The meta object literal for the '<em><b>Foundation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOWN__FOUNDATION = eINSTANCE.getTown_Foundation();

		/**
		 * The meta object literal for the '{@link jsontest.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsontest.impl.UserImpl
		 * @see jsontest.impl.JsontestPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NAME = eINSTANCE.getUser_Name();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__ROLES = eINSTANCE.getUser_Roles();

		/**
		 * The meta object literal for the '<em><b>Dummy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__DUMMY = eINSTANCE.getUser_Dummy();

		/**
		 * The meta object literal for the '<em><b>Town</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__TOWN = eINSTANCE.getUser_Town();

		/**
		 * The meta object literal for the '{@link jsontest.TownKind <em>Town Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jsontest.TownKind
		 * @see jsontest.impl.JsontestPackageImpl#getTownKind()
		 * @generated
		 */
		EEnum TOWN_KIND = eINSTANCE.getTownKind();

	}

} //JsontestPackage
