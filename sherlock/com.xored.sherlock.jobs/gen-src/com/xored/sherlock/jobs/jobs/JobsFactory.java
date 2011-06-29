/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.jobs.jobs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.jobs.jobs.JobsPackage
 * @generated
 */
public interface JobsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JobsFactory eINSTANCE = com.xored.sherlock.jobs.jobs.impl.JobsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Async Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Async Info</em>'.
	 * @generated
	 */
	AsyncInfo createAsyncInfo();

	/**
	 * Returns a new object of class '<em>Async Event Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Async Event Info</em>'.
	 * @generated
	 */
	AsyncEventInfo createAsyncEventInfo();

	/**
	 * Returns a new object of class '<em>Job Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Job Info</em>'.
	 * @generated
	 */
	JobInfo createJobInfo();

	/**
	 * Returns a new object of class '<em>Job Event Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Job Event Info</em>'.
	 * @generated
	 */
	JobEventInfo createJobEventInfo();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JobsPackage getJobsPackage();

} //JobsFactory
