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
 * A representation of the model object '<em><b>Java</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.system.Java#getRuntimeName <em>Runtime Name</em>}</li>
 *   <li>{@link com.xored.sherlock.system.Java#getRuntimeVersion <em>Runtime Version</em>}</li>
 *   <li>{@link com.xored.sherlock.system.Java#getMaxMemory <em>Max Memory</em>}</li>
 *   <li>{@link com.xored.sherlock.system.Java#getFreeMemory <em>Free Memory</em>}</li>
 *   <li>{@link com.xored.sherlock.system.Java#getTotalMemory <em>Total Memory</em>}</li>
 *   <li>{@link com.xored.sherlock.system.Java#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.system.SystemPackage#getJava()
 * @model
 * @generated
 */
public interface Java extends EObject {
	/**
	 * Returns the value of the '<em><b>Runtime Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtime Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime Name</em>' attribute.
	 * @see #setRuntimeName(String)
	 * @see com.xored.sherlock.system.SystemPackage#getJava_RuntimeName()
	 * @model
	 * @generated
	 */
	String getRuntimeName();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.Java#getRuntimeName <em>Runtime Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime Name</em>' attribute.
	 * @see #getRuntimeName()
	 * @generated
	 */
	void setRuntimeName(String value);

	/**
	 * Returns the value of the '<em><b>Runtime Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runtime Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runtime Version</em>' attribute.
	 * @see #setRuntimeVersion(String)
	 * @see com.xored.sherlock.system.SystemPackage#getJava_RuntimeVersion()
	 * @model
	 * @generated
	 */
	String getRuntimeVersion();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.Java#getRuntimeVersion <em>Runtime Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runtime Version</em>' attribute.
	 * @see #getRuntimeVersion()
	 * @generated
	 */
	void setRuntimeVersion(String value);

	/**
	 * Returns the value of the '<em><b>Max Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Memory</em>' attribute.
	 * @see #setMaxMemory(long)
	 * @see com.xored.sherlock.system.SystemPackage#getJava_MaxMemory()
	 * @model
	 * @generated
	 */
	long getMaxMemory();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.Java#getMaxMemory <em>Max Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Memory</em>' attribute.
	 * @see #getMaxMemory()
	 * @generated
	 */
	void setMaxMemory(long value);

	/**
	 * Returns the value of the '<em><b>Free Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Free Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Free Memory</em>' attribute.
	 * @see #setFreeMemory(long)
	 * @see com.xored.sherlock.system.SystemPackage#getJava_FreeMemory()
	 * @model
	 * @generated
	 */
	long getFreeMemory();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.Java#getFreeMemory <em>Free Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Free Memory</em>' attribute.
	 * @see #getFreeMemory()
	 * @generated
	 */
	void setFreeMemory(long value);

	/**
	 * Returns the value of the '<em><b>Total Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Memory</em>' attribute.
	 * @see #setTotalMemory(long)
	 * @see com.xored.sherlock.system.SystemPackage#getJava_TotalMemory()
	 * @model
	 * @generated
	 */
	long getTotalMemory();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.system.Java#getTotalMemory <em>Total Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Memory</em>' attribute.
	 * @see #getTotalMemory()
	 * @generated
	 */
	void setTotalMemory(long value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see com.xored.sherlock.system.SystemPackage#getJava_Properties()
	 * @model mapType="com.xored.sherlock.system.Entry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getProperties();

} // Java
