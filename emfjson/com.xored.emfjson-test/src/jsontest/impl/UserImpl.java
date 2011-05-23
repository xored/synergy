/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jsontest.impl;

import java.util.Collection;

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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jsontest.impl.UserImpl#getName <em>Name</em>}</li>
 *   <li>{@link jsontest.impl.UserImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link jsontest.impl.UserImpl#getDummy <em>Dummy</em>}</li>
 *   <li>{@link jsontest.impl.UserImpl#getTown <em>Town</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends EObjectImpl implements User {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> roles;

	/**
	 * The default value of the '{@link #getDummy() <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDummy()
	 * @generated
	 * @ordered
	 */
	protected static final int DUMMY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDummy() <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDummy()
	 * @generated
	 * @ordered
	 */
	protected int dummy = DUMMY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JsontestPackage.Literals.USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsontestPackage.USER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRoles() {
		if (roles == null) {
			roles = new EDataTypeUniqueEList<String>(String.class, this, JsontestPackage.USER__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDummy() {
		return dummy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDummy(int newDummy) {
		int oldDummy = dummy;
		dummy = newDummy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsontestPackage.USER__DUMMY, oldDummy, dummy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Town getTown() {
		if (eContainerFeatureID() != JsontestPackage.USER__TOWN) return null;
		return (Town)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTown(Town newTown, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTown, JsontestPackage.USER__TOWN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTown(Town newTown) {
		if (newTown != eInternalContainer() || (eContainerFeatureID() != JsontestPackage.USER__TOWN && newTown != null)) {
			if (EcoreUtil.isAncestor(this, newTown))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTown != null)
				msgs = ((InternalEObject)newTown).eInverseAdd(this, JsontestPackage.TOWN__USERS, Town.class, msgs);
			msgs = basicSetTown(newTown, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsontestPackage.USER__TOWN, newTown, newTown));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JsontestPackage.USER__TOWN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTown((Town)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JsontestPackage.USER__TOWN:
				return basicSetTown(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case JsontestPackage.USER__TOWN:
				return eInternalContainer().eInverseRemove(this, JsontestPackage.TOWN__USERS, Town.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JsontestPackage.USER__NAME:
				return getName();
			case JsontestPackage.USER__ROLES:
				return getRoles();
			case JsontestPackage.USER__DUMMY:
				return getDummy();
			case JsontestPackage.USER__TOWN:
				return getTown();
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
			case JsontestPackage.USER__NAME:
				setName((String)newValue);
				return;
			case JsontestPackage.USER__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends String>)newValue);
				return;
			case JsontestPackage.USER__DUMMY:
				setDummy((Integer)newValue);
				return;
			case JsontestPackage.USER__TOWN:
				setTown((Town)newValue);
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
			case JsontestPackage.USER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JsontestPackage.USER__ROLES:
				getRoles().clear();
				return;
			case JsontestPackage.USER__DUMMY:
				setDummy(DUMMY_EDEFAULT);
				return;
			case JsontestPackage.USER__TOWN:
				setTown((Town)null);
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
			case JsontestPackage.USER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JsontestPackage.USER__ROLES:
				return roles != null && !roles.isEmpty();
			case JsontestPackage.USER__DUMMY:
				return dummy != DUMMY_EDEFAULT;
			case JsontestPackage.USER__TOWN:
				return getTown() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", roles: ");
		result.append(roles);
		result.append(", dummy: ");
		result.append(dummy);
		result.append(')');
		return result.toString();
	}

} //UserImpl
