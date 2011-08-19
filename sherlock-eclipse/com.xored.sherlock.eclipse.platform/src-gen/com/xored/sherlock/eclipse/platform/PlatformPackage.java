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
	 * The number of structural features of the '<em>Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_FEATURE_COUNT = 11;


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

	}

} //PlatformPackage
