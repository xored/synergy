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
 * A representation of the model object '<em><b>Builder Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.ReportBuilderStore#getReport <em>Report</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.ReportBuilderStore#getCurrentNode <em>Current Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage#getReportBuilderStore()
 * @model
 * @generated
 */
public interface ReportBuilderStore extends EObject {
	/**
	 * Returns the value of the '<em><b>Report</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Report</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Report</em>' containment reference.
	 * @see #setReport(Report)
	 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage#getReportBuilderStore_Report()
	 * @model containment="true"
	 * @generated
	 */
	Report getReport();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.report.ReportBuilderStore#getReport <em>Report</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Report</em>' containment reference.
	 * @see #getReport()
	 * @generated
	 */
	void setReport(Report value);

	/**
	 * Returns the value of the '<em><b>Current Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Node</em>' reference.
	 * @see #setCurrentNode(Node)
	 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage#getReportBuilderStore_CurrentNode()
	 * @model
	 * @generated
	 */
	Node getCurrentNode();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.report.ReportBuilderStore#getCurrentNode <em>Current Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Node</em>' reference.
	 * @see #getCurrentNode()
	 * @generated
	 */
	void setCurrentNode(Node value);

} // ReportBuilderStore
