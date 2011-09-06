package com.xored.x5.internal.agent;

import java.util.concurrent.ExecutorService;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.EntityDataSource;

class EntityDataSourceSender extends BaseDataSourceSender<EntityDataSource> {

	protected EntityDataSourceSender(DataSourceFactory factory, ExecutorService executor) {
		super(factory, executor);
	}

	@Override
	protected void attachSource(EntityDataSource source) {
		push(source.getData());
	}

	@Override
	protected void detachSource(EntityDataSource source) {
	}

}
