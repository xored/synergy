/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.sample.sources;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Date</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.sample.sources.Date#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.sample.sources.SourcesPackage#getDate()
 * @model
 * @generated
 */
public interface Date extends EObject {

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(String)
	 * @see com.xored.sherlock.sample.sources.SourcesPackage#getDate_Time()
	 * @model
	 * @generated
	 */
	String getTime();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.sample.sources.Date#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(String value);
} // Date
