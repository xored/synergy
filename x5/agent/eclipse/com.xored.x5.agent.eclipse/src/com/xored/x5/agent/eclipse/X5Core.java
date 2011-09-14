package com.xored.x5.agent.eclipse;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceRegistry;
import com.xored.sherlock.eclipse.core.SherlockCore;
import com.xored.x5.agent.DataSourceReference;
import com.xored.x5.agent.X5DataSourceFactory;

public class X5Core {

	// The plug-in ID
	public static final String PLUGIN_ID = X5Core.class.getPackage().getName();

	public synchronized static DataSourceRegistry getRegistry() {
		if (instance == null) {
			instance = SherlockCore.getRegistry();
			readExtensions();
		}
		return instance;
	}

	private static void readExtensions() {
		IConfigurationElement[] configs = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTPT_SOURCES);
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

	private static void readDataSource(IConfigurationElement config) throws CoreException {
		X5DataSourceFactory factory = readSource(config);
		// hook package building
		factory.getEPackage();
		instance.addFactory(factory);
	}

	private static X5DataSourceFactory readSource(IConfigurationElement config) {
		String id = config.getAttribute("id");
		String name = config.getAttribute("name");

		DataSourceFactory base = readFactory(config, "base");
		List<DataSourceReference> references = new ArrayList<DataSourceReference>();

		for (IConfigurationElement kid : config.getChildren()) {
			references.add(readField(kid));
		}

		return new X5DataSourceFactory(id, base, references, name);
	}

	private static DataSourceReference readField(IConfigurationElement config) {
		String name = config.getAttribute("name");
		return new DataSourceReference(name, getFactory(config));
	}

	private static DataSourceFactory getFactory(IConfigurationElement config) {
		IConfigurationElement[] references = config.getChildren("reference");
		if (references.length > 0) {
			return readFactory(references[0], "id");
		} else {
			IConfigurationElement[] sources = config.getChildren("source");
			return readSource(sources[0]);
		}
	}

	private static DataSourceFactory readFactory(IConfigurationElement config, String attr) {
		String baseId = config.getAttribute(attr);
		DataSourceFactory base = instance.getFactory(baseId);
		if (base == null) {
			throw new IllegalArgumentException("No such " + attr + " factory: '" + baseId + "'");
		}
		return base;
	}

	private static void log(String message, Throwable t) {
		ILog log = Platform.getLog(Platform.getBundle(PLUGIN_ID));
		log.log(createStatus(message, t));
	}

	private static IStatus createStatus(String message, Throwable t) {
		return new Status(IStatus.ERROR, PLUGIN_ID, message, t);
	}

	private static DataSourceRegistry instance;

	private static final String EXTPT_SOURCES = PLUGIN_ID + ".sources";

}
