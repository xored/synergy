package com.xored.x5.agent.core;

import com.xored.sherlock.status.Status;

public class DefaultLog implements Log {

	public static final DefaultLog INSTANCE = new DefaultLog();

	private DefaultLog() {
	}

	@Override
	public void log(Status status) {

	}

}
