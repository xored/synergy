/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock.report;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Report</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.Report#getRoot <em>Root</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.Report#getCategories <em>Categories</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.Report#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage#getReport()
 * @model
 * @generated
 */
public interface Report extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.xored.sherlock.core.model.sherlock.report.Node#getReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(Node)
	 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage#getReport_Root()
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getReport
	 * @model opposite="report" containment="true"
	 * @generated
	 */
	Node getRoot();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.report.Report#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Node value);

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link com.xored.sherlock.core.model.sherlock.report.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage#getReport_Categories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Category> getCategories();

	/**
	 * Returns the value of the '<em><b>Sources</b></em>' containment reference list.
	 * The list contents are of type {@link com.xored.sherlock.core.model.sherlock.report.EventSource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sources</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sources</em>' containment reference list.
	 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage#getReport_Sources()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventSource> getSources();

} // Report
