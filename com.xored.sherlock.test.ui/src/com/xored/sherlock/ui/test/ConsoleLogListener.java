package com.xored.sherlock.ui.test;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;

import com.xored.sherlock.core.SherlockCore;
import com.xored.sherlock.core.info.Info;
import com.xored.sherlock.core.model.sherlock.EclipseFeature;
import com.xored.sherlock.core.model.sherlock.EclipseInfo;
import com.xored.sherlock.core.model.sherlock.EclipsePlugin;
import com.xored.sherlock.core.model.sherlock.EclipseStatus;
import com.xored.sherlock.core.model.sherlock.JavaInfo;
import com.xored.sherlock.core.model.sherlock.JavaProperty;
import com.xored.sherlock.core.model.sherlock.SystemInfo;
import com.xored.sherlock.core.model.sherlock.SystemVariable;

public class ConsoleLogListener implements ILogListener {
	@Override
	public void logging(IStatus status, String pluginId) {
		final EclipseStatus eclipseStatus = SherlockCore.convert(status);
		System.out.println(eclipseStatus);

		final SystemInfo systemInfo = Info.getSystem();
		final JavaInfo javaInfo = Info.getJava();
		final EclipseInfo eclipseInfo = Info.getEclipse();

		System.out.println(">>>>=========================");

		System.out.println("== System ==");
		System.out.println("OS name: " + systemInfo.getOsName());
		System.out.println("OS arch: " + systemInfo.getOsArch());
		System.out.println("OS version: " + systemInfo.getOsVersion());
		System.out.println("Username: " + systemInfo.getUsername());
		System.out.println("Variables:");
		for (SystemVariable var : systemInfo.getVariables()) {
			System.out.println("\t" + var.getName() + "=" + var.getValue());
		}

		System.out.println("== Java ==");
		System.out.println("Runtime name: " + javaInfo.getRuntimeName());
		System.out.println("Runtime version: " + javaInfo.getRuntimeVersion());
		System.out.println("Free memory: " + javaInfo.getFreeMemory());
		System.out.println("Max memory: " + javaInfo.getMaxMemory());
		System.out.println("Total memory: " + javaInfo.getTotalMemory());
		System.out.println("Properties:");
		for (JavaProperty prop : javaInfo.getProperties()) {
			System.out.println("\t" + prop.getName() + "=" + prop.getValue());
		}

		System.out.println("== Eclipse ==");
		System.out.println("Workspace: " + eclipseInfo.getWorkspaceLocation());
		System.out.println("ProductId: " + eclipseInfo.getProductId());
		System.out.println("ApplicationId: " + eclipseInfo.getApplicationId());
		System.out.println("BuildId: " + eclipseInfo.getBuildId());
		System.out.println("Uptime: " + eclipseInfo.getUptime());
		System.out.println("Plugins:");
		for (EclipsePlugin plugin : eclipseInfo.getPlugins()) {
			System.out.println("\t" + plugin.getId() + ": " + plugin.getVersion());
		}
		System.out.println("Features:");
		for (EclipseFeature feature : eclipseInfo.getFeatures()) {
			System.out.println("\t" + feature.getId() + ": " + feature.getVersion());
		}

		System.out.println("<<<<=========================");
	}
}
