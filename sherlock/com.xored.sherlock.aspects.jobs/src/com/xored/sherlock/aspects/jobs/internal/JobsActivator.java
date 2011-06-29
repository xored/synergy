package com.xored.sherlock.aspects.jobs.internal;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class JobsActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.xored.sherlock.aspects.jobs";

	// The shared instance
	private static JobsActivator plugin;

	/**
	 * The constructor
	 */
	public JobsActivator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static JobsActivator getDefault() {
		return plugin;
	}

	public static void log(Throwable t) {
		getDefault().getLog()
				.log(
						new Status(Status.ERROR, PLUGIN_ID,
								"Tesla Recording SWT ERROR", t));
	}

}
