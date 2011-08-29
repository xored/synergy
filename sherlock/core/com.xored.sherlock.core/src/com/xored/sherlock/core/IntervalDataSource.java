package com.xored.sherlock.core;

import org.eclipse.emf.ecore.EObject;

public interface IntervalDataSource extends DataSource {

	EObject start();

	EObject finish();

}
