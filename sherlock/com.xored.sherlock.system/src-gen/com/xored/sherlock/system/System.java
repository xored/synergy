/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.system;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.system.System#getOsName <em>Os Name</em>}</li>
 *   <li>{@link com.xored.sherlock.system.System#getOsVersion <em>Os Version</em>}</li>
 *   <li>{@link com.xored.sherlock.system.System#getOsArch <em>Os Arch</em>}</li>
 *   <li>{@link com.xored.sherlock.system.System#getUsername <em>Username</em>}</li>
 *   <li>{@link com.xored.sherlock.system.System#getLocale <em>Locale</em>}</li>
 *   <li>{@link com.xored.sherlock.system.System#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.system.SystemPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject {
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
	 * @see com.xored.sherlock.system.SystemPackage#getSystem_OsName()
	 * @model
	 * @generated
	 */
	String getOsName();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.System#getOsName <em>Os Name</em>}' attribute.
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
	 * @see com.xored.sherlock.system.SystemPackage#getSystem_OsVersion()
	 * @model
	 * @generated
	 */
	String getOsVersion();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.System#getOsVersion <em>Os Version</em>}' attribute.
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
	 * @see com.xored.sherlock.system.SystemPackage#getSystem_OsArch()
	 * @model
	 * @generated
	 */
	String getOsArch();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.System#getOsArch <em>Os Arch</em>}' attribute.
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
	 * @see com.xored.sherlock.system.SystemPackage#getSystem_Username()
	 * @model
	 * @generated
	 */
	String getUsername();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.System#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
	void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locale</em>' attribute.
	 * @see #setLocale(String)
	 * @see com.xored.sherlock.system.SystemPackage#getSystem_Locale()
	 * @model
	 * @generated
	 */
	String getLocale();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.System#getLocale <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Locale</em>' attribute.
	 * @see #getLocale()
	 * @generated
	 */
	void setLocale(String value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' map.
	 * @see com.xored.sherlock.system.SystemPackage#getSystem_Variables()
	 * @model mapType="com.xored.sherlock.system.Entry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getVariables();

} // System