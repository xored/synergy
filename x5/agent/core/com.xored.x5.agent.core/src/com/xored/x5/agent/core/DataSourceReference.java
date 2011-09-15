package com.xored.x5.agent.core;

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
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public DataSourceFactory getFactory() {
		return factory;
	}

	public DataSource createSource() {
		Map<String, String> options = Collections.emptyMap();
		return factory.create(options);
	}

	EReference getEReference() {
		return eReference;
	}

	EReference initReference(EReference eReference) {
		if (eReference == null) {
			eReference = createReference(name);
		} else {
			if (!eReference.isContainment()) {
				throw new IllegalArgumentException("Wrong reference '" + eReference.getName()
						+ "': containment != true");
			}
			if (eReference.isMany() != isMany()) {
				throw new IllegalArgumentException("Wrong reference '" + eReference.getName() + "': many != "
						+ isMany());
			}
			if (eReference.getEType() != factory.getEClass()) {
				throw new IllegalArgumentException("Wrong reference '" + eReference.getName() + "': type == "
						+ eReference.getEType() + ", but expect " + factory.getEClass());
			}
		}
		this.eReference = eReference;
		return eReference;
	}

	private EReference createReference(String name) {
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setName(name);
		eReference.setContainment(true);
		// is many?
		if (isMany()) {
			eReference.setUpperBound(-1);
		}
		eReference.setEType(factory.getEClass());
		return eReference;
	}

	private boolean isMany() {
		return EventDataSource.class.isAssignableFrom(factory.getSourceClass());
	}

	private DataSourceFactory factory;
	private EReference eReference;
	private String name;

}
