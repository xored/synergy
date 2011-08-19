package com.xored.sherlock.internal.eclipse;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;

public class DataSourceDescriptor implements DataSourceFactory {

	public static DataSourceDescriptor read(IConfigurationElement config)
			throws CoreException {
		return new DataSourceDescriptor(config);
	}

	@Override
	public DataSource create() {
		try {
			return (DataSource) element.createExecutableExtension(ATTR_CLASS);
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	public String getId() {
		return id;
	}

	private DataSourceDescriptor(IConfigurationElement element)
			throws CoreException {
		this.element = element;
		this.id = element.getAttribute(ATTR_ID);
	}

	private IConfigurationElement element;
	private String id;

	private static final String ATTR_CLASS = "class";
	private static final String ATTR_ID = "id";

}
