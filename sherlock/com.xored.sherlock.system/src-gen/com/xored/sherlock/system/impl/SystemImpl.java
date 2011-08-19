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
 *   <li>{@link com.xored.sherlock.system.impl.SystemImpl#getLocale <em>Locale</em>}</li>
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
	 * The default value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected String locale = LOCALE_EDEFAULT;

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
	public String getLocale() {
		return locale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocale(String newLocale) {
		String oldLocale = locale;
		locale = newLocale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__LOCALE, oldLocale, locale));
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
			case SystemPackage.SYSTEM__LOCALE:
				return getLocale();
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
			case SystemPackage.SYSTEM__LOCALE:
				setLocale((String)newValue);
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
			case SystemPackage.SYSTEM__LOCALE:
				setLocale(LOCALE_EDEFAULT);
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
			case SystemPackage.SYSTEM__LOCALE:
				return LOCALE_EDEFAULT == null ? locale != null : !LOCALE_EDEFAULT.equals(locale);
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
		result.append(", locale: ");
		result.append(locale);
		result.append(')');
		return result.toString();
	}

} //SystemImpl
