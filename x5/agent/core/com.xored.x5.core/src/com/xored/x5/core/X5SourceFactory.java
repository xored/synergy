package com.xored.x5.core;

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
			return manager.getSource(descriptor.getId(), descriptor.getOptions().map());
		}
	}

}
