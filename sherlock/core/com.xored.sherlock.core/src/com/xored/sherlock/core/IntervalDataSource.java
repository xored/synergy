package com.xored.sherlock.core;

import org.eclipse.emf.ecore.EObject;

public interface IntervalDataSource<T extends EObject> extends DataSource {

	T start();

	void finish(T object);

}
