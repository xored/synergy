package com.xored.sherlock.core.info;

import java.util.Map;

public class SystemInfoProvider {
	private static final String PROPERTY_OS_NAME = "os.name";

	public static String getOSName() {
		return System.getProperty(PROPERTY_OS_NAME);
	}

	private static final String PROPERTY_OS_VERSION = "os.version";

	public static String getOSVersion() {
		return System.getProperty(PROPERTY_OS_VERSION);
	}

	private static final String PROPERTY_OS_ARCH = "os.arch";

	public static String getOSArch() {
		return System.getProperty(PROPERTY_OS_ARCH);
	}

	public static Map<String, String> getVariables() {
		return System.getenv();
	}

	private static final String PROPERTY_USER_NAME = "user.name";

	public static String getUsername() {
		return System.getProperty(PROPERTY_USER_NAME);
	}
}
