/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.eclipse.platform;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Plugin State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.eclipse.platform.PlatformPackage#getPluginState()
 * @model
 * @generated
 */
public enum PluginState implements Enumerator {
	/**
	 * The '<em><b>UNINSTALLED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNINSTALLED_VALUE
	 * @generated
	 * @ordered
	 */
	UNINSTALLED(1, "UNINSTALLED", "UNINSTALLED"),

	/**
	 * The '<em><b>INSTALLED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTALLED_VALUE
	 * @generated
	 * @ordered
	 */
	INSTALLED(2, "INSTALLED", "INSTALLED"),

	/**
	 * The '<em><b>RESOLVED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOLVED_VALUE
	 * @generated
	 * @ordered
	 */
	RESOLVED(4, "RESOLVED", "RESOLVED"),

	/**
	 * The '<em><b>STARTING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STARTING_VALUE
	 * @generated
	 * @ordered
	 */
	STARTING(8, "STARTING", "STARTING"),

	/**
	 * The '<em><b>STOPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOPPING_VALUE
	 * @generated
	 * @ordered
	 */
	STOPPING(16, "STOPPING", "STOPPING"),

	/**
	 * The '<em><b>ACTIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE(32, "ACTIVE", "ACTIVE");

	/**
	 * The '<em><b>UNINSTALLED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNINSTALLED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNINSTALLED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNINSTALLED_VALUE = 1;

	/**
	 * The '<em><b>INSTALLED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INSTALLED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTALLED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INSTALLED_VALUE = 2;

	/**
	 * The '<em><b>RESOLVED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESOLVED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESOLVED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RESOLVED_VALUE = 4;

	/**
	 * The '<em><b>STARTING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STARTING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STARTING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STARTING_VALUE = 8;

	/**
	 * The '<em><b>STOPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STOPPING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOPPING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STOPPING_VALUE = 16;

	/**
	 * The '<em><b>ACTIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_VALUE = 32;

	/**
	 * An array of all the '<em><b>Plugin State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PluginState[] VALUES_ARRAY =
		new PluginState[] {
			UNINSTALLED,
			INSTALLED,
			RESOLVED,
			STARTING,
			STOPPING,
			ACTIVE,
		};

	/**
	 * A public read-only list of all the '<em><b>Plugin State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PluginState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Plugin State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PluginState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PluginState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Plugin State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PluginState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PluginState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Plugin State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PluginState get(int value) {
		switch (value) {
			case UNINSTALLED_VALUE: return UNINSTALLED;
			case INSTALLED_VALUE: return INSTALLED;
			case RESOLVED_VALUE: return RESOLVED;
			case STARTING_VALUE: return STARTING;
			case STOPPING_VALUE: return STOPPING;
			case ACTIVE_VALUE: return ACTIVE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private PluginState(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //PluginState
