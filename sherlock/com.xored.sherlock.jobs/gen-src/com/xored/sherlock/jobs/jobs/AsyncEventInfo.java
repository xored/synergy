/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.jobs.jobs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Async Event Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.jobs.jobs.AsyncEventInfo#getKind <em>Kind</em>}</li>
 *   <li>{@link com.xored.sherlock.jobs.jobs.AsyncEventInfo#getDelay <em>Delay</em>}</li>
 *   <li>{@link com.xored.sherlock.jobs.jobs.AsyncEventInfo#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.jobs.jobs.JobsPackage#getAsyncEventInfo()
 * @model
 * @generated
 */
public interface AsyncEventInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.xored.sherlock.jobs.jobs.AsyncEventKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.xored.sherlock.jobs.jobs.AsyncEventKind
	 * @see #setKind(AsyncEventKind)
	 * @see com.xored.sherlock.jobs.jobs.JobsPackage#getAsyncEventInfo_Kind()
	 * @model
	 * @generated
	 */
	AsyncEventKind getKind();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.jobs.jobs.AsyncEventInfo#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.xored.sherlock.jobs.jobs.AsyncEventKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(AsyncEventKind value);

	/**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #setDelay(int)
	 * @see com.xored.sherlock.jobs.jobs.JobsPackage#getAsyncEventInfo_Delay()
	 * @model
	 * @generated
	 */
	int getDelay();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.jobs.jobs.AsyncEventInfo#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #getDelay()
	 * @generated
	 */
	void setDelay(int value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.xored.sherlock.jobs.jobs.JobsPackage#getAsyncEventInfo_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.jobs.jobs.AsyncEventInfo#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // AsyncEventInfo
