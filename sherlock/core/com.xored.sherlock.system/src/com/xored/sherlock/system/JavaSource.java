package com.xored.sherlock.system;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.xored.sherlock.core.EntityDataSource;

public class JavaSource implements EntityDataSource {

	@Override
	public Java getData() {
		Java j = SystemFactory.eINSTANCE.createJava();
		j.setRuntimeName(java.lang.System.getProperty(PROPERTY_JAVA_NAME));
		j.setRuntimeVersion(java.lang.System.getProperty(PROPERTY_JAVA_VERSION));
		Set<Entry<Object, Object>> entries = java.lang.System.getProperties()
				.entrySet();
		for (Entry<Object, Object> entry : entries) {
			j.getProperties().put((String) entry.getKey(),
					(String) entry.getValue());
		}

		Runtime runtime = Runtime.getRuntime();
		j.setFreeMemory(runtime.freeMemory());
		j.setTotalMemory(runtime.totalMemory());
		j.setMaxMemory(runtime.maxMemory());
		return j;
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	private static final String PROPERTY_JAVA_NAME = "java.runtime.name";
	private static final String PROPERTY_JAVA_VERSION = "java.runtime.version";

}
