/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.x5.core;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.xored.x5.core.X5Package
 * @generated
 */
public interface X5Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	X5Factory eINSTANCE = com.xored.x5.core.impl.X5FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Base Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Data Source</em>'.
	 * @generated
	 */
	BaseDataSource createBaseDataSource();

	/**
	 * Returns a new object of class '<em>Composite Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Data Source</em>'.
	 * @generated
	 */
	CompositeDataSource createCompositeDataSource();

	/**
	 * Returns a new object of class '<em>Data Source Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Source Reference</em>'.
	 * @generated
	 */
	DataSourceReference createDataSourceReference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	X5Package getX5Package();

} //X5Factory
