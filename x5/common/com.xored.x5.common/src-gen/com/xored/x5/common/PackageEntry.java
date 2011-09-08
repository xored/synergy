/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.x5.common;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.x5.common.PackageEntry#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.x5.common.CommonPackage#getPackageEntry()
 * @model
 * @generated
 */
public interface PackageEntry extends Entry {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference.
	 * @see #setContent(EPackage)
	 * @see com.xored.x5.common.CommonPackage#getPackageEntry_Content()
	 * @model containment="true"
	 * @generated
	 */
	EPackage getContent();

	/**
	 * Sets the value of the '{@link com.xored.x5.common.PackageEntry#getContent <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' containment reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(EPackage value);

} // PackageEntry
