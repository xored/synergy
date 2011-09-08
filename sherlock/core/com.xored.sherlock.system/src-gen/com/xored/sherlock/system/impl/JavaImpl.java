/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.system.impl;

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

import com.xored.sherlock.system.Java;
import com.xored.sherlock.system.SystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.xored.sherlock.system.impl.JavaImpl#getRuntimeName <em>Runtime Name</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.JavaImpl#getRuntimeVersion <em>Runtime Version</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.JavaImpl#getMaxMemory <em>Max Memory</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.JavaImpl#getFreeMemory <em>Free Memory</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.JavaImpl#getTotalMemory <em>Total Memory</em>}</li>
 *   <li>{@link com.xored.sherlock.system.impl.JavaImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaImpl extends EObjectImpl implements Java {
	/**
	 * The default value of the '{@link #getRuntimeName() <em>Runtime Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeName()
	 * @generated
	 * @ordered
	 */
	protected static final String RUNTIME_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuntimeName() <em>Runtime Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeName()
	 * @generated
	 * @ordered
	 */
	protected String runtimeName = RUNTIME_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuntimeVersion() <em>Runtime Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String RUNTIME_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuntimeVersion() <em>Runtime Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuntimeVersion()
	 * @generated
	 * @ordered
	 */
	protected String runtimeVersion = RUNTIME_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxMemory() <em>Max Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long MAX_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getMaxMemory() <em>Max Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxMemory()
	 * @generated
	 * @ordered
	 */
	protected long maxMemory = MAX_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getFreeMemory() <em>Free Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long FREE_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getFreeMemory() <em>Free Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeMemory()
	 * @generated
	 * @ordered
	 */
	protected long freeMemory = FREE_MEMORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalMemory() <em>Total Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalMemory()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_MEMORY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalMemory() <em>Total Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalMemory()
	 * @generated
	 * @ordered
	 */
	protected long totalMemory = TOTAL_MEMORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SystemPackage.Literals.JAVA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuntimeName() {
		return runtimeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeName(String newRuntimeName) {
		String oldRuntimeName = runtimeName;
		runtimeName = newRuntimeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.JAVA__RUNTIME_NAME, oldRuntimeName, runtimeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuntimeVersion() {
		return runtimeVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuntimeVersion(String newRuntimeVersion) {
		String oldRuntimeVersion = runtimeVersion;
		runtimeVersion = newRuntimeVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.JAVA__RUNTIME_VERSION, oldRuntimeVersion, runtimeVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMaxMemory() {
		return maxMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxMemory(long newMaxMemory) {
		long oldMaxMemory = maxMemory;
		maxMemory = newMaxMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.JAVA__MAX_MEMORY, oldMaxMemory, maxMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getFreeMemory() {
		return freeMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreeMemory(long newFreeMemory) {
		long oldFreeMemory = freeMemory;
		freeMemory = newFreeMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.JAVA__FREE_MEMORY, oldFreeMemory, freeMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalMemory() {
		return totalMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalMemory(long newTotalMemory) {
		long oldTotalMemory = totalMemory;
		totalMemory = newTotalMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.JAVA__TOTAL_MEMORY, oldTotalMemory, totalMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getProperties() {
		if (properties == null) {
			properties = new EcoreEMap<String,String>(SystemPackage.Literals.ENTRY, EntryImpl.class, this, SystemPackage.JAVA__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SystemPackage.JAVA__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case SystemPackage.JAVA__RUNTIME_NAME:
				return getRuntimeName();
			case SystemPackage.JAVA__RUNTIME_VERSION:
				return getRuntimeVersion();
			case SystemPackage.JAVA__MAX_MEMORY:
				return getMaxMemory();
			case SystemPackage.JAVA__FREE_MEMORY:
				return getFreeMemory();
			case SystemPackage.JAVA__TOTAL_MEMORY:
				return getTotalMemory();
			case SystemPackage.JAVA__PROPERTIES:
				if (coreType) return getProperties();
				else return getProperties().map();
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
			case SystemPackage.JAVA__RUNTIME_NAME:
				setRuntimeName((String)newValue);
				return;
			case SystemPackage.JAVA__RUNTIME_VERSION:
				setRuntimeVersion((String)newValue);
				return;
			case SystemPackage.JAVA__MAX_MEMORY:
				setMaxMemory((Long)newValue);
				return;
			case SystemPackage.JAVA__FREE_MEMORY:
				setFreeMemory((Long)newValue);
				return;
			case SystemPackage.JAVA__TOTAL_MEMORY:
				setTotalMemory((Long)newValue);
				return;
			case SystemPackage.JAVA__PROPERTIES:
				((EStructuralFeature.Setting)getProperties()).set(newValue);
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
			case SystemPackage.JAVA__RUNTIME_NAME:
				setRuntimeName(RUNTIME_NAME_EDEFAULT);
				return;
			case SystemPackage.JAVA__RUNTIME_VERSION:
				setRuntimeVersion(RUNTIME_VERSION_EDEFAULT);
				return;
			case SystemPackage.JAVA__MAX_MEMORY:
				setMaxMemory(MAX_MEMORY_EDEFAULT);
				return;
			case SystemPackage.JAVA__FREE_MEMORY:
				setFreeMemory(FREE_MEMORY_EDEFAULT);
				return;
			case SystemPackage.JAVA__TOTAL_MEMORY:
				setTotalMemory(TOTAL_MEMORY_EDEFAULT);
				return;
			case SystemPackage.JAVA__PROPERTIES:
				getProperties().clear();
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
			case SystemPackage.JAVA__RUNTIME_NAME:
				return RUNTIME_NAME_EDEFAULT == null ? runtimeName != null : !RUNTIME_NAME_EDEFAULT.equals(runtimeName);
			case SystemPackage.JAVA__RUNTIME_VERSION:
				return RUNTIME_VERSION_EDEFAULT == null ? runtimeVersion != null : !RUNTIME_VERSION_EDEFAULT.equals(runtimeVersion);
			case SystemPackage.JAVA__MAX_MEMORY:
				return maxMemory != MAX_MEMORY_EDEFAULT;
			case SystemPackage.JAVA__FREE_MEMORY:
				return freeMemory != FREE_MEMORY_EDEFAULT;
			case SystemPackage.JAVA__TOTAL_MEMORY:
				return totalMemory != TOTAL_MEMORY_EDEFAULT;
			case SystemPackage.JAVA__PROPERTIES:
				return properties != null && !properties.isEmpty();
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
		result.append(" (runtimeName: ");
		result.append(runtimeName);
		result.append(", runtimeVersion: ");
		result.append(runtimeVersion);
		result.append(", maxMemory: ");
		result.append(maxMemory);
		result.append(", freeMemory: ");
		result.append(freeMemory);
		result.append(", totalMemory: ");
		result.append(totalMemory);
		result.append(')');
		return result.toString();
	}

} //JavaImpl