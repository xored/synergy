/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock.report.impl;

import com.xored.sherlock.core.model.sherlock.report.Category;
import com.xored.sherlock.core.model.sherlock.report.EventSource;
import com.xored.sherlock.core.model.sherlock.report.Node;
import com.xored.sherlock.core.model.sherlock.report.Report;
import com.xored.sherlock.core.model.sherlock.report.ReportPackage;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.impl.ReportImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.impl.ReportImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.impl.ReportImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.report.impl.ReportImpl#getSources <em>Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReportImpl extends EObjectImpl implements Report {
	/**
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected Node root;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<Category> categories;

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
	 * The cached value of the '{@link #getSources() <em>Sources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSources()
	 * @generated
	 * @ordered
	 */
	protected EList<EventSource> sources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReportPackage.Literals.REPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoot(Node newRoot, NotificationChain msgs) {
		Node oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReportPackage.REPORT__ROOT, oldRoot, newRoot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(Node newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null)
				msgs = ((InternalEObject)root).eInverseRemove(this, ReportPackage.NODE__REPORT, Node.class, msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, ReportPackage.NODE__REPORT, Node.class, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReportPackage.REPORT__ROOT, newRoot, newRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Category> getCategories() {
		if (categories == null) {
			categories = new EObjectContainmentEList<Category>(Category.class, this, ReportPackage.REPORT__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, String> getProperties() {
		if (properties == null) {
			properties = new EcoreEMap<String,String>(ReportPackage.Literals.PROPERTY_MAP, PropertyMapImpl.class, this, ReportPackage.REPORT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventSource> getSources() {
		if (sources == null) {
			sources = new EObjectContainmentEList<EventSource>(EventSource.class, this, ReportPackage.REPORT__SOURCES);
		}
		return sources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReportPackage.REPORT__ROOT:
				if (root != null)
					msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReportPackage.REPORT__ROOT, null, msgs);
				return basicSetRoot((Node)otherEnd, msgs);
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
			case ReportPackage.REPORT__ROOT:
				return basicSetRoot(null, msgs);
			case ReportPackage.REPORT__CATEGORIES:
				return ((InternalEList<?>)getCategories()).basicRemove(otherEnd, msgs);
			case ReportPackage.REPORT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case ReportPackage.REPORT__SOURCES:
				return ((InternalEList<?>)getSources()).basicRemove(otherEnd, msgs);
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
			case ReportPackage.REPORT__ROOT:
				return getRoot();
			case ReportPackage.REPORT__CATEGORIES:
				return getCategories();
			case ReportPackage.REPORT__PROPERTIES:
				if (coreType) return getProperties();
				else return getProperties().map();
			case ReportPackage.REPORT__SOURCES:
				return getSources();
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
			case ReportPackage.REPORT__ROOT:
				setRoot((Node)newValue);
				return;
			case ReportPackage.REPORT__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends Category>)newValue);
				return;
			case ReportPackage.REPORT__PROPERTIES:
				((EStructuralFeature.Setting)getProperties()).set(newValue);
				return;
			case ReportPackage.REPORT__SOURCES:
				getSources().clear();
				getSources().addAll((Collection<? extends EventSource>)newValue);
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
			case ReportPackage.REPORT__ROOT:
				setRoot((Node)null);
				return;
			case ReportPackage.REPORT__CATEGORIES:
				getCategories().clear();
				return;
			case ReportPackage.REPORT__PROPERTIES:
				getProperties().clear();
				return;
			case ReportPackage.REPORT__SOURCES:
				getSources().clear();
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
			case ReportPackage.REPORT__ROOT:
				return root != null;
			case ReportPackage.REPORT__CATEGORIES:
				return categories != null && !categories.isEmpty();
			case ReportPackage.REPORT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case ReportPackage.REPORT__SOURCES:
				return sources != null && !sources.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ReportImpl
