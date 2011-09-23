/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.status;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.status.StatusPackage
 * @generated
 */
public interface StatusFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatusFactory eINSTANCE = com.xored.sherlock.status.impl.StatusFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Java Exception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Exception</em>'.
	 * @generated
	 */
	JavaException createJavaException();

	/**
	 * Returns a new object of class '<em>Java Stack Trace Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Stack Trace Entry</em>'.
	 * @generated
	 */
	JavaStackTraceEntry createJavaStackTraceEntry();

	/**
	 * Returns a new object of class '<em>Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Status</em>'.
	 * @generated
	 */
	Status createStatus();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StatusPackage getStatusPackage();

} //StatusFactory
