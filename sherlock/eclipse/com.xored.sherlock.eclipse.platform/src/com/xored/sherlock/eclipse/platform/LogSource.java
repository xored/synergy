package com.xored.sherlock.eclipse.platform;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;

import com.xored.sherlock.core.base.BaseEventDataSource;

public class LogSource extends BaseEventDataSource implements ILogListener {

	@Override
	protected void attach() {
		Platform.addLogListener(this);
	}

	@Override
	protected void detach() {
		Platform.removeLogListener(this);
	}

	@Override
	public void logging(IStatus s, String plugin) {
		fire(PlatformUtil.convert(s));
	}

}
