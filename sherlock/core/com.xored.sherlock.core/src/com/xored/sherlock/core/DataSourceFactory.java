package com.xored.sherlock.core;

import java.util.Map;

public interface DataSourceFactory {

	DataSource create(Map<String, String> options);

}
