/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jsontest.impl;

import java.util.Collection;
import java.util.Date;

import jsontest.JsontestPackage;
import jsontest.Town;
import jsontest.TownKind;
import jsontest.User;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Town</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jsontest.impl.TownImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link jsontest.impl.TownImpl#getName <em>Name</em>}</li>
 *   <li>{@link jsontest.impl.TownImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link jsontest.impl.TownImpl#getAge <em>Age</em>}</li>
 *   <li>{@link jsontest.impl.TownImpl#getFoundation <em>Foundation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TownImpl extends EObjectImpl implements Town {
	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<User> users;

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
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final TownKind KIND_EDEFAULT = TownKind.SMALL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected TownKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected static final int AGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAge() <em>Age</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAge()
	 * @generated
	 * @ordered
	 */
	protected int age = AGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFoundation() <em>Foundation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFoundation()
	 * @generated
	 * @ordered
	 */
	protected static final Date FOUNDATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFoundation() <em>Foundation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFoundation()
	 * @generated
	 * @ordered
	 */
	protected Date foundation = FOUNDATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TownImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JsontestPackage.Literals.TOWN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<User> getUsers() {
		if (users == null) {
			users = new EObjectContainmentWithInverseEList<User>(User.class, this, JsontestPackage.TOWN__USERS, JsontestPackage.USER__TOWN);
		}
		return users;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JsontestPackage.TOWN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TownKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(TownKind newKind) {
		TownKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsontestPackage.TOWN__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAge() {
		return age;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAge(int newAge) {
		int oldAge = age;
		age = newAge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsontestPackage.TOWN__AGE, oldAge, age));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getFoundation() {
		return foundation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFoundation(Date newFoundation) {
		Date oldFoundation = foundation;
		foundation = newFoundation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JsontestPackage.TOWN__FOUNDATION, oldFoundation, foundation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JsontestPackage.TOWN__USERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsers()).basicAdd(otherEnd, msgs);
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
			case JsontestPackage.TOWN__USERS:
				return ((InternalEList<?>)getUsers()).basicRemove(otherEnd, msgs);
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
			case JsontestPackage.TOWN__USERS:
				return getUsers();
			case JsontestPackage.TOWN__NAME:
				return getName();
			case JsontestPackage.TOWN__KIND:
				return getKind();
			case JsontestPackage.TOWN__AGE:
				return getAge();
			case JsontestPackage.TOWN__FOUNDATION:
				return getFoundation();
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
			case JsontestPackage.TOWN__USERS:
				getUsers().clear();
				getUsers().addAll((Collection<? extends User>)newValue);
				return;
			case JsontestPackage.TOWN__NAME:
				setName((String)newValue);
				return;
			case JsontestPackage.TOWN__KIND:
				setKind((TownKind)newValue);
				return;
			case JsontestPackage.TOWN__AGE:
				setAge((Integer)newValue);
				return;
			case JsontestPackage.TOWN__FOUNDATION:
				setFoundation((Date)newValue);
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
			case JsontestPackage.TOWN__USERS:
				getUsers().clear();
				return;
			case JsontestPackage.TOWN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JsontestPackage.TOWN__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case JsontestPackage.TOWN__AGE:
				setAge(AGE_EDEFAULT);
				return;
			case JsontestPackage.TOWN__FOUNDATION:
				setFoundation(FOUNDATION_EDEFAULT);
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
			case JsontestPackage.TOWN__USERS:
				return users != null && !users.isEmpty();
			case JsontestPackage.TOWN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JsontestPackage.TOWN__KIND:
				return kind != KIND_EDEFAULT;
			case JsontestPackage.TOWN__AGE:
				return age != AGE_EDEFAULT;
			case JsontestPackage.TOWN__FOUNDATION:
				return FOUNDATION_EDEFAULT == null ? foundation != null : !FOUNDATION_EDEFAULT.equals(foundation);
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
		result.append(", kind: ");
		result.append(kind);
		result.append(", age: ");
		result.append(age);
		result.append(", foundation: ");
		result.append(foundation);
		result.append(')');
		return result.toString();
	}

} //TownImpl
