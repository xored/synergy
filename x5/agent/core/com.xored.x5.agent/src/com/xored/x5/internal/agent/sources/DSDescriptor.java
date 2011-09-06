package com.xored.x5.internal.agent.sources;

import org.eclipse.emf.ecore.EClass;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceRegistry;
import com.xored.x5.core.BaseDataSource;
import com.xored.x5.core.CompositeDataSource;

public abstract class DSDescriptor {

	public static DSDescriptor create(BaseDataSource source, DataSourceRegistry manager) {
		// TODO do we really need this? Need to refresh overloading knowledge...
		if (source instanceof CompositeDataSource) {
			return create((CompositeDataSource) source, manager);
		}
		return new BaseDSDescriptor(source, manager);
	}

	public static CompositeDSDescriptor create(CompositeDataSource source, DataSourceRegistry manager) {
		return new CompositeDSDescriptor((CompositeDataSource) source, manager);
	}

	DSDescriptor(BaseDataSource source, DataSourceRegistry manager) {
		this.source = source;
		this.manager = manager;
	}

	public abstract DataSource createSource();

	public abstract EClass getEClass();

	public abstract Class<? extends DataSource> getSourceClass();

	protected BaseDataSource source;
	protected DataSourceRegistry manager;

}
