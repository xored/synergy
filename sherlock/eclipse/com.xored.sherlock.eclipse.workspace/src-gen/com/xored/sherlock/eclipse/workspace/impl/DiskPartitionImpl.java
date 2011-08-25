/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.eclipse.workspace.impl;

import com.xored.sherlock.eclipse.workspace.DiskPartition;
import com.xored.sherlock.eclipse.workspace.WorkspacePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Disk Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.xored.sherlock.eclipse.workspace.impl.DiskPartitionImpl#getFreeSpace <em>Free Space</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.workspace.impl.DiskPartitionImpl#getTotalSpace <em>Total Space</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.workspace.impl.DiskPartitionImpl#getUsableSpace <em>Usable Space</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiskPartitionImpl extends EObjectImpl implements DiskPartition {
	/**
	 * The default value of the '{@link #getFreeSpace() <em>Free Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeSpace()
	 * @generated
	 * @ordered
	 */
	protected static final long FREE_SPACE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getFreeSpace() <em>Free Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeSpace()
	 * @generated
	 * @ordered
	 */
	protected long freeSpace = FREE_SPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalSpace() <em>Total Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalSpace()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_SPACE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalSpace() <em>Total Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalSpace()
	 * @generated
	 * @ordered
	 */
	protected long totalSpace = TOTAL_SPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsableSpace() <em>Usable Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsableSpace()
	 * @generated
	 * @ordered
	 */
	protected static final long USABLE_SPACE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getUsableSpace() <em>Usable Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsableSpace()
	 * @generated
	 * @ordered
	 */
	protected long usableSpace = USABLE_SPACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiskPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.DISK_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getFreeSpace() {
		return freeSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFreeSpace(long newFreeSpace) {
		long oldFreeSpace = freeSpace;
		freeSpace = newFreeSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.DISK_PARTITION__FREE_SPACE, oldFreeSpace, freeSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalSpace() {
		return totalSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalSpace(long newTotalSpace) {
		long oldTotalSpace = totalSpace;
		totalSpace = newTotalSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.DISK_PARTITION__TOTAL_SPACE, oldTotalSpace, totalSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getUsableSpace() {
		return usableSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsableSpace(long newUsableSpace) {
		long oldUsableSpace = usableSpace;
		usableSpace = newUsableSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.DISK_PARTITION__USABLE_SPACE, oldUsableSpace, usableSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkspacePackage.DISK_PARTITION__FREE_SPACE:
				return getFreeSpace();
			case WorkspacePackage.DISK_PARTITION__TOTAL_SPACE:
				return getTotalSpace();
			case WorkspacePackage.DISK_PARTITION__USABLE_SPACE:
				return getUsableSpace();
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
			case WorkspacePackage.DISK_PARTITION__FREE_SPACE:
				setFreeSpace((Long)newValue);
				return;
			case WorkspacePackage.DISK_PARTITION__TOTAL_SPACE:
				setTotalSpace((Long)newValue);
				return;
			case WorkspacePackage.DISK_PARTITION__USABLE_SPACE:
				setUsableSpace((Long)newValue);
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
			case WorkspacePackage.DISK_PARTITION__FREE_SPACE:
				setFreeSpace(FREE_SPACE_EDEFAULT);
				return;
			case WorkspacePackage.DISK_PARTITION__TOTAL_SPACE:
				setTotalSpace(TOTAL_SPACE_EDEFAULT);
				return;
			case WorkspacePackage.DISK_PARTITION__USABLE_SPACE:
				setUsableSpace(USABLE_SPACE_EDEFAULT);
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
			case WorkspacePackage.DISK_PARTITION__FREE_SPACE:
				return freeSpace != FREE_SPACE_EDEFAULT;
			case WorkspacePackage.DISK_PARTITION__TOTAL_SPACE:
				return totalSpace != TOTAL_SPACE_EDEFAULT;
			case WorkspacePackage.DISK_PARTITION__USABLE_SPACE:
				return usableSpace != USABLE_SPACE_EDEFAULT;
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
		result.append(" (freeSpace: ");
		result.append(freeSpace);
		result.append(", totalSpace: ");
		result.append(totalSpace);
		result.append(", usableSpace: ");
		result.append(usableSpace);
		result.append(')');
		return result.toString();
	}

} //DiskPartitionImpl
