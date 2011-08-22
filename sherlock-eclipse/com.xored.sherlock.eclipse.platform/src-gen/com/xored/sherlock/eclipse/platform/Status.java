/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.eclipse.platform;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Status#getChildren <em>Children</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Status#getCode <em>Code</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Status#getMessage <em>Message</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Status#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Status#getSeverity <em>Severity</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Status#getException <em>Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getStatus()
 * @model
 * @generated
 */
public interface Status extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link com.xored.sherlock.eclipse.platform.Status}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getStatus_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Status> getChildren();

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(int)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getStatus_Code()
	 * @model
	 * @generated
	 */
	int getCode();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Status#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(int value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getStatus_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Status#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin</em>' attribute.
	 * @see #setPlugin(String)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getStatus_Plugin()
	 * @model
	 * @generated
	 */
	String getPlugin();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Status#getPlugin <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin</em>' attribute.
	 * @see #getPlugin()
	 * @generated
	 */
	void setPlugin(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see #setSeverity(int)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getStatus_Severity()
	 * @model
	 * @generated
	 */
	int getSeverity();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Status#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(int value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' containment reference.
	 * @see #setException(JavaException)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getStatus_Exception()
	 * @model containment="true"
	 * @generated
	 */
	JavaException getException();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Status#getException <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' containment reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(JavaException value);

} // Status
