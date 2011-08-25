/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.x5.core.impl;

import com.xored.x5.core.*;

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
public class X5FactoryImpl extends EFactoryImpl implements X5Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static X5Factory init() {
		try {
			X5Factory theX5Factory = (X5Factory)EPackage.Registry.INSTANCE.getEFactory("http://xored.com/x5/core.ecore"); 
			if (theX5Factory != null) {
				return theX5Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new X5FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public X5FactoryImpl() {
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
			case X5Package.BASE_DATA_SOURCE: return createBaseDataSource();
			case X5Package.COMPOSITE_DATA_SOURCE: return createCompositeDataSource();
			case X5Package.ENTRY: return (EObject)createEntry();
			case X5Package.DATA_SOURCE_REFERENCE: return createDataSourceReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseDataSource createBaseDataSource() {
		BaseDataSourceImpl baseDataSource = new BaseDataSourceImpl();
		return baseDataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeDataSource createCompositeDataSource() {
		CompositeDataSourceImpl compositeDataSource = new CompositeDataSourceImpl();
		return compositeDataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createEntry() {
		EntryImpl entry = new EntryImpl();
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSourceReference createDataSourceReference() {
		DataSourceReferenceImpl dataSourceReference = new DataSourceReferenceImpl();
		return dataSourceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public X5Package getX5Package() {
		return (X5Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static X5Package getPackage() {
		return X5Package.eINSTANCE;
	}

} //X5FactoryImpl
