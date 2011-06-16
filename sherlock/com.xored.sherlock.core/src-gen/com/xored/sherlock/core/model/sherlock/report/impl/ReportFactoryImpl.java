/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock.report.impl;

import com.xored.sherlock.core.model.sherlock.report.*;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReportFactoryImpl extends EFactoryImpl implements ReportFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReportFactory init() {
		try {
			ReportFactory theReportFactory = (ReportFactory)EPackage.Registry.INSTANCE.getEFactory("http://xored.com/sherlock/report/1.0"); 
			if (theReportFactory != null) {
				return theReportFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ReportFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ReportPackage.REPORT: return createReport();
			case ReportPackage.REPORT_CONTAINER: return createReportContainer();
			case ReportPackage.NODE: return createNode();
			case ReportPackage.EVENT: return createEvent();
			case ReportPackage.CATEGORY: return createCategory();
			case ReportPackage.EVENT_SOURCE: return createEventSource();
			case ReportPackage.PROPERTY_MAP: return (EObject)createPropertyMap();
			case ReportPackage.SNAPHOT: return createSnaphot();
			case ReportPackage.REPORT_BUILDER_STORE: return createReportBuilderStore();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Report createReport() {
		ReportImpl report = new ReportImpl();
		return report;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportContainer createReportContainer() {
		ReportContainerImpl reportContainer = new ReportContainerImpl();
		return reportContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category createCategory() {
		CategoryImpl category = new CategoryImpl();
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSource createEventSource() {
		EventSourceImpl eventSource = new EventSourceImpl();
		return eventSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createPropertyMap() {
		PropertyMapImpl propertyMap = new PropertyMapImpl();
		return propertyMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snaphot createSnaphot() {
		SnaphotImpl snaphot = new SnaphotImpl();
		return snaphot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportBuilderStore createReportBuilderStore() {
		ReportBuilderStoreImpl reportBuilderStore = new ReportBuilderStoreImpl();
		return reportBuilderStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportPackage getReportPackage() {
		return (ReportPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ReportPackage getPackage() {
		return ReportPackage.eINSTANCE;
	}

} //ReportFactoryImpl
