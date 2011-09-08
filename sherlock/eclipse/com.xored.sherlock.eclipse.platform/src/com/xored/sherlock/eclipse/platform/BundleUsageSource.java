package com.xored.sherlock.eclipse.platform;

import java.util.Dictionary;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Constants;

import com.xored.sherlock.core.base.BaseEventDataSource;
import com.xored.sherlock.internal.eclipse.platform.Activator;
import com.xored.sherlock.internal.eclipse.platform.BundleUtil;

public class BundleUsageSource extends BaseEventDataSource implements BundleListener {

	@Override
	protected void attach() {
		Activator.getContext().addBundleListener(this);
	}

	@Override
	protected void detach() {
		Activator.getContext().removeBundleListener(this);
	}

	@Override
	public void bundleChanged(BundleEvent event) {
		Bundle bundle = event.getBundle();
		final Dictionary<String, String> headers = bundle.getHeaders();
		final Plugin plugin = PlatformFactory.eINSTANCE.createPlugin();
		plugin.setId(bundle.getSymbolicName());
		plugin.setVersion(headers.get(Constants.BUNDLE_VERSION));
		plugin.setState(BundleUtil.getState(bundle));
		fire(plugin);
	}

}
