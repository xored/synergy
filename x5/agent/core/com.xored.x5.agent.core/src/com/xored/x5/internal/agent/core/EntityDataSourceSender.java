package com.xored.x5.internal.agent.core;

import java.util.concurrent.ExecutorService;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.EntityDataSource;
import com.xored.x5.common.Log;

class EntityDataSourceSender extends BaseDataSourceSender<EntityDataSource> {

	protected EntityDataSourceSender(DataSourceFactory factory, ExecutorService executor, Log log) {
		super(factory, executor, log);
	}

	@Override
	protected void attachSource(EntityDataSource source) {
		push(source.getData());
	}

	@Override
	protected void detachSource(EntityDataSource source) {
	}

}
