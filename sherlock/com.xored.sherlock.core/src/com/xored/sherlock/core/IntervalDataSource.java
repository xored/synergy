package com.xored.sherlock.core;

import org.eclipse.emf.ecore.EObject;

public interface IntervalDataSource extends DataSource {

	void start();

	EObject finish();

	/**
	 * @throws IllegalStateException
	 *             if data was requested before source finish
	 */
	EObject getData() throws IllegalStateException;

}
