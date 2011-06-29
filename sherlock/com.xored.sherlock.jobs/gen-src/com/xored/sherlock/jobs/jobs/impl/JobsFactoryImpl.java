/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.jobs.jobs.impl;

import com.xored.sherlock.jobs.jobs.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JobsFactoryImpl extends EFactoryImpl implements JobsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobsFactory init() {
		try {
			JobsFactory theJobsFactory = (JobsFactory)EPackage.Registry.INSTANCE.getEFactory("http://xored.com/sherlock/jobs/1.0"); 
			if (theJobsFactory != null) {
				return theJobsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JobsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JobsPackage.ASYNC_INFO: return createAsyncInfo();
			case JobsPackage.ASYNC_EVENT_INFO: return createAsyncEventInfo();
			case JobsPackage.JOB_INFO: return createJobInfo();
			case JobsPackage.JOB_EVENT_INFO: return createJobEventInfo();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JobsPackage.ASYNC_EVENT_KIND:
				return createAsyncEventKindFromString(eDataType, initialValue);
			case JobsPackage.JOB_EVENT_KIND:
				return createJobEventKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JobsPackage.ASYNC_EVENT_KIND:
				return convertAsyncEventKindToString(eDataType, instanceValue);
			case JobsPackage.JOB_EVENT_KIND:
				return convertJobEventKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsyncInfo createAsyncInfo() {
		AsyncInfoImpl asyncInfo = new AsyncInfoImpl();
		return asyncInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsyncEventInfo createAsyncEventInfo() {
		AsyncEventInfoImpl asyncEventInfo = new AsyncEventInfoImpl();
		return asyncEventInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobInfo createJobInfo() {
		JobInfoImpl jobInfo = new JobInfoImpl();
		return jobInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobEventInfo createJobEventInfo() {
		JobEventInfoImpl jobEventInfo = new JobEventInfoImpl();
		return jobEventInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsyncEventKind createAsyncEventKindFromString(EDataType eDataType, String initialValue) {
		AsyncEventKind result = AsyncEventKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAsyncEventKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobEventKind createJobEventKindFromString(EDataType eDataType, String initialValue) {
		JobEventKind result = JobEventKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJobEventKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobsPackage getJobsPackage() {
		return (JobsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JobsPackage getPackage() {
		return JobsPackage.eINSTANCE;
	}

} //JobsFactoryImpl
