package com.xored.sherlock.internal.eclipse.core;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;

public class DataSourceDescriptor implements DataSourceFactory {

	public static DataSourceDescriptor read(IConfigurationElement config) throws CoreException {
		return new DataSourceDescriptor(config);
	}

	@Override
	public DataSource create(Map<String, String> options) {
		try {
			DataSource source = (DataSource) element.createExecutableExtension(ATTR_CLASS);
			source.initialize(options);
			return source;
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	@Override
	public EClass getType() {
		return eClass;
	}

	public String getId() {
		return id;
	}

	private DataSourceDescriptor(IConfigurationElement element) throws CoreException {
		this.element = element;
		this.id = element.getAttribute(ATTR_ID);
		this.eClass = parseEClass(element.getAttribute(ATTR_ECLASS));
	}

	private EClass parseEClass(String text) {
		URI uri = URI.createURI(text);
		return (EClass) new ResourceSetImpl().getEObject(uri, true);
	}

	private IConfigurationElement element;
	private String id;
	private EClass eClass;

	private static final String ATTR_CLASS = "class";
	private static final String ATTR_ECLASS = "eClass";
	private static final String ATTR_ID = "id";

}
