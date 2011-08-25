package com.xored.x5.sample.monitor;

import org.eclipse.ui.IStartup;

public class Startup implements IStartup {

	@Override
	public void earlyStartup() {
		new X5Locator().start();
	}

}
