/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.eclipse.workspace;

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
 * @see com.xored.sherlock.eclipse.workspace.WorkspaceFactory
 * @model kind="package"
 * @generated
 */
public interface WorkspacePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workspace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xored.com/sherlock/eclipse/workspace.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.xored.sherlock.eclipse.workspace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkspacePackage eINSTANCE = com.xored.sherlock.eclipse.workspace.impl.WorkspacePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.xored.sherlock.eclipse.workspace.impl.WorkspaceImpl <em>Workspace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.eclipse.workspace.impl.WorkspaceImpl
	 * @see com.xored.sherlock.eclipse.workspace.impl.WorkspacePackageImpl#getWorkspace()
	 * @generated
	 */
	int WORKSPACE = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Partition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__PARTITION = 1;

	/**
	 * The number of structural features of the '<em>Workspace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link com.xored.sherlock.eclipse.workspace.impl.DiskPartitionImpl <em>Disk Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.xored.sherlock.eclipse.workspace.impl.DiskPartitionImpl
	 * @see com.xored.sherlock.eclipse.workspace.impl.WorkspacePackageImpl#getDiskPartition()
	 * @generated
	 */
	int DISK_PARTITION = 1;

	/**
	 * The feature id for the '<em><b>Free Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISK_PARTITION__FREE_SPACE = 0;

	/**
	 * The feature id for the '<em><b>Total Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISK_PARTITION__TOTAL_SPACE = 1;

	/**
	 * The feature id for the '<em><b>Usable Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISK_PARTITION__USABLE_SPACE = 2;

	/**
	 * The number of structural features of the '<em>Disk Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISK_PARTITION_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.eclipse.workspace.Workspace <em>Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workspace</em>'.
	 * @see com.xored.sherlock.eclipse.workspace.Workspace
	 * @generated
	 */
	EClass getWorkspace();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.workspace.Workspace#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.xored.sherlock.eclipse.workspace.Workspace#getLocation()
	 * @see #getWorkspace()
	 * @generated
	 */
	EAttribute getWorkspace_Location();

	/**
	 * Returns the meta object for the containment reference '{@link com.xored.sherlock.eclipse.workspace.Workspace#getPartition <em>Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Partition</em>'.
	 * @see com.xored.sherlock.eclipse.workspace.Workspace#getPartition()
	 * @see #getWorkspace()
	 * @generated
	 */
	EReference getWorkspace_Partition();

	/**
	 * Returns the meta object for class '{@link com.xored.sherlock.eclipse.workspace.DiskPartition <em>Disk Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disk Partition</em>'.
	 * @see com.xored.sherlock.eclipse.workspace.DiskPartition
	 * @generated
	 */
	EClass getDiskPartition();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.workspace.DiskPartition#getFreeSpace <em>Free Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Free Space</em>'.
	 * @see com.xored.sherlock.eclipse.workspace.DiskPartition#getFreeSpace()
	 * @see #getDiskPartition()
	 * @generated
	 */
	EAttribute getDiskPartition_FreeSpace();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.workspace.DiskPartition#getTotalSpace <em>Total Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Space</em>'.
	 * @see com.xored.sherlock.eclipse.workspace.DiskPartition#getTotalSpace()
	 * @see #getDiskPartition()
	 * @generated
	 */
	EAttribute getDiskPartition_TotalSpace();

	/**
	 * Returns the meta object for the attribute '{@link com.xored.sherlock.eclipse.workspace.DiskPartition#getUsableSpace <em>Usable Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usable Space</em>'.
	 * @see com.xored.sherlock.eclipse.workspace.DiskPartition#getUsableSpace()
	 * @see #getDiskPartition()
	 * @generated
	 */
	EAttribute getDiskPartition_UsableSpace();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkspaceFactory getWorkspaceFactory();

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
		 * The meta object literal for the '{@link com.xored.sherlock.eclipse.workspace.impl.WorkspaceImpl <em>Workspace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.eclipse.workspace.impl.WorkspaceImpl
		 * @see com.xored.sherlock.eclipse.workspace.impl.WorkspacePackageImpl#getWorkspace()
		 * @generated
		 */
		EClass WORKSPACE = eINSTANCE.getWorkspace();
		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKSPACE__LOCATION = eINSTANCE.getWorkspace_Location();
		/**
		 * The meta object literal for the '<em><b>Partition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE__PARTITION = eINSTANCE.getWorkspace_Partition();
		/**
		 * The meta object literal for the '{@link com.xored.sherlock.eclipse.workspace.impl.DiskPartitionImpl <em>Disk Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.xored.sherlock.eclipse.workspace.impl.DiskPartitionImpl
		 * @see com.xored.sherlock.eclipse.workspace.impl.WorkspacePackageImpl#getDiskPartition()
		 * @generated
		 */
		EClass DISK_PARTITION = eINSTANCE.getDiskPartition();
		/**
		 * The meta object literal for the '<em><b>Free Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISK_PARTITION__FREE_SPACE = eINSTANCE.getDiskPartition_FreeSpace();
		/**
		 * The meta object literal for the '<em><b>Total Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISK_PARTITION__TOTAL_SPACE = eINSTANCE.getDiskPartition_TotalSpace();
		/**
		 * The meta object literal for the '<em><b>Usable Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISK_PARTITION__USABLE_SPACE = eINSTANCE.getDiskPartition_UsableSpace();

	}

} //WorkspacePackage
