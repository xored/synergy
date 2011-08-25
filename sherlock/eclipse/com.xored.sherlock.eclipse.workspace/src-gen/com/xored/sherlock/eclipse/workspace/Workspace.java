/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.eclipse.workspace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.eclipse.workspace.Workspace#getLocation <em>Location</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.workspace.Workspace#getPartition <em>Partition</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.eclipse.workspace.WorkspacePackage#getWorkspace()
 * @model
 * @generated
 */
public interface Workspace extends EObject {

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see com.xored.sherlock.eclipse.workspace.WorkspacePackage#getWorkspace_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.workspace.Workspace#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Partition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partition</em>' containment reference.
	 * @see #setPartition(DiskPartition)
	 * @see com.xored.sherlock.eclipse.workspace.WorkspacePackage#getWorkspace_Partition()
	 * @model containment="true"
	 * @generated
	 */
	DiskPartition getPartition();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.workspace.Workspace#getPartition <em>Partition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partition</em>' containment reference.
	 * @see #getPartition()
	 * @generated
	 */
	void setPartition(DiskPartition value);
} // Workspace
