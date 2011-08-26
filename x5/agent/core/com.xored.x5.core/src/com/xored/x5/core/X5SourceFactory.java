package com.xored.x5.core;

import java.util.Collections;
import java.util.Map;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceManager;
import com.xored.sherlock.core.EntityDataSource;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.ProcessDataSource;
import com.xored.x5.internal.core.X5EntityDataSource;
import com.xored.x5.internal.core.X5EventDataSource;
import com.xored.x5.internal.core.X5ProcessDataSource;

public class X5SourceFactory {

	public static DataSource create(DataSourceManager manager, BaseDataSource descriptor) {
		Map<String, String> options = Collections.emptyMap();
		return create(manager, descriptor, options);
	}

	public static DataSource create(DataSourceManager manager, BaseDataSource descriptor, Map<String, String> options) {
		if (descriptor instanceof CompositeDataSource) {
			CompositeDataSource source = (CompositeDataSource) descriptor;
			DataSource base = create(manager, source.getBase());
			if (base instanceof EventDataSource) {
				return new X5EventDataSource(manager, source, (EventDataSource) base);
			} else if (base instanceof EntityDataSource) {
				return new X5EntityDataSource(manager, source, (EntityDataSource) base);
			} else if (base instanceof ProcessDataSource) {
				return new X5ProcessDataSource(manager, source, (ProcessDataSource) base);
			}
			throw new IllegalArgumentException();
		} else {
			Map<String, String> opts = descriptor.getOptions().map();
			opts.putAll(options);
			return manager.getSource(descriptor.getId(), opts);
		}
	}

}
