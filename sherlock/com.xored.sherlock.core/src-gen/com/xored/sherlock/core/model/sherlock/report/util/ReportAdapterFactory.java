/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock.report.util;

import com.xored.sherlock.core.model.sherlock.report.*;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.core.model.sherlock.report.ReportPackage
 * @generated
 */
public class ReportAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ReportPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ReportPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReportSwitch<Adapter> modelSwitch =
		new ReportSwitch<Adapter>() {
			@Override
			public Adapter caseReport(Report object) {
				return createReportAdapter();
			}
			@Override
			public Adapter caseReportContainer(ReportContainer object) {
				return createReportContainerAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseEventSource(EventSource object) {
				return createEventSourceAdapter();
			}
			@Override
			public Adapter casePropertyMap(Map.Entry<String, EObject> object) {
				return createPropertyMapAdapter();
			}
			@Override
			public Adapter caseSnaphot(Snaphot object) {
				return createSnaphotAdapter();
			}
			@Override
			public Adapter caseReportBuilderStore(ReportBuilderStore object) {
				return createReportBuilderStoreAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.report.Report <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.report.Report
	 * @generated
	 */
	public Adapter createReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.report.ReportContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.report.ReportContainer
	 * @generated
	 */
	public Adapter createReportContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.report.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.report.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.report.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.report.EventSource <em>Event Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.report.EventSource
	 * @generated
	 */
	public Adapter createEventSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Property Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createPropertyMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.report.Snaphot <em>Snaphot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.report.Snaphot
	 * @generated
	 */
	public Adapter createSnaphotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.report.ReportBuilderStore <em>Builder Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.report.ReportBuilderStore
	 * @generated
	 */
	public Adapter createReportBuilderStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ReportAdapterFactory