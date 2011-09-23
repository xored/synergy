package com.xored.x5.internal.agent.core;

import java.util.concurrent.ExecutorService;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.EntityDataSource;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.ProcessDataSource;
import com.xored.x5.common.Log;

public class DataSourceDispatcher {

	public static DataSourceSender create(DataSourceFactory factory, ExecutorService executor, Log log) {
		Class<?> clazz = factory.getSourceClass();
		if (EventDataSource.class.isAssignableFrom(clazz)) {
			return new EventDataSourceSender(factory, executor, log);
		} else if (EntityDataSource.class.isAssignableFrom(clazz)) {
			return new EntityDataSourceSender(factory, executor, log);
		} else if (ProcessDataSource.class.isAssignableFrom(clazz)) {
			return new ProcessDataSourceSender(factory, executor, log);
		}
		return null;
	}

}
