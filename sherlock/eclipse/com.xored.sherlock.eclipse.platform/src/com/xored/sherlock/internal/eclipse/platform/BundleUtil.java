package com.xored.sherlock.internal.eclipse.platform;

import org.osgi.framework.Bundle;

import com.xored.sherlock.eclipse.platform.PluginState;

public class BundleUtil {

	public static PluginState getState(Bundle bundle) {
		switch (bundle.getState()) {
		case Bundle.INSTALLED:
			return PluginState.INSTALLED;
		case Bundle.UNINSTALLED:
			return PluginState.UNINSTALLED;
		case Bundle.RESOLVED:
			return PluginState.RESOLVED;
		case Bundle.STARTING:
			return PluginState.STARTING;
		case Bundle.STOPPING:
			return PluginState.STOPPING;
		default:
			return PluginState.ACTIVE;
		}
	}

}
