/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.eclipse.platform;

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
 * @see com.xored.sherlock.eclipse.platform.PlatformFactory
 * @model kind="package"
 * @generated
 */
public interface PlatformPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "platform";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xored.com/sherlock/eclipse/platform.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.xored.sherlock.eclipse.platform";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PlatformPackage eINSTANCE = com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl <em>Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.eclipse.platform.impl.PlatformImpl
	 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getPlatform()
	 * @generated
	 */
	int PLATFORM = 0;

	/**
	 * The feature id for the '<em><b>Workspace Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__WORKSPACE_LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__PRODUCT_ID = 1;

	/**
	 * The feature id for the '<em><b>Application Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__APPLICATION_ID = 2;

	/**
	 * The feature id for the '<em><b>Application Args</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__APPLICATION_ARGS = 3;

	/**
	 * The feature id for the '<em><b>Build Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__BUILD_ID = 4;

	/**
	 * The feature id for the '<em><b>Uptime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__UPTIME = 5;

	/**
	 * The feature id for the '<em><b>Plugins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__PLUGINS = 6;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__FEATURES = 7;

	/**
	 * The feature id for the '<em><b>Workspace Partition Total Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__WORKSPACE_PARTITION_TOTAL_DISKSPACE = 8;

	/**
	 * The feature id for the '<em><b>Workspace Partition Usable Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__WORKSPACE_PARTITION_USABLE_DISKSPACE = 9;

	/**
	 * The feature id for the '<em><b>Workspace Partition Free Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__WORKSPACE_PARTITION_FREE_DISKSPACE = 10;

	/**
	 * The feature id for the '<em><b>Preferences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__PREFERENCES = 11;

	/**
	 * The number of structural features of the '<em>Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_FEATURE_COUNT = 12;


	/**
	 * The meta object id for the '{@link com.xored.sherlock.eclipse.platform.impl.PluginImpl <em>Plugin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.eclipse.platform.impl.PluginImpl
	 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getPlugin()
	 * @generated
	 */
	int PLUGIN = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__NAME = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__PROVIDER = 3;

	/**
	 * The number of structural features of the '<em>Plugin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.eclipse.platform.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.eclipse.platform.impl.FeatureImpl
	 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PROVIDER = 3;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 4;


	/**
	 * The meta object id for the '{@link com.xored.sherlock.eclipse.platform.impl.StatusImpl <em>Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.eclipse.platform.impl.StatusImpl
	 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 3;

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
	 * The feature id for the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__PLUGIN = 3;

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
	 * The meta object id for the '{@link com.xored.sherlock.eclipse.platform.impl.JavaExceptionImpl <em>Java Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.eclipse.platform.impl.JavaExceptionImpl
	 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getJavaException()
	 * @generated
	 */
	int JAVA_EXCEPTION = 4;

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
	 * The meta object id for the '{@link com.xored.sherlock.eclipse.platform.impl.JavaStackTraceEntryImpl <em>Java Stack Trace Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.eclipse.platform.impl.JavaStackTraceEntryImpl
	 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getJavaStackTraceEntry()
	 * @generated
	 */
	int JAVA_STACK_TRACE_ENTRY = 5;

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
	 * The meta object id for the '{@link com.xored.sherlock.eclipse.platform.impl.PreferenceImpl <em>Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.eclipse.platform.impl.PreferenceImpl
	 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getPreference()
	 * @generated
	 */
	int PREFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE__PATH = 2;

	/**
	 * The number of structural features of the '<em>Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFERENCE_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.eclipse.platform.Platform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platform</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform
	 * @generated
	 */
	EClass getPlatform();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspaceLocation <em>Workspace Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workspace Location</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getWorkspaceLocation()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_WorkspaceLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Platform#getProductId <em>Product Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Id</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getProductId()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_ProductId();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Platform#getApplicationId <em>Application Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Id</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getApplicationId()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_ApplicationId();

	/**
	 * Returns the meta object for the attribute list '{@link com.xored.sherlock.eclipse.platform.Platform#getApplicationArgs <em>Application Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Application Args</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getApplicationArgs()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_ApplicationArgs();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Platform#getBuildId <em>Build Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Build Id</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getBuildId()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_BuildId();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Platform#getUptime <em>Uptime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uptime</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getUptime()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_Uptime();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.eclipse.platform.Platform#getPlugins <em>Plugins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plugins</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getPlugins()
	 * @see #getPlatform()
	 * @generated
	 */
	EReference getPlatform_Plugins();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.eclipse.platform.Platform#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getFeatures()
	 * @see #getPlatform()
	 * @generated
	 */
	EReference getPlatform_Features();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionTotalDiskspace <em>Workspace Partition Total Diskspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workspace Partition Total Diskspace</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionTotalDiskspace()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_WorkspacePartitionTotalDiskspace();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionUsableDiskspace <em>Workspace Partition Usable Diskspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workspace Partition Usable Diskspace</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionUsableDiskspace()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_WorkspacePartitionUsableDiskspace();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionFreeDiskspace <em>Workspace Partition Free Diskspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workspace Partition Free Diskspace</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionFreeDiskspace()
	 * @see #getPlatform()
	 * @generated
	 */
	EAttribute getPlatform_WorkspacePartitionFreeDiskspace();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.eclipse.platform.Platform#getPreferences <em>Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preferences</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Platform#getPreferences()
	 * @see #getPlatform()
	 * @generated
	 */
	EReference getPlatform_Preferences();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.eclipse.platform.Plugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Plugin
	 * @generated
	 */
	EClass getPlugin();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Plugin#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Plugin#getId()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Plugin#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Plugin#getName()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Plugin#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Plugin#getVersion()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Plugin#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Plugin#getProvider()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Provider();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.eclipse.platform.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Feature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Feature#getId()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Feature#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Feature#getVersion()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Feature#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Feature#getProvider()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Provider();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.eclipse.platform.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Status
	 * @generated
	 */
	EClass getStatus();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.eclipse.platform.Status#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Status#getChildren()
	 * @see #getStatus()
	 * @generated
	 */
	EReference getStatus_Children();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Status#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Status#getCode()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Code();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Status#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Status#getMessage()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Message();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Status#getPlugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Status#getPlugin()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Plugin();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Status#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Status#getSeverity()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Severity();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.sherlock.eclipse.platform.Status#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exception</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Status#getException()
	 * @see #getStatus()
	 * @generated
	 */
	EReference getStatus_Exception();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.eclipse.platform.JavaException <em>Java Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Exception</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaException
	 * @generated
	 */
	EClass getJavaException();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.JavaException#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaException#getClassName()
	 * @see #getJavaException()
	 * @generated
	 */
	EAttribute getJavaException_ClassName();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.sherlock.eclipse.platform.JavaException#getCause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cause</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaException#getCause()
	 * @see #getJavaException()
	 * @generated
	 */
	EReference getJavaException_Cause();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.JavaException#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaException#getMessage()
	 * @see #getJavaException()
	 * @generated
	 */
	EAttribute getJavaException_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.eclipse.platform.JavaException#getStacktrace <em>Stacktrace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stacktrace</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaException#getStacktrace()
	 * @see #getJavaException()
	 * @generated
	 */
	EReference getJavaException_Stacktrace();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.eclipse.platform.JavaStackTraceEntry <em>Java Stack Trace Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Stack Trace Entry</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaStackTraceEntry
	 * @generated
	 */
	EClass getJavaStackTraceEntry();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#getFileName()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_FileName();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#getClassName()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#getMethodName()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_MethodName();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#getLineNumber()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see com.xored.sherlock.eclipse.platform.JavaStackTraceEntry#isNative()
	 * @see #getJavaStackTraceEntry()
	 * @generated
	 */
	EAttribute getJavaStackTraceEntry_Native();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.eclipse.platform.Preference <em>Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Preference</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Preference
	 * @generated
	 */
	EClass getPreference();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Preference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Preference#getName()
	 * @see #getPreference()
	 * @generated
	 */
	EAttribute getPreference_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Preference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Preference#getValue()
	 * @see #getPreference()
	 * @generated
	 */
	EAttribute getPreference_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.platform.Preference#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see com.xored.sherlock.eclipse.platform.Preference#getPath()
	 * @see #getPreference()
	 * @generated
	 */
	EAttribute getPreference_Path();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PlatformFactory getPlatformFactory();

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
		 * The meta object literal for the '{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl <em>Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.eclipse.platform.impl.PlatformImpl
		 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getPlatform()
		 * @generated
		 */
		EClass PLATFORM = eINSTANCE.getPlatform();
		/**
		 * The meta object literal for the '<em><b>Workspace Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__WORKSPACE_LOCATION = eINSTANCE.getPlatform_WorkspaceLocation();
		/**
		 * The meta object literal for the '<em><b>Product Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__PRODUCT_ID = eINSTANCE.getPlatform_ProductId();
		/**
		 * The meta object literal for the '<em><b>Application Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__APPLICATION_ID = eINSTANCE.getPlatform_ApplicationId();
		/**
		 * The meta object literal for the '<em><b>Application Args</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__APPLICATION_ARGS = eINSTANCE.getPlatform_ApplicationArgs();
		/**
		 * The meta object literal for the '<em><b>Build Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__BUILD_ID = eINSTANCE.getPlatform_BuildId();
		/**
		 * The meta object literal for the '<em><b>Uptime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__UPTIME = eINSTANCE.getPlatform_Uptime();
		/**
		 * The meta object literal for the '<em><b>Plugins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLATFORM__PLUGINS = eINSTANCE.getPlatform_Plugins();
		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLATFORM__FEATURES = eINSTANCE.getPlatform_Features();
		/**
		 * The meta object literal for the '<em><b>Workspace Partition Total Diskspace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__WORKSPACE_PARTITION_TOTAL_DISKSPACE = eINSTANCE.getPlatform_WorkspacePartitionTotalDiskspace();
		/**
		 * The meta object literal for the '<em><b>Workspace Partition Usable Diskspace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__WORKSPACE_PARTITION_USABLE_DISKSPACE = eINSTANCE.getPlatform_WorkspacePartitionUsableDiskspace();
		/**
		 * The meta object literal for the '<em><b>Workspace Partition Free Diskspace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM__WORKSPACE_PARTITION_FREE_DISKSPACE = eINSTANCE.getPlatform_WorkspacePartitionFreeDiskspace();
		/**
		 * The meta object literal for the '<em><b>Preferences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLATFORM__PREFERENCES = eINSTANCE.getPlatform_Preferences();
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.eclipse.platform.impl.PluginImpl <em>Plugin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.eclipse.platform.impl.PluginImpl
		 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getPlugin()
		 * @generated
		 */
		EClass PLUGIN = eINSTANCE.getPlugin();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__ID = eINSTANCE.getPlugin_Id();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__NAME = eINSTANCE.getPlugin_Name();
		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__VERSION = eINSTANCE.getPlugin_Version();
		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__PROVIDER = eINSTANCE.getPlugin_Provider();
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.eclipse.platform.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.eclipse.platform.impl.FeatureImpl
		 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__ID = eINSTANCE.getFeature_Id();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();
		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__VERSION = eINSTANCE.getFeature_Version();
		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__PROVIDER = eINSTANCE.getFeature_Provider();
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.eclipse.platform.impl.StatusImpl <em>Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.eclipse.platform.impl.StatusImpl
		 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getStatus()
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
		 * The meta object literal for the '<em><b>Plugin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__PLUGIN = eINSTANCE.getStatus_Plugin();
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
		 * The meta object literal for the '{@link com.xored.sherlock.eclipse.platform.impl.JavaExceptionImpl <em>Java Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.eclipse.platform.impl.JavaExceptionImpl
		 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getJavaException()
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
		 * The meta object literal for the '{@link com.xored.sherlock.eclipse.platform.impl.JavaStackTraceEntryImpl <em>Java Stack Trace Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.eclipse.platform.impl.JavaStackTraceEntryImpl
		 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getJavaStackTraceEntry()
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
		 * The meta object literal for the '{@link com.xored.sherlock.eclipse.platform.impl.PreferenceImpl <em>Preference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.eclipse.platform.impl.PreferenceImpl
		 * @see com.xored.sherlock.eclipse.platform.impl.PlatformPackageImpl#getPreference()
		 * @generated
		 */
		EClass PREFERENCE = eINSTANCE.getPreference();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE__NAME = eINSTANCE.getPreference_Name();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE__VALUE = eINSTANCE.getPreference_Value();
		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFERENCE__PATH = eINSTANCE.getPreference_Path();

	}

} //PlatformPackage
