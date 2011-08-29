package com.xored.sherlock.system;

import java.util.Map;

import com.xored.sherlock.core.EntityDataSource;

public class SystemSource implements EntityDataSource {

	@Override
	public System getData() {
		System system = SystemFactory.eINSTANCE.createSystem();
		system.setOsName(java.lang.System.getProperty(PROPERTY_OS_NAME));
		system.setOsVersion(java.lang.System.getProperty(PROPERTY_OS_VERSION));
		system.setOsArch(java.lang.System.getProperty(PROPERTY_OS_ARCH));

		system.setUsername(java.lang.System.getProperty(PROPERTY_USER_NAME));
		system.setUserHome(java.lang.System.getProperty(PROPERTY_USER_HOME));
		system.setWorkDir(java.lang.System.getProperty(PROPERTY_WORD_DIR));
		system.setLanguage(java.lang.System.getProperty(PROPERTY_LANG));
		system.setRegion(java.lang.System.getProperty(PROPERTY_REGION));
		system.setTimezone(java.lang.System.getProperty(PROPERTY_TIMEZONE));

		system.getVariables().putAll(java.lang.System.getenv());
		return system;
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	private static final String PROPERTY_OS_NAME = "os.name";
	private static final String PROPERTY_OS_VERSION = "os.version";
	private static final String PROPERTY_OS_ARCH = "os.arch";
	private static final String PROPERTY_USER_NAME = "user.name";
	private static final String PROPERTY_USER_HOME = "user.home";
	private static final String PROPERTY_WORD_DIR = "user.dir";
	private static final String PROPERTY_LANG = "user.language";
	private static final String PROPERTY_REGION = "user.region";
	private static final String PROPERTY_TIMEZONE = "user.timezone";

}
