/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.sample.sources;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.sample.sources.SourcesPackage
 * @generated
 */
public interface SourcesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SourcesFactory eINSTANCE = com.xored.sherlock.sample.sources.impl.SourcesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Date</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Date</em>'.
	 * @generated
	 */
	Date createDate();

	/**
	 * Returns a new object of class '<em>Duration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Duration</em>'.
	 * @generated
	 */
	Duration createDuration();

	/**
	 * Returns a new object of class '<em>Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sample</em>'.
	 * @generated
	 */
	Sample createSample();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SourcesPackage getSourcesPackage();

} //SourcesFactory
