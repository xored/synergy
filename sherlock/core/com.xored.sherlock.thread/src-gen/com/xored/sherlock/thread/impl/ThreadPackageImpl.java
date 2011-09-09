/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.thread.impl;

import com.xored.sherlock.thread.ThreadFactory;
import com.xored.sherlock.thread.ThreadPackage;

import com.xored.sherlock.thread.ThreadState;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ThreadPackageImpl extends EPackageImpl implements ThreadPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum threadStateEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.xored.sherlock.thread.ThreadPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ThreadPackageImpl() {
		super(eNS_URI, ThreadFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ThreadPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ThreadPackage init() {
		if (isInited) return (ThreadPackage)EPackage.Registry.INSTANCE.getEPackage(ThreadPackage.eNS_URI);

		// Obtain or create and register package
		ThreadPackageImpl theThreadPackage = (ThreadPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ThreadPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ThreadPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theThreadPackage.createPackageContents();

		// Initialize created meta-data
		theThreadPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theThreadPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ThreadPackage.eNS_URI, theThreadPackage);
		return theThreadPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThread() {
		return threadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThread_Name() {
		return (EAttribute)threadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThread_Id() {
		return (EAttribute)threadEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThread_State() {
		return (EAttribute)threadEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getThreadState() {
		return threadStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreadFactory getThreadFactory() {
		return (ThreadFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		threadEClass = createEClass(THREAD);
		createEAttribute(threadEClass, THREAD__NAME);
		createEAttribute(threadEClass, THREAD__ID);
		createEAttribute(threadEClass, THREAD__STATE);

		// Create enums
		threadStateEEnum = createEEnum(THREAD_STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(threadEClass, com.xored.sherlock.thread.Thread.class, "Thread", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThread_Name(), ecorePackage.getEString(), "name", null, 0, 1, com.xored.sherlock.thread.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThread_Id(), ecorePackage.getELong(), "id", null, 0, 1, com.xored.sherlock.thread.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThread_State(), this.getThreadState(), "state", null, 0, 1, com.xored.sherlock.thread.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(threadStateEEnum, ThreadState.class, "ThreadState");
		addEEnumLiteral(threadStateEEnum, ThreadState.NEW);
		addEEnumLiteral(threadStateEEnum, ThreadState.RUNNABLE);
		addEEnumLiteral(threadStateEEnum, ThreadState.BLOCKED);
		addEEnumLiteral(threadStateEEnum, ThreadState.WAITING);
		addEEnumLiteral(threadStateEEnum, ThreadState.TIMED_WAITING);
		addEEnumLiteral(threadStateEEnum, ThreadState.TERMINATED);

		// Create resource
		createResource(eNS_URI);
	}

} //ThreadPackageImpl
