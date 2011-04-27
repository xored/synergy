/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.SystemInfo#getOsName <em>Os Name</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.SystemInfo#getOsVersion <em>Os Version</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.SystemInfo#getOsArch <em>Os Arch</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.SystemInfo#getUsername <em>Username</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.SystemInfo#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getSystemInfo()
 * @model
 * @generated
 */
public interface SystemInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Os Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Os Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Os Name</em>' attribute.
	 * @see #setOsName(String)
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getSystemInfo_OsName()
	 * @model
	 * @generated
	 */
	String getOsName();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.SystemInfo#getOsName <em>Os Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Os Name</em>' attribute.
	 * @see #getOsName()
	 * @generated
	 */
	void setOsName(String value);

	/**
	 * Returns the value of the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Os Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Os Version</em>' attribute.
	 * @see #setOsVersion(String)
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getSystemInfo_OsVersion()
	 * @model
	 * @generated
	 */
	String getOsVersion();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.SystemInfo#getOsVersion <em>Os Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Os Version</em>' attribute.
	 * @see #getOsVersion()
	 * @generated
	 */
	void setOsVersion(String value);

	/**
	 * Returns the value of the '<em><b>Os Arch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Os Arch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Os Arch</em>' attribute.
	 * @see #setOsArch(String)
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getSystemInfo_OsArch()
	 * @model
	 * @generated
	 */
	String getOsArch();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.SystemInfo#getOsArch <em>Os Arch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Os Arch</em>' attribute.
	 * @see #getOsArch()
	 * @generated
	 */
	void setOsArch(String value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Username</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getSystemInfo_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.SystemInfo#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link com.xored.sherlock.core.model.sherlock.SystemVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getSystemInfo_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<SystemVariable> getVariables();

} // SystemInfo
