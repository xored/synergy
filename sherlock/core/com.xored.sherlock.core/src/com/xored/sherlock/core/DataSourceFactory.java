package com.xored.sherlock.core;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;

public interface DataSourceFactory {

	DataSource create(Map<String, String> options);

	EClass getEClass();

}
