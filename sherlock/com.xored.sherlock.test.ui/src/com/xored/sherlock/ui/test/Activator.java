package com.xored.sherlock.ui.test;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.xored.sherlock.core.SherlockCore;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	public static final String PLUGIN_ID = "com.xored.sherlock.test.ui"; //$NON-NLS-1$

	private static Activator plugin;

	public Activator() {
	}

	private final ConsoleLogListener logger = new ConsoleLogListener();

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		SherlockCore.addLogListener(logger, null, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		SherlockCore.removeLogListener(logger);

		plugin = null;
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
