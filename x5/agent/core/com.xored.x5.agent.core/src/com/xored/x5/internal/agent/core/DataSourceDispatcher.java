package com.xored.x5.internal.agent.core;

import java.util.concurrent.ExecutorService;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.EntityDataSource;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.ProcessDataSource;

public class DataSourceDispatcher {

	public static DataSourceSender create(DataSourceFactory factory, ExecutorService executor) {
		Class<?> clazz = factory.getSourceClass();
		if (EventDataSource.class.isAssignableFrom(clazz)) {
			return new EventDataSourceSender(factory, executor);
		} else if (EntityDataSource.class.isAssignableFrom(clazz)) {
			return new EntityDataSourceSender(factory, executor);
		} else if (ProcessDataSource.class.isAssignableFrom(clazz)) {
			return new ProcessDataSourceSender(factory, executor);
		}
		return null;
	}

}
