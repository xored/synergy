/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.core.model.sherlock.util;

import com.xored.sherlock.core.model.sherlock.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.core.model.sherlock.SherlockPackage
 * @generated
 */
public class SherlockAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SherlockPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SherlockAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SherlockPackage.eINSTANCE;
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
	protected SherlockSwitch<Adapter> modelSwitch =
		new SherlockSwitch<Adapter>() {
			@Override
			public Adapter caseSystemInfo(SystemInfo object) {
				return createSystemInfoAdapter();
			}
			@Override
			public Adapter caseSystemVariable(SystemVariable object) {
				return createSystemVariableAdapter();
			}
			@Override
			public Adapter caseJavaInfo(JavaInfo object) {
				return createJavaInfoAdapter();
			}
			@Override
			public Adapter caseJavaProperty(JavaProperty object) {
				return createJavaPropertyAdapter();
			}
			@Override
			public Adapter caseEclipseInfo(EclipseInfo object) {
				return createEclipseInfoAdapter();
			}
			@Override
			public Adapter caseEclipsePlugin(EclipsePlugin object) {
				return createEclipsePluginAdapter();
			}
			@Override
			public Adapter caseEclipseFeature(EclipseFeature object) {
				return createEclipseFeatureAdapter();
			}
			@Override
			public Adapter caseJavaException(JavaException object) {
				return createJavaExceptionAdapter();
			}
			@Override
			public Adapter caseJavaStackTraceEntry(JavaStackTraceEntry object) {
				return createJavaStackTraceEntryAdapter();
			}
			@Override
			public Adapter caseEclipseStatus(EclipseStatus object) {
				return createEclipseStatusAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.SystemInfo <em>System Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.SystemInfo
	 * @generated
	 */
	public Adapter createSystemInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.SystemVariable <em>System Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.SystemVariable
	 * @generated
	 */
	public Adapter createSystemVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.JavaInfo <em>Java Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.JavaInfo
	 * @generated
	 */
	public Adapter createJavaInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.JavaProperty <em>Java Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.JavaProperty
	 * @generated
	 */
	public Adapter createJavaPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.EclipseInfo <em>Eclipse Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.EclipseInfo
	 * @generated
	 */
	public Adapter createEclipseInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.EclipsePlugin <em>Eclipse Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.EclipsePlugin
	 * @generated
	 */
	public Adapter createEclipsePluginAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.EclipseFeature <em>Eclipse Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.EclipseFeature
	 * @generated
	 */
	public Adapter createEclipseFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.JavaException <em>Java Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.JavaException
	 * @generated
	 */
	public Adapter createJavaExceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.JavaStackTraceEntry <em>Java Stack Trace Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.JavaStackTraceEntry
	 * @generated
	 */
	public Adapter createJavaStackTraceEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.xored.sherlock.core.model.sherlock.EclipseStatus <em>Eclipse Status</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.xored.sherlock.core.model.sherlock.EclipseStatus
	 * @generated
	 */
	public Adapter createEclipseStatusAdapter() {
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

} //SherlockAdapterFactory
