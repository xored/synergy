/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.thread;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see com.xored.sherlock.thread.ThreadFactory
 * @model kind="package"
 * @generated
 */
public interface ThreadPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "thread";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xored.com/sherlock/thread.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.xored.sherlock.thread";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ThreadPackage eINSTANCE = com.xored.sherlock.thread.impl.ThreadPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.xored.sherlock.thread.impl.ThreadImpl <em>Thread</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.thread.impl.ThreadImpl
	 * @see com.xored.sherlock.thread.impl.ThreadPackageImpl#getThread()
	 * @generated
	 */
	int THREAD = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__ID = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__STATE = 2;

	/**
	 * The number of structural features of the '<em>Thread</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link com.xored.sherlock.thread.ThreadState <em>State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.thread.ThreadState
	 * @see com.xored.sherlock.thread.impl.ThreadPackageImpl#getThreadState()
	 * @generated
	 */
	int THREAD_STATE = 1;


	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.thread.Thread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thread</em>'.
	 * @see com.xored.sherlock.thread.Thread
	 * @generated
	 */
	EClass getThread();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.thread.Thread#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.xored.sherlock.thread.Thread#getName()
	 * @see #getThread()
	 * @generated
	 */
	EAttribute getThread_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.thread.Thread#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.xored.sherlock.thread.Thread#getId()
	 * @see #getThread()
	 * @generated
	 */
	EAttribute getThread_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.thread.Thread#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.xored.sherlock.thread.Thread#getState()
	 * @see #getThread()
	 * @generated
	 */
	EAttribute getThread_State();

	/**
	 * Returns the meta object for enum '{@link com.xored.sherlock.thread.ThreadState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State</em>'.
	 * @see com.xored.sherlock.thread.ThreadState
	 * @generated
	 */
	EEnum getThreadState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ThreadFactory getThreadFactory();

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
		 * The meta object literal for the '{@link com.xored.sherlock.thread.impl.ThreadImpl <em>Thread</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.thread.impl.ThreadImpl
		 * @see com.xored.sherlock.thread.impl.ThreadPackageImpl#getThread()
		 * @generated
		 */
		EClass THREAD = eINSTANCE.getThread();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD__NAME = eINSTANCE.getThread_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD__ID = eINSTANCE.getThread_Id();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD__STATE = eINSTANCE.getThread_State();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.thread.ThreadState <em>State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.thread.ThreadState
		 * @see com.xored.sherlock.thread.impl.ThreadPackageImpl#getThreadState()
		 * @generated
		 */
		EEnum THREAD_STATE = eINSTANCE.getThreadState();

	}

} //ThreadPackage
