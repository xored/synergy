/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.eclipse.platform;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Platform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspaceLocation <em>Workspace Location</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getApplicationId <em>Application Id</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getApplicationArgs <em>Application Args</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getBuildId <em>Build Id</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getUptime <em>Uptime</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionTotalDiskspace <em>Workspace Partition Total Diskspace</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionUsableDiskspace <em>Workspace Partition Usable Diskspace</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionFreeDiskspace <em>Workspace Partition Free Diskspace</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform()
 * @model
 * @generated
 */
public interface Platform extends EObject {

	/**
	 * Returns the value of the '<em><b>Workspace Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Location</em>' attribute.
	 * @see #setWorkspaceLocation(String)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_WorkspaceLocation()
	 * @model
	 * @generated
	 */
	String getWorkspaceLocation();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspaceLocation <em>Workspace Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Location</em>' attribute.
	 * @see #getWorkspaceLocation()
	 * @generated
	 */
	void setWorkspaceLocation(String value);

	/**
	 * Returns the value of the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Id</em>' attribute.
	 * @see #setProductId(String)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_ProductId()
	 * @model
	 * @generated
	 */
	String getProductId();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Platform#getProductId <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Id</em>' attribute.
	 * @see #getProductId()
	 * @generated
	 */
	void setProductId(String value);

	/**
	 * Returns the value of the '<em><b>Application Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Id</em>' attribute.
	 * @see #setApplicationId(String)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_ApplicationId()
	 * @model
	 * @generated
	 */
	String getApplicationId();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Platform#getApplicationId <em>Application Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Id</em>' attribute.
	 * @see #getApplicationId()
	 * @generated
	 */
	void setApplicationId(String value);

	/**
	 * Returns the value of the '<em><b>Application Args</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Args</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Args</em>' attribute list.
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_ApplicationArgs()
	 * @model
	 * @generated
	 */
	EList<String> getApplicationArgs();

	/**
	 * Returns the value of the '<em><b>Build Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Build Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build Id</em>' attribute.
	 * @see #setBuildId(String)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_BuildId()
	 * @model
	 * @generated
	 */
	String getBuildId();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Platform#getBuildId <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Id</em>' attribute.
	 * @see #getBuildId()
	 * @generated
	 */
	void setBuildId(String value);

	/**
	 * Returns the value of the '<em><b>Uptime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uptime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uptime</em>' attribute.
	 * @see #setUptime(long)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_Uptime()
	 * @model
	 * @generated
	 */
	long getUptime();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Platform#getUptime <em>Uptime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uptime</em>' attribute.
	 * @see #getUptime()
	 * @generated
	 */
	void setUptime(long value);

	/**
	 * Returns the value of the '<em><b>Plugins</b></em>' containment reference list.
	 * The list contents are of type {@link com.xored.sherlock.eclipse.platform.Plugin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugins</em>' containment reference list.
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_Plugins()
	 * @model containment="true"
	 * @generated
	 */
	EList<Plugin> getPlugins();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link com.xored.sherlock.eclipse.platform.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Workspace Partition Total Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Partition Total Diskspace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Partition Total Diskspace</em>' attribute.
	 * @see #setWorkspacePartitionTotalDiskspace(long)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_WorkspacePartitionTotalDiskspace()
	 * @model
	 * @generated
	 */
	long getWorkspacePartitionTotalDiskspace();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionTotalDiskspace <em>Workspace Partition Total Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Partition Total Diskspace</em>' attribute.
	 * @see #getWorkspacePartitionTotalDiskspace()
	 * @generated
	 */
	void setWorkspacePartitionTotalDiskspace(long value);

	/**
	 * Returns the value of the '<em><b>Workspace Partition Usable Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Partition Usable Diskspace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Partition Usable Diskspace</em>' attribute.
	 * @see #setWorkspacePartitionUsableDiskspace(long)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_WorkspacePartitionUsableDiskspace()
	 * @model
	 * @generated
	 */
	long getWorkspacePartitionUsableDiskspace();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionUsableDiskspace <em>Workspace Partition Usable Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Partition Usable Diskspace</em>' attribute.
	 * @see #getWorkspacePartitionUsableDiskspace()
	 * @generated
	 */
	void setWorkspacePartitionUsableDiskspace(long value);

	/**
	 * Returns the value of the '<em><b>Workspace Partition Free Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Partition Free Diskspace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Partition Free Diskspace</em>' attribute.
	 * @see #setWorkspacePartitionFreeDiskspace(long)
	 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPlatform_WorkspacePartitionFreeDiskspace()
	 * @model
	 * @generated
	 */
	long getWorkspacePartitionFreeDiskspace();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.platform.Platform#getWorkspacePartitionFreeDiskspace <em>Workspace Partition Free Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Partition Free Diskspace</em>' attribute.
	 * @see #getWorkspacePartitionFreeDiskspace()
	 * @generated
	 */
	void setWorkspacePartitionFreeDiskspace(long value);
} // Platform
