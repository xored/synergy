/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.sample.sources;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.sample.sources.SourcesFactory
 * @model kind="package"
 * @generated
 */
public interface SourcesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sources";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///com/xored/sherlock/sample/sources.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.xored.sherlock.sample.sources";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SourcesPackage eINSTANCE = com.xored.sherlock.sample.sources.impl.SourcesPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.xored.sherlock.sample.sources.impl.DateImpl <em>Date</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.sample.sources.impl.DateImpl
	 * @see com.xored.sherlock.sample.sources.impl.SourcesPackageImpl#getDate()
	 * @generated
	 */
	int DATE = 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__TIME = 0;

	/**
	 * The number of structural features of the '<em>Date</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link com.xored.sherlock.sample.sources.impl.DurationImpl <em>Duration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.sample.sources.impl.DurationImpl
	 * @see com.xored.sherlock.sample.sources.impl.SourcesPackageImpl#getDuration()
	 * @generated
	 */
	int DURATION = 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION__TIME = 0;

	/**
	 * The number of structural features of the '<em>Duration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link com.xored.sherlock.sample.sources.impl.SampleImpl <em>Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.sample.sources.impl.SampleImpl
	 * @see com.xored.sherlock.sample.sources.impl.SourcesPackageImpl#getSample()
	 * @generated
	 */
	int SAMPLE = 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.sample.sources.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date</em>'.
	 * @see com.xored.sherlock.sample.sources.Date
	 * @generated
	 */
	EClass getDate();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.sample.sources.Date#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see com.xored.sherlock.sample.sources.Date#getTime()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Time();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.sample.sources.Duration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Duration</em>'.
	 * @see com.xored.sherlock.sample.sources.Duration
	 * @generated
	 */
	EClass getDuration();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.sample.sources.Duration#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see com.xored.sherlock.sample.sources.Duration#getTime()
	 * @see #getDuration()
	 * @generated
	 */
	EAttribute getDuration_Time();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.sample.sources.Sample <em>Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample</em>'.
	 * @see com.xored.sherlock.sample.sources.Sample
	 * @generated
	 */
	EClass getSample();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.sample.sources.Sample#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.xored.sherlock.sample.sources.Sample#getText()
	 * @see #getSample()
	 * @generated
	 */
	EAttribute getSample_Text();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SourcesFactory getSourcesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.sample.sources.impl.DateImpl <em>Date</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.sample.sources.impl.DateImpl
		 * @see com.xored.sherlock.sample.sources.impl.SourcesPackageImpl#getDate()
		 * @generated
		 */
		EClass DATE = eINSTANCE.getDate();
		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__TIME = eINSTANCE.getDate_Time();
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.sample.sources.impl.DurationImpl <em>Duration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.sample.sources.impl.DurationImpl
		 * @see com.xored.sherlock.sample.sources.impl.SourcesPackageImpl#getDuration()
		 * @generated
		 */
		EClass DURATION = eINSTANCE.getDuration();
		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DURATION__TIME = eINSTANCE.getDuration_Time();
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.sample.sources.impl.SampleImpl <em>Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.sample.sources.impl.SampleImpl
		 * @see com.xored.sherlock.sample.sources.impl.SourcesPackageImpl#getSample()
		 * @generated
		 */
		EClass SAMPLE = eINSTANCE.getSample();
		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLE__TEXT = eINSTANCE.getSample_Text();

	}

} //SourcesPackage
