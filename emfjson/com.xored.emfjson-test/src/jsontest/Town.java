/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jsontest;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Town</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jsontest.Town#getUsers <em>Users</em>}</li>
 *   <li>{@link jsontest.Town#getName <em>Name</em>}</li>
 *   <li>{@link jsontest.Town#getKind <em>Kind</em>}</li>
 *   <li>{@link jsontest.Town#getAge <em>Age</em>}</li>
 *   <li>{@link jsontest.Town#getFoundation <em>Foundation</em>}</li>
 * </ul>
 * </p>
 *
 * @see jsontest.JsontestPackage#getTown()
 * @model
 * @generated
 */
public interface Town extends EObject {
	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list.
	 * The list contents are of type {@link jsontest.User}.
	 * It is bidirectional and its opposite is '{@link jsontest.User#getTown <em>Town</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see jsontest.JsontestPackage#getTown_Users()
	 * @see jsontest.User#getTown
	 * @model opposite="town" containment="true"
	 * @generated
	 */
	EList<User> getUsers();

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
	 * @see jsontest.JsontestPackage#getTown_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jsontest.Town#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link jsontest.TownKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see jsontest.TownKind
	 * @see #setKind(TownKind)
	 * @see jsontest.JsontestPackage#getTown_Kind()
	 * @model
	 * @generated
	 */
	TownKind getKind();

	/**
	 * Sets the value of the '{@link jsontest.Town#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see jsontest.TownKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(TownKind value);

	/**
	 * Returns the value of the '<em><b>Age</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Age</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Age</em>' attribute.
	 * @see #setAge(int)
	 * @see jsontest.JsontestPackage#getTown_Age()
	 * @model
	 * @generated
	 */
	int getAge();

	/**
	 * Sets the value of the '{@link jsontest.Town#getAge <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Age</em>' attribute.
	 * @see #getAge()
	 * @generated
	 */
	void setAge(int value);

	/**
	 * Returns the value of the '<em><b>Foundation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foundation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foundation</em>' attribute.
	 * @see #setFoundation(Date)
	 * @see jsontest.JsontestPackage#getTown_Foundation()
	 * @model
	 * @generated
	 */
	Date getFoundation();

	/**
	 * Sets the value of the '{@link jsontest.Town#getFoundation <em>Foundation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foundation</em>' attribute.
	 * @see #getFoundation()
	 * @generated
	 */
	void setFoundation(Date value);

} // Town
