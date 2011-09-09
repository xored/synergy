/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.xored.sherlock.thread;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.xored.sherlock.thread.ThreadPackage#getThreadState()
 * @model
 * @generated
 */
public enum ThreadState implements Enumerator {
	/**
	 * The '<em><b>NEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEW_VALUE
	 * @generated
	 * @ordered
	 */
	NEW(0, "NEW", "NEW"),

	/**
	 * The '<em><b>RUNNABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNNABLE_VALUE
	 * @generated
	 * @ordered
	 */
	RUNNABLE(1, "RUNNABLE", "RUNNABLE"),

	/**
	 * The '<em><b>BLOCKED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLOCKED_VALUE
	 * @generated
	 * @ordered
	 */
	BLOCKED(2, "BLOCKED", "BLOCKED"),

	/**
	 * The '<em><b>WAITING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WAITING_VALUE
	 * @generated
	 * @ordered
	 */
	WAITING(3, "WAITING", "WAITING"),

	/**
	 * The '<em><b>TIMED WAITING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMED_WAITING_VALUE
	 * @generated
	 * @ordered
	 */
	TIMED_WAITING(4, "TIMED_WAITING", "TIMED_WAITING"),

	/**
	 * The '<em><b>TERMINATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERMINATED_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINATED(5, "TERMINATED", "TERMINATED");

	/**
	 * The '<em><b>NEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEW_VALUE = 0;

	/**
	 * The '<em><b>RUNNABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUNNABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUNNABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUNNABLE_VALUE = 1;

	/**
	 * The '<em><b>BLOCKED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BLOCKED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLOCKED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BLOCKED_VALUE = 2;

	/**
	 * The '<em><b>WAITING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WAITING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WAITING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WAITING_VALUE = 3;

	/**
	 * The '<em><b>TIMED WAITING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIMED WAITING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMED_WAITING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIMED_WAITING_VALUE = 4;

	/**
	 * The '<em><b>TERMINATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TERMINATED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TERMINATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TERMINATED_VALUE = 5;

	/**
	 * An array of all the '<em><b>State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ThreadState[] VALUES_ARRAY =
		new ThreadState[] {
			NEW,
			RUNNABLE,
			BLOCKED,
			WAITING,
			TIMED_WAITING,
			TERMINATED,
		};

	/**
	 * A public read-only list of all the '<em><b>State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ThreadState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ThreadState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ThreadState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ThreadState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ThreadState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ThreadState get(int value) {
		switch (value) {
			case NEW_VALUE: return NEW;
			case RUNNABLE_VALUE: return RUNNABLE;
			case BLOCKED_VALUE: return BLOCKED;
			case WAITING_VALUE: return WAITING;
			case TIMED_WAITING_VALUE: return TIMED_WAITING;
			case TERMINATED_VALUE: return TERMINATED;
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
	private ThreadState(int value, String name, String literal) {
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
	
} //ThreadState
