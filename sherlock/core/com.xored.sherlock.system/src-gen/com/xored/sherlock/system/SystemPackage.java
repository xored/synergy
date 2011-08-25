/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.system;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.xored.sherlock.system.SystemFactory
 * @model kind="package"
 * @generated
 */
public interface SystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "system";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xored.com/sherlock/system.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.xored.sherlock.system";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SystemPackage eINSTANCE = com.xored.sherlock.system.impl.SystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.xored.sherlock.system.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.system.impl.SystemImpl
	 * @see com.xored.sherlock.system.impl.SystemPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Os Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OS_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Os Arch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OS_ARCH = 2;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__USERNAME = 3;

	/**
	 * The feature id for the '<em><b>User Home</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__USER_HOME = 4;

	/**
	 * The feature id for the '<em><b>Work Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__WORK_DIR = 5;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__LANGUAGE = 6;

	/**
	 * The feature id for the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__REGION = 7;

	/**
	 * The feature id for the '<em><b>Timezone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__TIMEZONE = 8;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__VARIABLES = 9;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 10;


	/**
	 * The meta object id for the '{@link com.xored.sherlock.system.impl.JavaImpl <em>Java</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.system.impl.JavaImpl
	 * @see com.xored.sherlock.system.impl.SystemPackageImpl#getJava()
	 * @generated
	 */
	int JAVA = 1;

	/**
	 * The feature id for the '<em><b>Runtime Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA__RUNTIME_NAME = 0;

	/**
	 * The feature id for the '<em><b>Runtime Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA__RUNTIME_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Max Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA__MAX_MEMORY = 2;

	/**
	 * The feature id for the '<em><b>Free Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA__FREE_MEMORY = 3;

	/**
	 * The feature id for the '<em><b>Total Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA__TOTAL_MEMORY = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA__PROPERTIES = 5;

	/**
	 * The number of structural features of the '<em>Java</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.system.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.system.impl.EntryImpl
	 * @see com.xored.sherlock.system.impl.SystemPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.system.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see com.xored.sherlock.system.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.System#getOsName <em>Os Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Name</em>'.
	 * @see com.xored.sherlock.system.System#getOsName()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_OsName();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.System#getOsVersion <em>Os Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Version</em>'.
	 * @see com.xored.sherlock.system.System#getOsVersion()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_OsVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.System#getOsArch <em>Os Arch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Arch</em>'.
	 * @see com.xored.sherlock.system.System#getOsArch()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_OsArch();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.System#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see com.xored.sherlock.system.System#getUsername()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Username();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.System#getUserHome <em>User Home</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Home</em>'.
	 * @see com.xored.sherlock.system.System#getUserHome()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_UserHome();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.System#getWorkDir <em>Work Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Work Dir</em>'.
	 * @see com.xored.sherlock.system.System#getWorkDir()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_WorkDir();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.System#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see com.xored.sherlock.system.System#getLanguage()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Language();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.System#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Region</em>'.
	 * @see com.xored.sherlock.system.System#getRegion()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Region();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.System#getTimezone <em>Timezone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timezone</em>'.
	 * @see com.xored.sherlock.system.System#getTimezone()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Timezone();

	/**
	 * Returns the meta object for the map '{@link com.xored.sherlock.system.System#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Variables</em>'.
	 * @see com.xored.sherlock.system.System#getVariables()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Variables();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.system.Java <em>Java</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java</em>'.
	 * @see com.xored.sherlock.system.Java
	 * @generated
	 */
	EClass getJava();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.Java#getRuntimeName <em>Runtime Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runtime Name</em>'.
	 * @see com.xored.sherlock.system.Java#getRuntimeName()
	 * @see #getJava()
	 * @generated
	 */
	EAttribute getJava_RuntimeName();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.Java#getRuntimeVersion <em>Runtime Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runtime Version</em>'.
	 * @see com.xored.sherlock.system.Java#getRuntimeVersion()
	 * @see #getJava()
	 * @generated
	 */
	EAttribute getJava_RuntimeVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.Java#getMaxMemory <em>Max Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Memory</em>'.
	 * @see com.xored.sherlock.system.Java#getMaxMemory()
	 * @see #getJava()
	 * @generated
	 */
	EAttribute getJava_MaxMemory();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.Java#getFreeMemory <em>Free Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Free Memory</em>'.
	 * @see com.xored.sherlock.system.Java#getFreeMemory()
	 * @see #getJava()
	 * @generated
	 */
	EAttribute getJava_FreeMemory();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.system.Java#getTotalMemory <em>Total Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Memory</em>'.
	 * @see com.xored.sherlock.system.Java#getTotalMemory()
	 * @see #getJava()
	 * @generated
	 */
	EAttribute getJava_TotalMemory();

	/**
	 * Returns the meta object for the map '{@link com.xored.sherlock.system.Java#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see com.xored.sherlock.system.Java#getProperties()
	 * @see #getJava()
	 * @generated
	 */
	EReference getJava_Properties();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SystemFactory getSystemFactory();

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
		 * The meta object literal for the '{@link com.xored.sherlock.system.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.system.impl.SystemImpl
		 * @see com.xored.sherlock.system.impl.SystemPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();
		/**
		 * The meta object literal for the '<em><b>Os Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__OS_NAME = eINSTANCE.getSystem_OsName();
		/**
		 * The meta object literal for the '<em><b>Os Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__OS_VERSION = eINSTANCE.getSystem_OsVersion();
		/**
		 * The meta object literal for the '<em><b>Os Arch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__OS_ARCH = eINSTANCE.getSystem_OsArch();
		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__USERNAME = eINSTANCE.getSystem_Username();
		/**
		 * The meta object literal for the '<em><b>User Home</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__USER_HOME = eINSTANCE.getSystem_UserHome();
		/**
		 * The meta object literal for the '<em><b>Work Dir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__WORK_DIR = eINSTANCE.getSystem_WorkDir();
		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__LANGUAGE = eINSTANCE.getSystem_Language();
		/**
		 * The meta object literal for the '<em><b>Region</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__REGION = eINSTANCE.getSystem_Region();
		/**
		 * The meta object literal for the '<em><b>Timezone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__TIMEZONE = eINSTANCE.getSystem_Timezone();
		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__VARIABLES = eINSTANCE.getSystem_Variables();
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.system.impl.JavaImpl <em>Java</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.system.impl.JavaImpl
		 * @see com.xored.sherlock.system.impl.SystemPackageImpl#getJava()
		 * @generated
		 */
		EClass JAVA = eINSTANCE.getJava();
		/**
		 * The meta object literal for the '<em><b>Runtime Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA__RUNTIME_NAME = eINSTANCE.getJava_RuntimeName();
		/**
		 * The meta object literal for the '<em><b>Runtime Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA__RUNTIME_VERSION = eINSTANCE.getJava_RuntimeVersion();
		/**
		 * The meta object literal for the '<em><b>Max Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA__MAX_MEMORY = eINSTANCE.getJava_MaxMemory();
		/**
		 * The meta object literal for the '<em><b>Free Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA__FREE_MEMORY = eINSTANCE.getJava_FreeMemory();
		/**
		 * The meta object literal for the '<em><b>Total Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA__TOTAL_MEMORY = eINSTANCE.getJava_TotalMemory();
		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA__PROPERTIES = eINSTANCE.getJava_Properties();
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.system.impl.EntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.system.impl.EntryImpl
		 * @see com.xored.sherlock.system.impl.SystemPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();
		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY__KEY = eINSTANCE.getEntry_Key();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY__VALUE = eINSTANCE.getEntry_Value();

	}

} //SystemPackage
