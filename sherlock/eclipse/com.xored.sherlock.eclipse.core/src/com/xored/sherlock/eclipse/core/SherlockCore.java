package com.xored.sherlock.eclipse.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import com.xored.sherlock.core.DataSourceManager;
import com.xored.sherlock.internal.eclipse.core.DataSourceDescriptor;

public class SherlockCore {

	// The plug-in ID
	public static final String PLUGIN_ID = SherlockCore.class.getPackage()
			.getName();

	public synchronized static DataSourceManager getManager() {
		if (instance == null) {
			instance = new DataSourceManager();
			readExtensions();
		}
		return instance;
	}

	private static void readExtensions() {
		IConfigurationElement[] configs = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTPT_SOURCES);
		for (IConfigurationElement config : configs) {
			try {
				readDataSource(config);
			} catch (Exception e) {
				StringBuilder builder = new StringBuilder();
				builder.append("Problem while loading '");
				builder.append(EXTPT_SOURCES);
				builder.append("' extension");
				try {
					String plugin = config.getNamespaceIdentifier();
					builder.append(" from the '");
					builder.append(plugin);
					builder.append("' plugin");
				} catch (Exception exc) {
					// ignore exc
				}
				builder.append(": ");
				builder.append(e.getMessage());
				log(builder.toString(), e);
			}
		}
	}

	private static void readDataSource(IConfigurationElement config)
			throws CoreException {
		DataSourceDescriptor descriptor = DataSourceDescriptor.read(config);
		instance.add(descriptor.getId(), descriptor);
	}

	private static void log(String message, Throwable t) {
		ILog log = Platform.getLog(Platform.getBundle(PLUGIN_ID));
		log.log(createStatus(message, t));
	}

	private static IStatus createStatus(String message, Throwable t) {
		return new Status(IStatus.ERROR, PLUGIN_ID, message, t);
	}

	private static DataSourceManager instance;

	private static final String EXTPT_SOURCES = PLUGIN_ID + ".sources";

}
