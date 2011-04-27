/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eclipse Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getWorkspaceLocation <em>Workspace Location</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getApplicationId <em>Application Id</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getApplicationArgs <em>Application Args</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getBuildId <em>Build Id</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getUptime <em>Uptime</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo()
 * @model
 * @generated
 */
public interface EclipseInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Workspace Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workspace Location</em>' attribute.
	 * @see #setWorkspaceLocation(String)
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_WorkspaceLocation()
	 * @model
	 * @generated
	 */
	String getWorkspaceLocation();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getWorkspaceLocation <em>Workspace Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workspace Location</em>' attribute.
	 * @see #getWorkspaceLocation()
	 * @generated
	 */
	void setWorkspaceLocation(String value);

	/**
	 * Returns the value of the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Id</em>' attribute.
	 * @see #setProductId(String)
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_ProductId()
	 * @model
	 * @generated
	 */
	String getProductId();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getProductId <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Id</em>' attribute.
	 * @see #getProductId()
	 * @generated
	 */
	void setProductId(String value);

	/**
	 * Returns the value of the '<em><b>Application Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Id</em>' attribute.
	 * @see #setApplicationId(String)
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_ApplicationId()
	 * @model
	 * @generated
	 */
	String getApplicationId();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getApplicationId <em>Application Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Id</em>' attribute.
	 * @see #getApplicationId()
	 * @generated
	 */
	void setApplicationId(String value);

	/**
	 * Returns the value of the '<em><b>Application Args</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Args</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Args</em>' attribute list.
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_ApplicationArgs()
	 * @model
	 * @generated
	 */
	EList<String> getApplicationArgs();

	/**
	 * Returns the value of the '<em><b>Build Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Build Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build Id</em>' attribute.
	 * @see #setBuildId(String)
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_BuildId()
	 * @model
	 * @generated
	 */
	String getBuildId();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getBuildId <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Id</em>' attribute.
	 * @see #getBuildId()
	 * @generated
	 */
	void setBuildId(String value);

	/**
	 * Returns the value of the '<em><b>Uptime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uptime</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uptime</em>' attribute.
	 * @see #setUptime(long)
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_Uptime()
	 * @model
	 * @generated
	 */
	long getUptime();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.core.model.sherlock.EclipseInfo#getUptime <em>Uptime</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uptime</em>' attribute.
	 * @see #getUptime()
	 * @generated
	 */
	void setUptime(long value);

	/**
	 * Returns the value of the '<em><b>Plugins</b></em>' containment reference list.
	 * The list contents are of type {@link com.xored.sherlock.core.model.sherlock.EclipsePlugin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugins</em>' containment reference list.
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_Plugins()
	 * @model containment="true"
	 * @generated
	 */
	EList<EclipsePlugin> getPlugins();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link com.xored.sherlock.core.model.sherlock.EclipseFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage#getEclipseInfo_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<EclipseFeature> getFeatures();

} // EclipseInfo
