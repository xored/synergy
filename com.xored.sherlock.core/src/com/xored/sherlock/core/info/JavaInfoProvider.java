package com.xored.sherlock.core.info;

import java.util.Map;

import org.eclipse.core.runtime.Platform;

public class JavaInfoProvider {
	private static final String PROPERTY_JAVA_RUNTIME_NAME = "java.runtime.name";
	private static final String PROPERTY_JAVA_RUNTIME_VERSION = "java.runtime.version";

	public static String getRuntimeName() {
		return System.getProperty(PROPERTY_JAVA_RUNTIME_NAME);
	}

	public static String getRuntimeVersion() {
		return System.getProperty(PROPERTY_JAVA_RUNTIME_VERSION);
	}

	public static long getMaxMemory() {
		return Runtime.getRuntime().maxMemory();
	}

	public static long getTotalMemory() {
		return Runtime.getRuntime().totalMemory();
	}

	public static long getFreeMemory() {
		return Runtime.getRuntime().freeMemory();
	}

	public static String[] getCommandLineArgs() {
		return Platform.getCommandLineArgs();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, String> getProperties() {
		return (Map) System.getProperties();
	}
}
