package com.xored.q7.profiling.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class SherlockJobsCore extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.xored.sherlock.jobs"; //$NON-NLS-1$

	public static final String JOBS = PLUGIN_ID + ".info";

	// The shared instance
	private static SherlockJobsCore plugin;

	/**
	 * The constructor
	 */
	public SherlockJobsCore() {
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
	public static SherlockJobsCore getDefault() {
		return plugin;
	}

}
