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
 * A representation of the model object '<em><b>Disk Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.xored.sherlock.eclipse.workspace.DiskPartition#getFreeSpace <em>Free Space</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.workspace.DiskPartition#getTotalSpace <em>Total Space</em>}</li>
 *   <li>{@link com.xored.sherlock.eclipse.workspace.DiskPartition#getUsableSpace <em>Usable Space</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.xored.sherlock.eclipse.workspace.WorkspacePackage#getDiskPartition()
 * @model
 * @generated
 */
public interface DiskPartition extends EObject {
	/**
	 * Returns the value of the '<em><b>Free Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Free Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Free Space</em>' attribute.
	 * @see #setFreeSpace(long)
	 * @see com.xored.sherlock.eclipse.workspace.WorkspacePackage#getDiskPartition_FreeSpace()
	 * @model
	 * @generated
	 */
	long getFreeSpace();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.workspace.DiskPartition#getFreeSpace <em>Free Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Free Space</em>' attribute.
	 * @see #getFreeSpace()
	 * @generated
	 */
	void setFreeSpace(long value);

	/**
	 * Returns the value of the '<em><b>Total Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Space</em>' attribute.
	 * @see #setTotalSpace(long)
	 * @see com.xored.sherlock.eclipse.workspace.WorkspacePackage#getDiskPartition_TotalSpace()
	 * @model
	 * @generated
	 */
	long getTotalSpace();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.workspace.DiskPartition#getTotalSpace <em>Total Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Space</em>' attribute.
	 * @see #getTotalSpace()
	 * @generated
	 */
	void setTotalSpace(long value);

	/**
	 * Returns the value of the '<em><b>Usable Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usable Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usable Space</em>' attribute.
	 * @see #setUsableSpace(long)
	 * @see com.xored.sherlock.eclipse.workspace.WorkspacePackage#getDiskPartition_UsableSpace()
	 * @model
	 * @generated
	 */
	long getUsableSpace();

	/**
	 * Sets the value of the '{@link com.xored.sherlock.eclipse.workspace.DiskPartition#getUsableSpace <em>Usable Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usable Space</em>' attribute.
	 * @see #getUsableSpace()
	 * @generated
	 */
	void setUsableSpace(long value);

} // DiskPartition
