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
 * A representation of the model object '<em><b>Duration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.sample.sources.Duration#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.sample.sources.SourcesPackage#getDuration()
 * @model
 * @generated
 */
public interface Duration extends EObject {
	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(long)
	 * @see com.xored.sherlock.sample.sources.SourcesPackage#getDuration_Time()
	 * @model
	 * @generated
	 */
	long getTime();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.sample.sources.Duration#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(long value);

} // Duration
