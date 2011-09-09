package com.xored.x5.agent.eclipse;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import com.xored.sherlock.core.DataSourceRegistry;
import com.xored.sherlock.eclipse.core.SherlockCore;
import com.xored.x5.agent.sources.X5DataSourceFactory;
import com.xored.x5.core.BaseDataSource;
import com.xored.x5.core.CompositeDataSource;
import com.xored.x5.core.DataSourceReference;
import com.xored.x5.core.X5Factory;

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
		instance.addFactory(new X5DataSourceFactory(readSource(config), instance));
	}

	private static CompositeDataSource readSource(IConfigurationElement config) {
		CompositeDataSource source = X5Factory.eINSTANCE.createCompositeDataSource();
		source.setId(config.getAttribute("id"));
		source.setName(config.getAttribute("name"));

		BaseDataSource base = X5Factory.eINSTANCE.createBaseDataSource();
		base.setId(config.getAttribute("base"));
		source.setBase(base);

		for (IConfigurationElement kid : config.getChildren()) {
			source.getReferences().add(readField(kid));
		}

		return source;
	}

	private static DataSourceReference readField(IConfigurationElement config) {
		DataSourceReference reference = X5Factory.eINSTANCE.createDataSourceReference();
		reference.setName(config.getAttribute("name"));

		IConfigurationElement[] references = config.getChildren("reference");
		if (references.length > 0) {
			reference.setSource(readReference(references[0]));
		} else {
			IConfigurationElement[] sources = config.getChildren("source");
			if (sources.length > 0) {
				reference.setSource(readSource(sources[0]));
			}
		}

		return reference;
	}

	private static BaseDataSource readReference(IConfigurationElement config) {
		BaseDataSource reference = X5Factory.eINSTANCE.createBaseDataSource();
		reference.setId(config.getAttribute("id"));
		return reference;
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
