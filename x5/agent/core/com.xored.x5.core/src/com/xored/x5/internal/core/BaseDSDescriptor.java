package com.xored.x5.internal.core;

import org.eclipse.emf.ecore.EClass;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceManager;
import com.xored.x5.core.BaseDataSource;

public class BaseDSDescriptor extends DSDescriptor {

	public BaseDSDescriptor(BaseDataSource source, DataSourceManager manager) {
		super(source, manager);
	}

	@Override
	public DataSource createSource() {
		return manager.getSource(source.getId(), source.getOptions().map());
	}

	@Override
	public EClass getEClass() {
		return manager.getSourceType(source.getId());
	}

}
