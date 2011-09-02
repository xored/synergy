package com.xored.sherlock.core;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;

public interface DataSourceFactory {

	String getId();

	EClass getEClass();

	DataSource create(Map<String, String> options);

	Class<? extends DataSource> getSourceClass();

}
