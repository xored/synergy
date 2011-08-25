/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.x5.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Data Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.x5.core.CompositeDataSource#getName <em>Name</em>}</li>
 *   <li>{@link com.xored.x5.core.CompositeDataSource#getBase <em>Base</em>}</li>
 *   <li>{@link com.xored.x5.core.CompositeDataSource#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.x5.core.X5Package#getCompositeDataSource()
 * @model
 * @generated
 */
public interface CompositeDataSource extends BaseDataSource {
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
	 * @see com.xored.x5.core.X5Package#getCompositeDataSource_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.xored.x5.core.CompositeDataSource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Base</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' containment reference.
	 * @see #setBase(BaseDataSource)
	 * @see com.xored.x5.core.X5Package#getCompositeDataSource_Base()
	 * @model containment="true"
	 * @generated
	 */
	BaseDataSource getBase();

	/**
	 * Sets the value of the '{@link com.xored.x5.core.CompositeDataSource#getBase <em>Base</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' containment reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(BaseDataSource value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link com.xored.x5.core.DataSourceReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see com.xored.x5.core.X5Package#getCompositeDataSource_References()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataSourceReference> getReferences();

} // CompositeDataSource
