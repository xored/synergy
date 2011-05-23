/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jsontest.impl;

import java.util.Collection;

import jsontest.Data;
import jsontest.JsontestPackage;
import jsontest.Town;
import jsontest.User;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jsontest.impl.DataImpl#getTowns <em>Towns</em>}</li>
 *   <li>{@link jsontest.impl.DataImpl#getAdmin <em>Admin</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataImpl extends EObjectImpl implements Data {
	/**
	 * The cached value of the '{@link #getTowns() <em>Towns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTowns()
	 * @generated
	 * @ordered
	 */
	protected EList<Town> towns;

	/**
	 * The cached value of the '{@link #getAdmin() <em>Admin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdmin()
	 * @generated
	 * @ordered
	 */
	protected User admin;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JsontestPackage.Literals.DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Town> getTowns() {
		if (towns == null) {
			towns = new EObjectContainmentEList<Town>(Town.class, this, JsontestPackage.DATA__TOWNS);
		}
		return towns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getAdmin() {
		if (admin != null && admin.eIsProxy()) {
			InternalEObject oldAdmin = (InternalEObject)admin;
			admin = (User)eResolveProxy(oldAdmin);
			if (admin != oldAdmin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JsontestPackage.DATA__ADMIN, oldAdmin, admin));
			}
		}
		return admin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetAdmin() {
		return admin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdmin(User newAdmin) {
		User oldAdmin = admin;
		admin = newAdmin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsontestPackage.DATA__ADMIN, oldAdmin, admin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JsontestPackage.DATA__TOWNS:
				return ((InternalEList<?>)getTowns()).basicRemove(otherEnd, msgs);
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
			case JsontestPackage.DATA__TOWNS:
				return getTowns();
			case JsontestPackage.DATA__ADMIN:
				if (resolve) return getAdmin();
				return basicGetAdmin();
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
			case JsontestPackage.DATA__TOWNS:
				getTowns().clear();
				getTowns().addAll((Collection<? extends Town>)newValue);
				return;
			case JsontestPackage.DATA__ADMIN:
				setAdmin((User)newValue);
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
			case JsontestPackage.DATA__TOWNS:
				getTowns().clear();
				return;
			case JsontestPackage.DATA__ADMIN:
				setAdmin((User)null);
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
			case JsontestPackage.DATA__TOWNS:
				return towns != null && !towns.isEmpty();
			case JsontestPackage.DATA__ADMIN:
				return admin != null;
		}
		return super.eIsSet(featureID);
	}

} //DataImpl
