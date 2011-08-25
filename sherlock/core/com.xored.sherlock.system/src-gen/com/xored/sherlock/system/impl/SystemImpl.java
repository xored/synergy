/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.system.impl;

import com.xored.sherlock.system.SystemPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getOsName <em>Os Name</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getOsVersion <em>Os Version</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getOsArch <em>Os Arch</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getUserHome <em>User Home</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getWorkDir <em>Work Dir</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getTimezone <em>Timezone</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends EObjectImpl implements com.xored.sherlock.system.System {
	/**
	 * The default value of the '{@link #getOsName() <em>Os Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsName()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsName() <em>Os Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsName()
	 * @generated
	 * @ordered
	 */
	protected String osName = OS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOsVersion() <em>Os Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsVersion() <em>Os Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsVersion()
	 * @generated
	 * @ordered
	 */
	protected String osVersion = OS_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOsArch() <em>Os Arch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsArch()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_ARCH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsArch() <em>Os Arch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsArch()
	 * @generated
	 * @ordered
	 */
	protected String osArch = OS_ARCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserHome() <em>User Home</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserHome()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_HOME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserHome() <em>User Home</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserHome()
	 * @generated
	 * @ordered
	 */
	protected String userHome = USER_HOME_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorkDir() <em>Work Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkDir()
	 * @generated
	 * @ordered
	 */
	protected static final String WORK_DIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWorkDir() <em>Work Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkDir()
	 * @generated
	 * @ordered
	 */
	protected String workDir = WORK_DIR_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRegion() <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected static final String REGION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected String region = REGION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimezone() <em>Timezone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimezone()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMEZONE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimezone() <em>Timezone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimezone()
	 * @generated
	 * @ordered
	 */
	protected String timezone = TIMEZONE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsName() {
		return osName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsName(String newOsName) {
		String oldOsName = osName;
		osName = newOsName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__OS_NAME, oldOsName, osName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsVersion(String newOsVersion) {
		String oldOsVersion = osVersion;
		osVersion = newOsVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__OS_VERSION, oldOsVersion, osVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsArch() {
		return osArch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsArch(String newOsArch) {
		String oldOsArch = osArch;
		osArch = newOsArch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__OS_ARCH, oldOsArch, osArch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserHome() {
		return userHome;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserHome(String newUserHome) {
		String oldUserHome = userHome;
		userHome = newUserHome;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__USER_HOME, oldUserHome, userHome));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWorkDir() {
		return workDir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkDir(String newWorkDir) {
		String oldWorkDir = workDir;
		workDir = newWorkDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__WORK_DIR, oldWorkDir, workDir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegion(String newRegion) {
		String oldRegion = region;
		region = newRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimezone(String newTimezone) {
		String oldTimezone = timezone;
		timezone = newTimezone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__TIMEZONE, oldTimezone, timezone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getVariables() {
		if (variables == null) {
			variables = new EcoreEMap<String,String>(SystemPackage.Literals.ENTRY, EntryImpl.class, this, SystemPackage.SYSTEM__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.SYSTEM__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
			case SystemPackage.SYSTEM__OS_NAME:
				return getOsName();
			case SystemPackage.SYSTEM__OS_VERSION:
				return getOsVersion();
			case SystemPackage.SYSTEM__OS_ARCH:
				return getOsArch();
			case SystemPackage.SYSTEM__USERNAME:
				return getUsername();
			case SystemPackage.SYSTEM__USER_HOME:
				return getUserHome();
			case SystemPackage.SYSTEM__WORK_DIR:
				return getWorkDir();
			case SystemPackage.SYSTEM__LANGUAGE:
				return getLanguage();
			case SystemPackage.SYSTEM__REGION:
				return getRegion();
			case SystemPackage.SYSTEM__TIMEZONE:
				return getTimezone();
			case SystemPackage.SYSTEM__VARIABLES:
				if (coreType) return getVariables();
				else return getVariables().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SystemPackage.SYSTEM__OS_NAME:
				setOsName((String)newValue);
				return;
			case SystemPackage.SYSTEM__OS_VERSION:
				setOsVersion((String)newValue);
				return;
			case SystemPackage.SYSTEM__OS_ARCH:
				setOsArch((String)newValue);
				return;
			case SystemPackage.SYSTEM__USERNAME:
				setUsername((String)newValue);
				return;
			case SystemPackage.SYSTEM__USER_HOME:
				setUserHome((String)newValue);
				return;
			case SystemPackage.SYSTEM__WORK_DIR:
				setWorkDir((String)newValue);
				return;
			case SystemPackage.SYSTEM__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case SystemPackage.SYSTEM__REGION:
				setRegion((String)newValue);
				return;
			case SystemPackage.SYSTEM__TIMEZONE:
				setTimezone((String)newValue);
				return;
			case SystemPackage.SYSTEM__VARIABLES:
				((EStructuralFeature.Setting)getVariables()).set(newValue);
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
			case SystemPackage.SYSTEM__OS_NAME:
				setOsName(OS_NAME_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__OS_VERSION:
				setOsVersion(OS_VERSION_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__OS_ARCH:
				setOsArch(OS_ARCH_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__USER_HOME:
				setUserHome(USER_HOME_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__WORK_DIR:
				setWorkDir(WORK_DIR_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__REGION:
				setRegion(REGION_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__TIMEZONE:
				setTimezone(TIMEZONE_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__VARIABLES:
				getVariables().clear();
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
			case SystemPackage.SYSTEM__OS_NAME:
				return OS_NAME_EDEFAULT == null ? osName != null : !OS_NAME_EDEFAULT.equals(osName);
			case SystemPackage.SYSTEM__OS_VERSION:
				return OS_VERSION_EDEFAULT == null ? osVersion != null : !OS_VERSION_EDEFAULT.equals(osVersion);
			case SystemPackage.SYSTEM__OS_ARCH:
				return OS_ARCH_EDEFAULT == null ? osArch != null : !OS_ARCH_EDEFAULT.equals(osArch);
			case SystemPackage.SYSTEM__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case SystemPackage.SYSTEM__USER_HOME:
				return USER_HOME_EDEFAULT == null ? userHome != null : !USER_HOME_EDEFAULT.equals(userHome);
			case SystemPackage.SYSTEM__WORK_DIR:
				return WORK_DIR_EDEFAULT == null ? workDir != null : !WORK_DIR_EDEFAULT.equals(workDir);
			case SystemPackage.SYSTEM__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case SystemPackage.SYSTEM__REGION:
				return REGION_EDEFAULT == null ? region != null : !REGION_EDEFAULT.equals(region);
			case SystemPackage.SYSTEM__TIMEZONE:
				return TIMEZONE_EDEFAULT == null ? timezone != null : !TIMEZONE_EDEFAULT.equals(timezone);
			case SystemPackage.SYSTEM__VARIABLES:
				return variables != null && !variables.isEmpty();
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
		result.append(" (osName: ");
		result.append(osName);
		result.append(", osVersion: ");
		result.append(osVersion);
		result.append(", osArch: ");
		result.append(osArch);
		result.append(", username: ");
		result.append(username);
		result.append(", userHome: ");
		result.append(userHome);
		result.append(", workDir: ");
		result.append(workDir);
		result.append(", language: ");
		result.append(language);
		result.append(", region: ");
		result.append(region);
		result.append(", timezone: ");
		result.append(timezone);
		result.append(')');
		return result.toString();
	}

} //SystemImpl
