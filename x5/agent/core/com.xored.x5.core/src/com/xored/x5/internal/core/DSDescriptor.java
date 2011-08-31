package com.xored.x5.internal.core;

import org.eclipse.emf.ecore.EClass;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceManager;
import com.xored.x5.core.BaseDataSource;
import com.xored.x5.core.CompositeDataSource;

public abstract class DSDescriptor {

	public static DSDescriptor create(BaseDataSource source, DataSourceManager manager) {
		if (source instanceof CompositeDataSource) {
			return new CompositeDSDescriptor((CompositeDataSource) source, manager);
		} else {
			return new BaseDSDescriptor(source, manager);
		}
	}

	DSDescriptor(BaseDataSource source, DataSourceManager manager) {
		this.source = source;
		this.manager = manager;
	}

	public abstract DataSource createSource();

	public abstract EClass getEClass();

	protected BaseDataSource source;
	protected DataSourceManager manager;

}