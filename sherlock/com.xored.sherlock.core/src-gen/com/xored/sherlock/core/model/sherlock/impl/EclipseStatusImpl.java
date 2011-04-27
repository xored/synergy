/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock.impl;

import com.xored.sherlock.core.model.sherlock.EclipseStatus;
import com.xored.sherlock.core.model.sherlock.JavaException;
import com.xored.sherlock.core.model.sherlock.SherlockPackage;

import java.util.Collection;
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
 * An implementation of the model object '<em><b>Eclipse Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.impl.EclipseStatusImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.impl.EclipseStatusImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.impl.EclipseStatusImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.impl.EclipseStatusImpl#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.impl.EclipseStatusImpl#getSevirity <em>Sevirity</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.impl.EclipseStatusImpl#getException <em>Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EclipseStatusImpl extends EObjectImpl implements EclipseStatus {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<EclipseStatus> children;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final int CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected int code = CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlugin() <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlugin()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlugin() <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlugin()
	 * @generated
	 * @ordered
	 */
	protected String plugin = PLUGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSevirity() <em>Sevirity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSevirity()
	 * @generated
	 * @ordered
	 */
	protected static final int SEVIRITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSevirity() <em>Sevirity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSevirity()
	 * @generated
	 * @ordered
	 */
	protected int sevirity = SEVIRITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected JavaException exception;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EclipseStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SherlockPackage.Literals.ECLIPSE_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EclipseStatus> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<EclipseStatus>(EclipseStatus.class, this, SherlockPackage.ECLIPSE_STATUS__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(int newCode) {
		int oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_STATUS__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_STATUS__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlugin() {
		return plugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlugin(String newPlugin) {
		String oldPlugin = plugin;
		plugin = newPlugin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_STATUS__PLUGIN, oldPlugin, plugin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSevirity() {
		return sevirity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSevirity(int newSevirity) {
		int oldSevirity = sevirity;
		sevirity = newSevirity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_STATUS__SEVIRITY, oldSevirity, sevirity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaException getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetException(JavaException newException, NotificationChain msgs) {
		JavaException oldException = exception;
		exception = newException;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_STATUS__EXCEPTION, oldException, newException);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setException(JavaException newException) {
		if (newException != exception) {
			NotificationChain msgs = null;
			if (exception != null)
				msgs = ((InternalEObject)exception).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SherlockPackage.ECLIPSE_STATUS__EXCEPTION, null, msgs);
			if (newException != null)
				msgs = ((InternalEObject)newException).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SherlockPackage.ECLIPSE_STATUS__EXCEPTION, null, msgs);
			msgs = basicSetException(newException, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.ECLIPSE_STATUS__EXCEPTION, newException, newException));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SherlockPackage.ECLIPSE_STATUS__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case SherlockPackage.ECLIPSE_STATUS__EXCEPTION:
				return basicSetException(null, msgs);
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
			case SherlockPackage.ECLIPSE_STATUS__CHILDREN:
				return getChildren();
			case SherlockPackage.ECLIPSE_STATUS__CODE:
				return getCode();
			case SherlockPackage.ECLIPSE_STATUS__MESSAGE:
				return getMessage();
			case SherlockPackage.ECLIPSE_STATUS__PLUGIN:
				return getPlugin();
			case SherlockPackage.ECLIPSE_STATUS__SEVIRITY:
				return getSevirity();
			case SherlockPackage.ECLIPSE_STATUS__EXCEPTION:
				return getException();
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
			case SherlockPackage.ECLIPSE_STATUS__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends EclipseStatus>)newValue);
				return;
			case SherlockPackage.ECLIPSE_STATUS__CODE:
				setCode((Integer)newValue);
				return;
			case SherlockPackage.ECLIPSE_STATUS__MESSAGE:
				setMessage((String)newValue);
				return;
			case SherlockPackage.ECLIPSE_STATUS__PLUGIN:
				setPlugin((String)newValue);
				return;
			case SherlockPackage.ECLIPSE_STATUS__SEVIRITY:
				setSevirity((Integer)newValue);
				return;
			case SherlockPackage.ECLIPSE_STATUS__EXCEPTION:
				setException((JavaException)newValue);
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
			case SherlockPackage.ECLIPSE_STATUS__CHILDREN:
				getChildren().clear();
				return;
			case SherlockPackage.ECLIPSE_STATUS__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_STATUS__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_STATUS__PLUGIN:
				setPlugin(PLUGIN_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_STATUS__SEVIRITY:
				setSevirity(SEVIRITY_EDEFAULT);
				return;
			case SherlockPackage.ECLIPSE_STATUS__EXCEPTION:
				setException((JavaException)null);
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
			case SherlockPackage.ECLIPSE_STATUS__CHILDREN:
				return children != null && !children.isEmpty();
			case SherlockPackage.ECLIPSE_STATUS__CODE:
				return code != CODE_EDEFAULT;
			case SherlockPackage.ECLIPSE_STATUS__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case SherlockPackage.ECLIPSE_STATUS__PLUGIN:
				return PLUGIN_EDEFAULT == null ? plugin != null : !PLUGIN_EDEFAULT.equals(plugin);
			case SherlockPackage.ECLIPSE_STATUS__SEVIRITY:
				return sevirity != SEVIRITY_EDEFAULT;
			case SherlockPackage.ECLIPSE_STATUS__EXCEPTION:
				return exception != null;
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
		result.append(" (code: ");
		result.append(code);
		result.append(", message: ");
		result.append(message);
		result.append(", plugin: ");
		result.append(plugin);
		result.append(", sevirity: ");
		result.append(sevirity);
		result.append(')');
		return result.toString();
	}

} //EclipseStatusImpl
