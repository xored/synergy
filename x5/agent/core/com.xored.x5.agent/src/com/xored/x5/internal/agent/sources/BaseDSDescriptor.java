package com.xored.x5.internal.agent.sources;

import org.eclipse.emf.ecore.EClass;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceRegistry;
import com.xored.x5.core.BaseDataSource;

public class BaseDSDescriptor extends DSDescriptor {

	BaseDSDescriptor(BaseDataSource source, DataSourceRegistry manager) {
		super(source, manager);
		factory = manager.getFactory(source.getId());
	}

	@Override
	public DataSource createSource() {
		return factory.create(source.getOptions().map());
	}

	@Override
	public EClass getEClass() {
		return factory.getEClass();
	}

	@Override
	public Class<? extends DataSource> getSourceClass() {
		return factory.getSourceClass();
	}

	private DataSourceFactory factory;

}
