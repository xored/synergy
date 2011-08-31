/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.data;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.core.data.ProcessData#getInput <em>Input</em>}</li>
 *   <li>{@link com.xored.sherlock.core.data.ProcessData#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.core.data.DataPackage#getProcessData()
 * @model
 * @generated
 */
public interface ProcessData extends EObject {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference.
	 * @see #setInput(EObject)
	 * @see com.xored.sherlock.core.data.DataPackage#getProcessData_Input()
	 * @model containment="true"
	 * @generated
	 */
	EObject getInput();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.data.ProcessData#getInput <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' containment reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(EObject value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(EObject)
	 * @see com.xored.sherlock.core.data.DataPackage#getProcessData_Output()
	 * @model containment="true"
	 * @generated
	 */
	EObject getOutput();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.data.ProcessData#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(EObject value);

} // ProcessData
