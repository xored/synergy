/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.eclipse.platform.impl;

import com.xored.sherlock.eclipse.platform.JavaException;
import com.xored.sherlock.eclipse.platform.JavaStackTraceEntry;
import com.xored.sherlock.eclipse.platform.PlatformPackage;

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
 * An implementation of the model object '<em><b>Java Exception</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.JavaExceptionImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.JavaExceptionImpl#getCause <em>Cause</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.JavaExceptionImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.platform.impl.JavaExceptionImpl#getStacktrace <em>Stacktrace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaExceptionImpl extends EObjectImpl implements JavaException {
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCause() <em>Cause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCause()
	 * @generated
	 * @ordered
	 */
	protected JavaException cause;

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
	 * The cached value of the '{@link #getStacktrace() <em>Stacktrace</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStacktrace()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaStackTraceEntry> stacktrace;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaExceptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PlatformPackage.Literals.JAVA_EXCEPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.JAVA_EXCEPTION__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaException getCause() {
		return cause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCause(JavaException newCause, NotificationChain msgs) {
		JavaException oldCause = cause;
		cause = newCause;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PlatformPackage.JAVA_EXCEPTION__CAUSE, oldCause, newCause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCause(JavaException newCause) {
		if (newCause != cause) {
			NotificationChain msgs = null;
			if (cause != null)
				msgs = ((InternalEObject)cause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PlatformPackage.JAVA_EXCEPTION__CAUSE, null, msgs);
			if (newCause != null)
				msgs = ((InternalEObject)newCause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PlatformPackage.JAVA_EXCEPTION__CAUSE, null, msgs);
			msgs = basicSetCause(newCause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.JAVA_EXCEPTION__CAUSE, newCause, newCause));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PlatformPackage.JAVA_EXCEPTION__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JavaStackTraceEntry> getStacktrace() {
		if (stacktrace == null) {
			stacktrace = new EObjectContainmentEList<JavaStackTraceEntry>(JavaStackTraceEntry.class, this, PlatformPackage.JAVA_EXCEPTION__STACKTRACE);
		}
		return stacktrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PlatformPackage.JAVA_EXCEPTION__CAUSE:
				return basicSetCause(null, msgs);
			case PlatformPackage.JAVA_EXCEPTION__STACKTRACE:
				return ((InternalEList<?>)getStacktrace()).basicRemove(otherEnd, msgs);
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
			case PlatformPackage.JAVA_EXCEPTION__CLASS_NAME:
				return getClassName();
			case PlatformPackage.JAVA_EXCEPTION__CAUSE:
				return getCause();
			case PlatformPackage.JAVA_EXCEPTION__MESSAGE:
				return getMessage();
			case PlatformPackage.JAVA_EXCEPTION__STACKTRACE:
				return getStacktrace();
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
			case PlatformPackage.JAVA_EXCEPTION__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case PlatformPackage.JAVA_EXCEPTION__CAUSE:
				setCause((JavaException)newValue);
				return;
			case PlatformPackage.JAVA_EXCEPTION__MESSAGE:
				setMessage((String)newValue);
				return;
			case PlatformPackage.JAVA_EXCEPTION__STACKTRACE:
				getStacktrace().clear();
				getStacktrace().addAll((Collection<? extends JavaStackTraceEntry>)newValue);
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
			case PlatformPackage.JAVA_EXCEPTION__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case PlatformPackage.JAVA_EXCEPTION__CAUSE:
				setCause((JavaException)null);
				return;
			case PlatformPackage.JAVA_EXCEPTION__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case PlatformPackage.JAVA_EXCEPTION__STACKTRACE:
				getStacktrace().clear();
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
			case PlatformPackage.JAVA_EXCEPTION__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case PlatformPackage.JAVA_EXCEPTION__CAUSE:
				return cause != null;
			case PlatformPackage.JAVA_EXCEPTION__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case PlatformPackage.JAVA_EXCEPTION__STACKTRACE:
				return stacktrace != null && !stacktrace.isEmpty();
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
		result.append(" (className: ");
		result.append(className);
		result.append(", message: ");
		result.append(message);
		result.append(')');
		return result.toString();
	}

} //JavaExceptionImpl
