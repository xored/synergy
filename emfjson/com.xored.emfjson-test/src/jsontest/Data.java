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
 * A representation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jsontest.Data#getTowns <em>Towns</em>}</li>
 *   <li>{@link jsontest.Data#getAdmin <em>Admin</em>}</li>
 * </ul>
 * </p>
 *
 * @see jsontest.JsontestPackage#getData()
 * @model
 * @generated
 */
public interface Data extends EObject {
	/**
	 * Returns the value of the '<em><b>Towns</b></em>' containment reference list.
	 * The list contents are of type {@link jsontest.Town}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Towns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Towns</em>' containment reference list.
	 * @see jsontest.JsontestPackage#getData_Towns()
	 * @model containment="true"
	 * @generated
	 */
	EList<Town> getTowns();

	/**
	 * Returns the value of the '<em><b>Admin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Admin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Admin</em>' reference.
	 * @see #setAdmin(User)
	 * @see jsontest.JsontestPackage#getData_Admin()
	 * @model
	 * @generated
	 */
	User getAdmin();

	/**
	 * Sets the value of the '{@link jsontest.Data#getAdmin <em>Admin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Admin</em>' reference.
	 * @see #getAdmin()
	 * @generated
	 */
	void setAdmin(User value);

} // Data
