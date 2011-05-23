/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jsontest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jsontest.User#getName <em>Name</em>}</li>
 *   <li>{@link jsontest.User#getRoles <em>Roles</em>}</li>
 *   <li>{@link jsontest.User#getDummy <em>Dummy</em>}</li>
 *   <li>{@link jsontest.User#getTown <em>Town</em>}</li>
 * </ul>
 * </p>
 *
 * @see jsontest.JsontestPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jsontest.JsontestPackage#getUser_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jsontest.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Roles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' attribute list.
	 * @see jsontest.JsontestPackage#getUser_Roles()
	 * @model
	 * @generated
	 */
	EList<String> getRoles();

	/**
	 * Returns the value of the '<em><b>Dummy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dummy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dummy</em>' attribute.
	 * @see #setDummy(int)
	 * @see jsontest.JsontestPackage#getUser_Dummy()
	 * @model
	 * @generated
	 */
	int getDummy();

	/**
	 * Sets the value of the '{@link jsontest.User#getDummy <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dummy</em>' attribute.
	 * @see #getDummy()
	 * @generated
	 */
	void setDummy(int value);

	/**
	 * Returns the value of the '<em><b>Town</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link jsontest.Town#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Town</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Town</em>' container reference.
	 * @see #setTown(Town)
	 * @see jsontest.JsontestPackage#getUser_Town()
	 * @see jsontest.Town#getUsers
	 * @model opposite="users" transient="false"
	 * @generated
	 */
	Town getTown();

	/**
	 * Sets the value of the '{@link jsontest.User#getTown <em>Town</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Town</em>' container reference.
	 * @see #getTown()
	 * @generated
	 */
	void setTown(Town value);

} // User
