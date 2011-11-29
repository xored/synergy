/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.x5.common;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.xored.x5.common.CommonPackage
 * @generated
 */
public interface CommonFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonFactory eINSTANCE = com.xored.x5.common.impl.CommonFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Package Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Entry</em>'.
	 * @generated
	 */
	PackageEntry createPackageEntry();

	/**
	 * Returns a new object of class '<em>Data Source Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Source Entry</em>'.
	 * @generated
	 */
	DataSourceEntry createDataSourceEntry();

	/**
	 * Returns a new object of class '<em>Ping Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ping Entry</em>'.
	 * @generated
	 */
	PingEntry createPingEntry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommonPackage getCommonPackage();

} //CommonFactory
