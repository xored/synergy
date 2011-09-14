package com.xored.x5.agent;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.EventDataSource;

public class DataSourceReference {

	public DataSourceReference(String name, DataSourceFactory factory) {
		this.factory = factory;
		this.eReference = createReference(name);
	}

	public String getName() {
		return eReference.getName();
	}

	public DataSourceFactory getFactory() {
		return factory;
	}

	public EReference getEReference() {
		return eReference;
	}

	public DataSource createSource() {
		Map<String, String> options = Collections.emptyMap();
		return factory.create(options);
	}

	private EReference createReference(String name) {
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setName(name);
		eReference.setContainment(true);
		// is many?
		if (EventDataSource.class.isAssignableFrom(factory.getSourceClass())) {
			eReference.setUpperBound(-1);
		}
		eReference.setEType(factory.getEClass());
		return eReference;
	}

	private DataSourceFactory factory;
	private EReference eReference;

}
