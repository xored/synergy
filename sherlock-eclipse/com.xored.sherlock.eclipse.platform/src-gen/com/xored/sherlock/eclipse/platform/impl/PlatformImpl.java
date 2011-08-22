/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.eclipse.platform.impl;

import com.xored.sherlock.eclipse.platform.Feature;
import com.xored.sherlock.eclipse.platform.Platform;
import com.xored.sherlock.eclipse.platform.PlatformPackage;

import com.xored.sherlock.eclipse.platform.Plugin;
import com.xored.sherlock.eclipse.platform.Preference;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Platform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getWorkspaceLocation <em>Workspace Location</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getApplicationId <em>Application Id</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getApplicationArgs <em>Application Args</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getBuildId <em>Build Id</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getUptime <em>Uptime</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getWorkspacePartitionTotalDiskspace <em>Workspace Partition Total Diskspace</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getWorkspacePartitionUsableDiskspace <em>Workspace Partition Usable Diskspace</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getWorkspacePartitionFreeDiskspace <em>Workspace Partition Free Diskspace</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.PlatformImpl#getPreferences <em>Preferences</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlatformImpl extends EObjectImpl implements Platform {
	/**
	 * The default value of the '{@link #getWorkspaceLocation() <em>Workspace Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspaceLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String WORKSPACE_LOCATION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getWorkspaceLocation() <em>Workspace Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspaceLocation()
	 * @generated
	 * @ordered
	 */
	protected String workspaceLocation = WORKSPACE_LOCATION_EDEFAULT;
	/**
	 * The default value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductId()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductId()
	 * @generated
	 * @ordered
	 */
	protected String productId = PRODUCT_ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getApplicationId() <em>Application Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationId()
	 * @generated
	 * @ordered
	 */
	protected static final String APPLICATION_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getApplicationId() <em>Application Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationId()
	 * @generated
	 * @ordered
	 */
	protected String applicationId = APPLICATION_ID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getApplicationArgs() <em>Application Args</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<String> applicationArgs;
	/**
	 * The default value of the '{@link #getBuildId() <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildId()
	 * @generated
	 * @ordered
	 */
	protected static final String BUILD_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getBuildId() <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildId()
	 * @generated
	 * @ordered
	 */
	protected String buildId = BUILD_ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getUptime() <em>Uptime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUptime()
	 * @generated
	 * @ordered
	 */
	protected static final long UPTIME_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getUptime() <em>Uptime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUptime()
	 * @generated
	 * @ordered
	 */
	protected long uptime = UPTIME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getPlugins() <em>Plugins</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlugins()
	 * @generated
	 * @ordered
	 */
	protected EList<Plugin> plugins;
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;
	/**
	 * The default value of the '{@link #getWorkspacePartitionTotalDiskspace() <em>Workspace Partition Total Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionTotalDiskspace()
	 * @generated
	 * @ordered
	 */
	protected static final long WORKSPACE_PARTITION_TOTAL_DISKSPACE_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getWorkspacePartitionTotalDiskspace() <em>Workspace Partition Total Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionTotalDiskspace()
	 * @generated
	 * @ordered
	 */
	protected long workspacePartitionTotalDiskspace = WORKSPACE_PARTITION_TOTAL_DISKSPACE_EDEFAULT;
	/**
	 * The default value of the '{@link #getWorkspacePartitionUsableDiskspace() <em>Workspace Partition Usable Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionUsableDiskspace()
	 * @generated
	 * @ordered
	 */
	protected static final long WORKSPACE_PARTITION_USABLE_DISKSPACE_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getWorkspacePartitionUsableDiskspace() <em>Workspace Partition Usable Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionUsableDiskspace()
	 * @generated
	 * @ordered
	 */
	protected long workspacePartitionUsableDiskspace = WORKSPACE_PARTITION_USABLE_DISKSPACE_EDEFAULT;
	/**
	 * The default value of the '{@link #getWorkspacePartitionFreeDiskspace() <em>Workspace Partition Free Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionFreeDiskspace()
	 * @generated
	 * @ordered
	 */
	protected static final long WORKSPACE_PARTITION_FREE_DISKSPACE_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getWorkspacePartitionFreeDiskspace() <em>Workspace Partition Free Diskspace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspacePartitionFreeDiskspace()
	 * @generated
	 * @ordered
	 */
	protected long workspacePartitionFreeDiskspace = WORKSPACE_PARTITION_FREE_DISKSPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPreferences() <em>Preferences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Preference> preferences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PlatformPackage.Literals.PLATFORM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWorkspaceLocation() {
		return workspaceLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspaceLocation(String newWorkspaceLocation) {
		String oldWorkspaceLocation = workspaceLocation;
		workspaceLocation = newWorkspaceLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.PLATFORM__WORKSPACE_LOCATION, oldWorkspaceLocation, workspaceLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductId(String newProductId) {
		String oldProductId = productId;
		productId = newProductId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.PLATFORM__PRODUCT_ID, oldProductId, productId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationId(String newApplicationId) {
		String oldApplicationId = applicationId;
		applicationId = newApplicationId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.PLATFORM__APPLICATION_ID, oldApplicationId, applicationId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getApplicationArgs() {
		if (applicationArgs == null) {
			applicationArgs = new EDataTypeUniqueEList<String>(String.class, this, PlatformPackage.PLATFORM__APPLICATION_ARGS);
		}
		return applicationArgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBuildId() {
		return buildId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuildId(String newBuildId) {
		String oldBuildId = buildId;
		buildId = newBuildId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.PLATFORM__BUILD_ID, oldBuildId, buildId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getUptime() {
		return uptime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUptime(long newUptime) {
		long oldUptime = uptime;
		uptime = newUptime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.PLATFORM__UPTIME, oldUptime, uptime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Plugin> getPlugins() {
		if (plugins == null) {
			plugins = new EObjectContainmentEList<Plugin>(Plugin.class, this, PlatformPackage.PLATFORM__PLUGINS);
		}
		return plugins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<Feature>(Feature.class, this, PlatformPackage.PLATFORM__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getWorkspacePartitionTotalDiskspace() {
		return workspacePartitionTotalDiskspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspacePartitionTotalDiskspace(long newWorkspacePartitionTotalDiskspace) {
		long oldWorkspacePartitionTotalDiskspace = workspacePartitionTotalDiskspace;
		workspacePartitionTotalDiskspace = newWorkspacePartitionTotalDiskspace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.PLATFORM__WORKSPACE_PARTITION_TOTAL_DISKSPACE, oldWorkspacePartitionTotalDiskspace, workspacePartitionTotalDiskspace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getWorkspacePartitionUsableDiskspace() {
		return workspacePartitionUsableDiskspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspacePartitionUsableDiskspace(long newWorkspacePartitionUsableDiskspace) {
		long oldWorkspacePartitionUsableDiskspace = workspacePartitionUsableDiskspace;
		workspacePartitionUsableDiskspace = newWorkspacePartitionUsableDiskspace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.PLATFORM__WORKSPACE_PARTITION_USABLE_DISKSPACE, oldWorkspacePartitionUsableDiskspace, workspacePartitionUsableDiskspace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getWorkspacePartitionFreeDiskspace() {
		return workspacePartitionFreeDiskspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspacePartitionFreeDiskspace(long newWorkspacePartitionFreeDiskspace) {
		long oldWorkspacePartitionFreeDiskspace = workspacePartitionFreeDiskspace;
		workspacePartitionFreeDiskspace = newWorkspacePartitionFreeDiskspace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.PLATFORM__WORKSPACE_PARTITION_FREE_DISKSPACE, oldWorkspacePartitionFreeDiskspace, workspacePartitionFreeDiskspace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Preference> getPreferences() {
		if (preferences == null) {
			preferences = new EObjectContainmentEList<Preference>(Preference.class, this, PlatformPackage.PLATFORM__PREFERENCES);
		}
		return preferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PlatformPackage.PLATFORM__PLUGINS:
				return ((InternalEList<?>)getPlugins()).basicRemove(otherEnd, msgs);
			case PlatformPackage.PLATFORM__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case PlatformPackage.PLATFORM__PREFERENCES:
				return ((InternalEList<?>)getPreferences()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PlatformPackage.PLATFORM__WORKSPACE_LOCATION:
				return getWorkspaceLocation();
			case PlatformPackage.PLATFORM__PRODUCT_ID:
				return getProductId();
			case PlatformPackage.PLATFORM__APPLICATION_ID:
				return getApplicationId();
			case PlatformPackage.PLATFORM__APPLICATION_ARGS:
				return getApplicationArgs();
			case PlatformPackage.PLATFORM__BUILD_ID:
				return getBuildId();
			case PlatformPackage.PLATFORM__UPTIME:
				return getUptime();
			case PlatformPackage.PLATFORM__PLUGINS:
				return getPlugins();
			case PlatformPackage.PLATFORM__FEATURES:
				return getFeatures();
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_TOTAL_DISKSPACE:
				return getWorkspacePartitionTotalDiskspace();
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_USABLE_DISKSPACE:
				return getWorkspacePartitionUsableDiskspace();
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_FREE_DISKSPACE:
				return getWorkspacePartitionFreeDiskspace();
			case PlatformPackage.PLATFORM__PREFERENCES:
				return getPreferences();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PlatformPackage.PLATFORM__WORKSPACE_LOCATION:
				setWorkspaceLocation((String)newValue);
				return;
			case PlatformPackage.PLATFORM__PRODUCT_ID:
				setProductId((String)newValue);
				return;
			case PlatformPackage.PLATFORM__APPLICATION_ID:
				setApplicationId((String)newValue);
				return;
			case PlatformPackage.PLATFORM__APPLICATION_ARGS:
				getApplicationArgs().clear();
				getApplicationArgs().addAll((Collection<? extends String>)newValue);
				return;
			case PlatformPackage.PLATFORM__BUILD_ID:
				setBuildId((String)newValue);
				return;
			case PlatformPackage.PLATFORM__UPTIME:
				setUptime((Long)newValue);
				return;
			case PlatformPackage.PLATFORM__PLUGINS:
				getPlugins().clear();
				getPlugins().addAll((Collection<? extends Plugin>)newValue);
				return;
			case PlatformPackage.PLATFORM__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_TOTAL_DISKSPACE:
				setWorkspacePartitionTotalDiskspace((Long)newValue);
				return;
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_USABLE_DISKSPACE:
				setWorkspacePartitionUsableDiskspace((Long)newValue);
				return;
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_FREE_DISKSPACE:
				setWorkspacePartitionFreeDiskspace((Long)newValue);
				return;
			case PlatformPackage.PLATFORM__PREFERENCES:
				getPreferences().clear();
				getPreferences().addAll((Collection<? extends Preference>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PlatformPackage.PLATFORM__WORKSPACE_LOCATION:
				setWorkspaceLocation(WORKSPACE_LOCATION_EDEFAULT);
				return;
			case PlatformPackage.PLATFORM__PRODUCT_ID:
				setProductId(PRODUCT_ID_EDEFAULT);
				return;
			case PlatformPackage.PLATFORM__APPLICATION_ID:
				setApplicationId(APPLICATION_ID_EDEFAULT);
				return;
			case PlatformPackage.PLATFORM__APPLICATION_ARGS:
				getApplicationArgs().clear();
				return;
			case PlatformPackage.PLATFORM__BUILD_ID:
				setBuildId(BUILD_ID_EDEFAULT);
				return;
			case PlatformPackage.PLATFORM__UPTIME:
				setUptime(UPTIME_EDEFAULT);
				return;
			case PlatformPackage.PLATFORM__PLUGINS:
				getPlugins().clear();
				return;
			case PlatformPackage.PLATFORM__FEATURES:
				getFeatures().clear();
				return;
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_TOTAL_DISKSPACE:
				setWorkspacePartitionTotalDiskspace(WORKSPACE_PARTITION_TOTAL_DISKSPACE_EDEFAULT);
				return;
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_USABLE_DISKSPACE:
				setWorkspacePartitionUsableDiskspace(WORKSPACE_PARTITION_USABLE_DISKSPACE_EDEFAULT);
				return;
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_FREE_DISKSPACE:
				setWorkspacePartitionFreeDiskspace(WORKSPACE_PARTITION_FREE_DISKSPACE_EDEFAULT);
				return;
			case PlatformPackage.PLATFORM__PREFERENCES:
				getPreferences().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PlatformPackage.PLATFORM__WORKSPACE_LOCATION:
				return WORKSPACE_LOCATION_EDEFAULT == null ? workspaceLocation != null : !WORKSPACE_LOCATION_EDEFAULT.equals(workspaceLocation);
			case PlatformPackage.PLATFORM__PRODUCT_ID:
				return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
			case PlatformPackage.PLATFORM__APPLICATION_ID:
				return APPLICATION_ID_EDEFAULT == null ? applicationId != null : !APPLICATION_ID_EDEFAULT.equals(applicationId);
			case PlatformPackage.PLATFORM__APPLICATION_ARGS:
				return applicationArgs != null && !applicationArgs.isEmpty();
			case PlatformPackage.PLATFORM__BUILD_ID:
				return BUILD_ID_EDEFAULT == null ? buildId != null : !BUILD_ID_EDEFAULT.equals(buildId);
			case PlatformPackage.PLATFORM__UPTIME:
				return uptime != UPTIME_EDEFAULT;
			case PlatformPackage.PLATFORM__PLUGINS:
				return plugins != null && !plugins.isEmpty();
			case PlatformPackage.PLATFORM__FEATURES:
				return features != null && !features.isEmpty();
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_TOTAL_DISKSPACE:
				return workspacePartitionTotalDiskspace != WORKSPACE_PARTITION_TOTAL_DISKSPACE_EDEFAULT;
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_USABLE_DISKSPACE:
				return workspacePartitionUsableDiskspace != WORKSPACE_PARTITION_USABLE_DISKSPACE_EDEFAULT;
			case PlatformPackage.PLATFORM__WORKSPACE_PARTITION_FREE_DISKSPACE:
				return workspacePartitionFreeDiskspace != WORKSPACE_PARTITION_FREE_DISKSPACE_EDEFAULT;
			case PlatformPackage.PLATFORM__PREFERENCES:
				return preferences != null && !preferences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (workspaceLocation: ");
		result.append(workspaceLocation);
		result.append(", productId: ");
		result.append(productId);
		result.append(", applicationId: ");
		result.append(applicationId);
		result.append(", applicationArgs: ");
		result.append(applicationArgs);
		result.append(", buildId: ");
		result.append(buildId);
		result.append(", uptime: ");
		result.append(uptime);
		result.append(", workspacePartitionTotalDiskspace: ");
		result.append(workspacePartitionTotalDiskspace);
		result.append(", workspacePartitionUsableDiskspace: ");
		result.append(workspacePartitionUsableDiskspace);
		result.append(", workspacePartitionFreeDiskspace: ");
		result.append(workspacePartitionFreeDiskspace);
		result.append(')');
		return result.toString();
	}

} //PlatformImpl
