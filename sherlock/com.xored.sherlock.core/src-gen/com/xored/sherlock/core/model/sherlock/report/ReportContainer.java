/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock.report;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.ReportContainer#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage#getReportContainer()
 * @model
 * @generated
 */
public interface ReportContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(byte[])
	 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage#getReportContainer_Content()
	 * @model
	 * @generated
	 */
	byte[] getContent();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.report.ReportContainer#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(byte[] value);

} // ReportContainer
