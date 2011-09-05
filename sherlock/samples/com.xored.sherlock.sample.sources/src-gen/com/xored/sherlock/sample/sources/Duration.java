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
 *   <li>{@link com.xored.sherlock.sample.sources.Duration#getStart <em>Start</em>}</li>
 *   <li>{@link com.xored.sherlock.sample.sources.Duration#getDuration <em>Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.sample.sources.SourcesPackage#getDuration()
 * @model
 * @generated
 */
public interface Duration extends EObject {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(long)
	 * @see com.xored.sherlock.sample.sources.SourcesPackage#getDuration_Start()
	 * @model
	 * @generated
	 */
	long getStart();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.sample.sources.Duration#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(long value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(long)
	 * @see com.xored.sherlock.sample.sources.SourcesPackage#getDuration_Duration()
	 * @model
	 * @generated
	 */
	long getDuration();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.sample.sources.Duration#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(long value);

} // Duration
