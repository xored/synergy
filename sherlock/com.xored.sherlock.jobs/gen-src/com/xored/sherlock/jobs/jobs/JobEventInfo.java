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
 * A representation of the model object '<em><b>Job Event Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.jobs.jobs.JobEventInfo#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.jobs.jobs.JobsPackage#getJobEventInfo()
 * @model
 * @generated
 */
public interface JobEventInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.xored.sherlock.jobs.jobs.JobEventKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.xored.sherlock.jobs.jobs.JobEventKind
	 * @see #setKind(JobEventKind)
	 * @see com.xored.sherlock.jobs.jobs.JobsPackage#getJobEventInfo_Kind()
	 * @model
	 * @generated
	 */
	JobEventKind getKind();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.jobs.jobs.JobEventInfo#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.xored.sherlock.jobs.jobs.JobEventKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(JobEventKind value);

} // JobEventInfo
