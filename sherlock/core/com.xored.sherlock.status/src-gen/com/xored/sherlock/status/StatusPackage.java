/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.status;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.xored.sherlock.status.StatusFactory
 * @model kind="package"
 * @generated
 */
public interface StatusPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "status";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xored.com/sherlock/status.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.xored.sherlock.status";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatusPackage eINSTANCE = com.xored.sherlock.status.impl.StatusPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.xored.sherlock.status.impl.JavaExceptionImpl <em>Java Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.status.impl.JavaExceptionImpl
	 * @see com.xored.sherlock.status.impl.StatusPackageImpl#getJavaException()
	 * @generated
	 */
	int JAVA_EXCEPTION = 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_EXCEPTION__CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_EXCEPTION__CAUSE = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_EXCEPTION__MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_EXCEPTION__STACKTRACE = 3;

	/**
	 * The number of structural features of the '<em>Java Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_EXCEPTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.status.impl.JavaStackTraceEntryImpl <em>Java Stack Trace Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.status.impl.JavaStackTraceEntryImpl
	 * @see com.xored.sherlock.status.impl.StatusPackageImpl#getJavaStackTraceEntry()
	 * @generated
	 */
	int JAVA_STACK_TRACE_ENTRY = 1;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STACK_TRACE_ENTRY__FILE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STACK_TRACE_ENTRY__CLASS_NAME = 1;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STACK_TRACE_ENTRY__METHOD_NAME = 2;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STACK_TRACE_ENTRY__LINE_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STACK_TRACE_ENTRY__NATIVE = 4;

	/**
	 * The number of structural features of the '<em>Java Stack Trace Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STACK_TRACE_ENTRY_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.status.impl.StatusImpl <em>Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.status.impl.StatusImpl
	 * @see com.xored.sherlock.status.impl.StatusPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__CODE = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__TARGET = 3;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__SEVERITY = 4;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__EXCEPTION = 5;

	/**
	 * The number of structural features of the '<em>Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.status.Severity <em>Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.status.Severity
	 * @see com.xored.sherlock.status.impl.StatusPackageImpl#getSeverity()
	 * @generated
	 */
	int SEVERITY = 3;


	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.status.JavaException <em>Java Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Exception</em>'.
	 * @see com.xored.sherlock.status.JavaException
	 * @generated
	 */
	EClass getJavaException();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.JavaException#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see com.xored.sherlock.status.JavaException#getClassName()
	 * @see #getJavaException()
	 * @generated
	 */
	EAttribute getJavaException_ClassName();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.sherlock.status.JavaException#getCause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cause</em>'.
	 * @see com.xored.sherlock.status.JavaException#getCause()
	 * @see #getJavaException()
	 * @generated
	 */
	EReference getJavaException_Cause();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.JavaException#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see com.xored.sherlock.status.JavaException#getMessage()
	 * @see #getJavaException()
	 * @generated
	 */
	EAttribute getJavaException_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.status.JavaException#getStacktrace <em>Stacktrace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stacktrace</em>'.
	 * @see com.xored.sherlock.status.JavaException#getStacktrace()
	 * @see #getJavaException()
	 * @generated
	 */
	EReference getJavaException_Stacktrace();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.status.JavaStackTraceEntry <em>Java Stack Trace Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Stack Trace Entry</em>'.
	 * @see com.xored.sherlock.status.JavaStackTraceEntry
	 * @generated
	 */
	EClass getJavaStackTraceEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.JavaStackTraceEntry#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see com.xored.sherlock.status.JavaStackTraceEntry#getFileName()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_FileName();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.JavaStackTraceEntry#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see com.xored.sherlock.status.JavaStackTraceEntry#getClassName()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.JavaStackTraceEntry#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see com.xored.sherlock.status.JavaStackTraceEntry#getMethodName()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_MethodName();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.JavaStackTraceEntry#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see com.xored.sherlock.status.JavaStackTraceEntry#getLineNumber()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.JavaStackTraceEntry#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see com.xored.sherlock.status.JavaStackTraceEntry#isNative()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_Native();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.status.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status</em>'.
	 * @see com.xored.sherlock.status.Status
	 * @generated
	 */
	EClass getStatus();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.status.Status#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see com.xored.sherlock.status.Status#getChildren()
	 * @see #getStatus()
	 * @generated
	 */
	EReference getStatus_Children();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.Status#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.xored.sherlock.status.Status#getCode()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.Status#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see com.xored.sherlock.status.Status#getMessage()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Message();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.Status#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see com.xored.sherlock.status.Status#getTarget()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Target();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.status.Status#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see com.xored.sherlock.status.Status#getSeverity()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Severity();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.sherlock.status.Status#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exception</em>'.
	 * @see com.xored.sherlock.status.Status#getException()
	 * @see #getStatus()
	 * @generated
	 */
	EReference getStatus_Exception();

	/**
	 * Returns the meta object for enum '{@link com.xored.sherlock.status.Severity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Severity</em>'.
	 * @see com.xored.sherlock.status.Severity
	 * @generated
	 */
	EEnum getSeverity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StatusFactory getStatusFactory();

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
		 * The meta object literal for the '{@link com.xored.sherlock.status.impl.JavaExceptionImpl <em>Java Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.status.impl.JavaExceptionImpl
		 * @see com.xored.sherlock.status.impl.StatusPackageImpl#getJavaException()
		 * @generated
		 */
		EClass JAVA_EXCEPTION = eINSTANCE.getJavaException();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_EXCEPTION__CLASS_NAME = eINSTANCE.getJavaException_ClassName();

		/**
		 * The meta object literal for the '<em><b>Cause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_EXCEPTION__CAUSE = eINSTANCE.getJavaException_Cause();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_EXCEPTION__MESSAGE = eINSTANCE.getJavaException_Message();

		/**
		 * The meta object literal for the '<em><b>Stacktrace</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_EXCEPTION__STACKTRACE = eINSTANCE.getJavaException_Stacktrace();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.status.impl.JavaStackTraceEntryImpl <em>Java Stack Trace Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.status.impl.JavaStackTraceEntryImpl
		 * @see com.xored.sherlock.status.impl.StatusPackageImpl#getJavaStackTraceEntry()
		 * @generated
		 */
		EClass JAVA_STACK_TRACE_ENTRY = eINSTANCE.getJavaStackTraceEntry();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_STACK_TRACE_ENTRY__FILE_NAME = eINSTANCE.getJavaStackTraceEntry_FileName();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_STACK_TRACE_ENTRY__CLASS_NAME = eINSTANCE.getJavaStackTraceEntry_ClassName();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_STACK_TRACE_ENTRY__METHOD_NAME = eINSTANCE.getJavaStackTraceEntry_MethodName();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_STACK_TRACE_ENTRY__LINE_NUMBER = eINSTANCE.getJavaStackTraceEntry_LineNumber();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_STACK_TRACE_ENTRY__NATIVE = eINSTANCE.getJavaStackTraceEntry_Native();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.status.impl.StatusImpl <em>Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.status.impl.StatusImpl
		 * @see com.xored.sherlock.status.impl.StatusPackageImpl#getStatus()
		 * @generated
		 */
		EClass STATUS = eINSTANCE.getStatus();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATUS__CHILDREN = eINSTANCE.getStatus_Children();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__CODE = eINSTANCE.getStatus_Code();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__MESSAGE = eINSTANCE.getStatus_Message();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__TARGET = eINSTANCE.getStatus_Target();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__SEVERITY = eINSTANCE.getStatus_Severity();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATUS__EXCEPTION = eINSTANCE.getStatus_Exception();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.status.Severity <em>Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.status.Severity
		 * @see com.xored.sherlock.status.impl.StatusPackageImpl#getSeverity()
		 * @generated
		 */
		EEnum SEVERITY = eINSTANCE.getSeverity();

	}

} //StatusPackage
