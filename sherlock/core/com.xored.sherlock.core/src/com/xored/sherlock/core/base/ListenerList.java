package com.xored.sherlock.core.base;

import java.util.ArrayList;

/**
 * Thread-safe listener storage. Additionally notify about adding first element
 * and removing last element to perform some initialization/finalization.<br>
 * <br>
 * NOTE: Current implementation based on assumption that list very small and
 * therefore do not care about performance.
 * 
 * @author Yuri Strot
 */
public class ListenerList<T> {

	/**
	 * @param t
	 * @return true if the first element was added
	 */
	public synchronized boolean add(T t) {
		if (!list.contains(t)) {
			list.add(t);
			return list.size() == 1;
		}
		return false;
	}

	/**
	 * @param t
	 * @return true if the last element was removed
	 */
	public synchronized boolean remove(T t) {
		if (list.size() > 0) {
			list.remove(t);
			return list.size() == 0;
		}
		return false;
	}

	/**
	 * Return copy of listener list that can be freely iterated
	 */
	public synchronized Iterable<T> iterable() {
		return new ArrayList<T>(list);
	}

	private ArrayList<T> list = new ArrayList<T>();

}
