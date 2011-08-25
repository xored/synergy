/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.x5.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Source Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.x5.core.DataSourceReference#getName <em>Name</em>}</li>
 *   <li>{@link com.xored.x5.core.DataSourceReference#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.x5.core.X5Package#getDataSourceReference()
 * @model
 * @generated
 */
public interface DataSourceReference extends EObject {
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
	 * @see com.xored.x5.core.X5Package#getDataSourceReference_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.xored.x5.core.DataSourceReference#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(BaseDataSource)
	 * @see com.xored.x5.core.X5Package#getDataSourceReference_Source()
	 * @model containment="true"
	 * @generated
	 */
	BaseDataSource getSource();

	/**
	 * Sets the value of the '{@link com.xored.x5.core.DataSourceReference#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(BaseDataSource value);

} // DataSourceReference
