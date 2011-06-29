/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.jobs.jobs.util;

import com.xored.sherlock.jobs.jobs.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.jobs.jobs.JobsPackage
 * @generated
 */
public class JobsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JobsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = JobsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JobsSwitch<Adapter> modelSwitch =
		new JobsSwitch<Adapter>() {
			@Override
			public Adapter caseAsyncInfo(AsyncInfo object) {
				return createAsyncInfoAdapter();
			}
			@Override
			public Adapter caseAsyncEventInfo(AsyncEventInfo object) {
				return createAsyncEventInfoAdapter();
			}
			@Override
			public Adapter caseJobInfo(JobInfo object) {
				return createJobInfoAdapter();
			}
			@Override
			public Adapter caseJobEventInfo(JobEventInfo object) {
				return createJobEventInfoAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.jobs.jobs.AsyncInfo <em>Async Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.jobs.jobs.AsyncInfo
	 * @generated
	 */
	public Adapter createAsyncInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.jobs.jobs.AsyncEventInfo <em>Async Event Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.jobs.jobs.AsyncEventInfo
	 * @generated
	 */
	public Adapter createAsyncEventInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.jobs.jobs.JobInfo <em>Job Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.jobs.jobs.JobInfo
	 * @generated
	 */
	public Adapter createJobInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.jobs.jobs.JobEventInfo <em>Job Event Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.jobs.jobs.JobEventInfo
	 * @generated
	 */
	public Adapter createJobEventInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //JobsAdapterFactory
