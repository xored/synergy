package com.xored.x5.agent.eclipse;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.xored.sherlock.eclipse.platform.PlatformUtil;
import com.xored.sherlock.status.Status;
import com.xored.x5.common.Log;

public class EclipseLog implements Log {

	@Override
	public void log(Status status) {
		String target = status.getTarget();
		Bundle bundle = null;
		if (target != null && !target.isEmpty()) {
			bundle = Platform.getBundle(target);
		}
		if (bundle == null) {
			bundle = getCoreBundle();
		}
		ILog log = Platform.getLog(bundle);
		log.log(PlatformUtil.convert(status));
	}

	private Bundle getCoreBundle() {
		if (bundle == null) {
			bundle = findCoreBundle();
		}
		return bundle;
	}

	private Bundle findCoreBundle() {
		Bundle bundle = Platform.getBundle(X5Core.PLUGIN_ID);
		if (bundle == null) {
			bundle = Platform.getBundle(Platform.PI_RUNTIME);
		}
		return bundle;
	}

	private volatile Bundle bundle;

}