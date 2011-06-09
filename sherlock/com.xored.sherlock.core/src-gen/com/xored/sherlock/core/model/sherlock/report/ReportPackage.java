/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock.report;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.core.model.sherlock.report.ReportFactory
 * @model kind="package"
 * @generated
 */
public interface ReportPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "report";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///com/xored/sherlock/core/model/sherlock/report.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.xored.sherlock.core.model.sherlock.report";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReportPackage eINSTANCE = com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.ReportImpl <em>Report</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportImpl
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getReport()
	 * @generated
	 */
	int REPORT = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__ROOT = 0;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__CATEGORIES = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__PROPERTIES = 2;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT__SOURCES = 3;

	/**
	 * The number of structural features of the '<em>Report</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.NodeImpl
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__START_TIME = 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__END_TIME = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CHILDREN = 2;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EVENTS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PROPERTIES = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PARENT = 6;

	/**
	 * The feature id for the '<em><b>Report</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__REPORT = 7;

	/**
	 * The feature id for the '<em><b>Snapshots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SNAPSHOTS = 8;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.EventImpl
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 2;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TIME = 0;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__CATEGORY = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PROPERTIES = 2;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DATA = 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SOURCE = 4;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.CategoryImpl
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ID = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__PROPERTIES = 2;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.EventSourceImpl <em>Event Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.EventSourceImpl
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEventSource()
	 * @generated
	 */
	int EVENT_SOURCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SOURCE__PROPERTIES = 1;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SOURCE__EVENTS = 2;

	/**
	 * The number of structural features of the '<em>Event Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_SOURCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.PropertyMapImpl <em>Property Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.PropertyMapImpl
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getPropertyMap()
	 * @generated
	 */
	int PROPERTY_MAP = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.SnaphotImpl <em>Snaphot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.SnaphotImpl
	 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getSnaphot()
	 * @generated
	 */
	int SNAPHOT = 6;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPHOT__TIME = 0;

	/**
	 * The feature id for the '<em><b>Category</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPHOT__CATEGORY = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPHOT__PROPERTIES = 2;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPHOT__DATA = 3;

	/**
	 * The number of structural features of the '<em>Snaphot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPHOT_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.core.model.sherlock.report.Report <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Report</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Report
	 * @generated
	 */
	EClass getReport();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.sherlock.core.model.sherlock.report.Report#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Report#getRoot()
	 * @see #getReport()
	 * @generated
	 */
	EReference getReport_Root();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.core.model.sherlock.report.Report#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Report#getCategories()
	 * @see #getReport()
	 * @generated
	 */
	EReference getReport_Categories();

	/**
	 * Returns the meta object for the map '{@link com.xored.sherlock.core.model.sherlock.report.Report#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Report#getProperties()
	 * @see #getReport()
	 * @generated
	 */
	EReference getReport_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.core.model.sherlock.report.Report#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sources</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Report#getSources()
	 * @see #getReport()
	 * @generated
	 */
	EReference getReport_Sources();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.core.model.sherlock.report.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.core.model.sherlock.report.Node#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getStartTime()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.core.model.sherlock.report.Node#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getEndTime()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_EndTime();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.core.model.sherlock.report.Node#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getChildren()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Children();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.core.model.sherlock.report.Node#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getEvents()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Events();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.core.model.sherlock.report.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the map '{@link com.xored.sherlock.core.model.sherlock.report.Node#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getProperties()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Properties();

	/**
	 * Returns the meta object for the container reference '{@link com.xored.sherlock.core.model.sherlock.report.Node#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getParent()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Parent();

	/**
	 * Returns the meta object for the container reference '{@link com.xored.sherlock.core.model.sherlock.report.Node#getReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Report</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getReport()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Report();

	/**
	 * Returns the meta object for the containment reference list '{@link com.xored.sherlock.core.model.sherlock.report.Node#getSnapshots <em>Snapshots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Snapshots</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Node#getSnapshots()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Snapshots();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.core.model.sherlock.report.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.core.model.sherlock.report.Event#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Event#getTime()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Time();

	/**
	 * Returns the meta object for the reference '{@link com.xored.sherlock.core.model.sherlock.report.Event#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Category</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Event#getCategory()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Category();

	/**
	 * Returns the meta object for the map '{@link com.xored.sherlock.core.model.sherlock.report.Event#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Event#getProperties()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.sherlock.core.model.sherlock.report.Event#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Event#getData()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Data();

	/**
	 * Returns the meta object for the reference '{@link com.xored.sherlock.core.model.sherlock.report.Event#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Event#getSource()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Source();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.core.model.sherlock.report.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.core.model.sherlock.report.Category#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Category#getName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.core.model.sherlock.report.Category#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Category#getId()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Id();

	/**
	 * Returns the meta object for the map '{@link com.xored.sherlock.core.model.sherlock.report.Category#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Category#getProperties()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Properties();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.core.model.sherlock.report.EventSource <em>Event Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Source</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.EventSource
	 * @generated
	 */
	EClass getEventSource();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.core.model.sherlock.report.EventSource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.EventSource#getName()
	 * @see #getEventSource()
	 * @generated
	 */
	EAttribute getEventSource_Name();

	/**
	 * Returns the meta object for the map '{@link com.xored.sherlock.core.model.sherlock.report.EventSource#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.EventSource#getProperties()
	 * @see #getEventSource()
	 * @generated
	 */
	EReference getEventSource_Properties();

	/**
	 * Returns the meta object for the reference '{@link com.xored.sherlock.core.model.sherlock.report.EventSource#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Events</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.EventSource#getEvents()
	 * @see #getEventSource()
	 * @generated
	 */
	EReference getEventSource_Events();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Property Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getPropertyMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyMap()
	 * @generated
	 */
	EAttribute getPropertyMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyMap()
	 * @generated
	 */
	EAttribute getPropertyMap_Value();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.core.model.sherlock.report.Snaphot <em>Snaphot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snaphot</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Snaphot
	 * @generated
	 */
	EClass getSnaphot();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.core.model.sherlock.report.Snaphot#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Snaphot#getTime()
	 * @see #getSnaphot()
	 * @generated
	 */
	EAttribute getSnaphot_Time();

	/**
	 * Returns the meta object for the reference '{@link com.xored.sherlock.core.model.sherlock.report.Snaphot#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Category</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Snaphot#getCategory()
	 * @see #getSnaphot()
	 * @generated
	 */
	EReference getSnaphot_Category();

	/**
	 * Returns the meta object for the map '{@link com.xored.sherlock.core.model.sherlock.report.Snaphot#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Snaphot#getProperties()
	 * @see #getSnaphot()
	 * @generated
	 */
	EReference getSnaphot_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.sherlock.core.model.sherlock.report.Snaphot#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see com.xored.sherlock.core.model.sherlock.report.Snaphot#getData()
	 * @see #getSnaphot()
	 * @generated
	 */
	EReference getSnaphot_Data();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReportFactory getReportFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.ReportImpl <em>Report</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportImpl
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getReport()
		 * @generated
		 */
		EClass REPORT = eINSTANCE.getReport();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT__ROOT = eINSTANCE.getReport_Root();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT__CATEGORIES = eINSTANCE.getReport_Categories();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT__PROPERTIES = eINSTANCE.getReport_Properties();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPORT__SOURCES = eINSTANCE.getReport_Sources();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.NodeImpl
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__START_TIME = eINSTANCE.getNode_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__END_TIME = eINSTANCE.getNode_EndTime();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CHILDREN = eINSTANCE.getNode_Children();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__EVENTS = eINSTANCE.getNode_Events();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PROPERTIES = eINSTANCE.getNode_Properties();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PARENT = eINSTANCE.getNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Report</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__REPORT = eINSTANCE.getNode_Report();

		/**
		 * The meta object literal for the '<em><b>Snapshots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SNAPSHOTS = eINSTANCE.getNode_Snapshots();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.EventImpl
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TIME = eINSTANCE.getEvent_Time();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__CATEGORY = eINSTANCE.getEvent_Category();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__PROPERTIES = eINSTANCE.getEvent_Properties();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__DATA = eINSTANCE.getEvent_Data();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__SOURCE = eINSTANCE.getEvent_Source();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.CategoryImpl
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__ID = eINSTANCE.getCategory_Id();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__PROPERTIES = eINSTANCE.getCategory_Properties();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.EventSourceImpl <em>Event Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.EventSourceImpl
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getEventSource()
		 * @generated
		 */
		EClass EVENT_SOURCE = eINSTANCE.getEventSource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_SOURCE__NAME = eINSTANCE.getEventSource_Name();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_SOURCE__PROPERTIES = eINSTANCE.getEventSource_Properties();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_SOURCE__EVENTS = eINSTANCE.getEventSource_Events();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.PropertyMapImpl <em>Property Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.PropertyMapImpl
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getPropertyMap()
		 * @generated
		 */
		EClass PROPERTY_MAP = eINSTANCE.getPropertyMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MAP__KEY = eINSTANCE.getPropertyMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MAP__VALUE = eINSTANCE.getPropertyMap_Value();

		/**
		 * The meta object literal for the '{@link com.xored.sherlock.core.model.sherlock.report.impl.SnaphotImpl <em>Snaphot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.SnaphotImpl
		 * @see com.xored.sherlock.core.model.sherlock.report.impl.ReportPackageImpl#getSnaphot()
		 * @generated
		 */
		EClass SNAPHOT = eINSTANCE.getSnaphot();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPHOT__TIME = eINSTANCE.getSnaphot_Time();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPHOT__CATEGORY = eINSTANCE.getSnaphot_Category();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPHOT__PROPERTIES = eINSTANCE.getSnaphot_Properties();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPHOT__DATA = eINSTANCE.getSnaphot_Data();

	}

} //ReportPackage
