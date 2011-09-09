/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.thread;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.thread.Thread#getName <em>Name</em>}</li>
 *   <li>{@link com.xored.sherlock.thread.Thread#getId <em>Id</em>}</li>
 *   <li>{@link com.xored.sherlock.thread.Thread#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.thread.ThreadPackage#getThread()
 * @model
 * @generated
 */
public interface Thread extends EObject {
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
	 * @see com.xored.sherlock.thread.ThreadPackage#getThread_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.thread.Thread#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(long)
	 * @see com.xored.sherlock.thread.ThreadPackage#getThread_Id()
	 * @model
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.thread.Thread#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link com.xored.sherlock.thread.ThreadState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see com.xored.sherlock.thread.ThreadState
	 * @see #setState(ThreadState)
	 * @see com.xored.sherlock.thread.ThreadPackage#getThread_State()
	 * @model
	 * @generated
	 */
	ThreadState getState();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.thread.Thread#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see com.xored.sherlock.thread.ThreadState
	 * @see #getState()
	 * @generated
	 */
	void setState(ThreadState value);

} // Thread
