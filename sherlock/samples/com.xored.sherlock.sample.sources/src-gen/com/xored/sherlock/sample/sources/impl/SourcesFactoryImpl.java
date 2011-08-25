/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.sample.sources.impl;

import com.xored.sherlock.sample.sources.*;

import org.eclipse.emf.ecore.EClass;
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
public class SourcesFactoryImpl extends EFactoryImpl implements SourcesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SourcesFactory init() {
		try {
			SourcesFactory theSourcesFactory = (SourcesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/xored/sherlock/sample/sources.ecore"); 
			if (theSourcesFactory != null) {
				return theSourcesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SourcesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcesFactoryImpl() {
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
			case SourcesPackage.DATE: return createDate();
			case SourcesPackage.DURATION: return createDuration();
			case SourcesPackage.SAMPLE: return createSample();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date createDate() {
		DateImpl date = new DateImpl();
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Duration createDuration() {
		DurationImpl duration = new DurationImpl();
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sample createSample() {
		SampleImpl sample = new SampleImpl();
		return sample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcesPackage getSourcesPackage() {
		return (SourcesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SourcesPackage getPackage() {
		return SourcesPackage.eINSTANCE;
	}

} //SourcesFactoryImpl
