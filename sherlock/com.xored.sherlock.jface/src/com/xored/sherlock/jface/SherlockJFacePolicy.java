package com.xored.sherlock.jface;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.util.ILogger;
import org.eclipse.jface.util.Policy;

public enum SherlockJFacePolicy implements ILogger {
	Instance;

	private ILogger defaultLogger = null;;
	private final List<ILogger> listeners = new ArrayList<ILogger>();

	private SherlockJFacePolicy() {
	}

	private void inititialize() {
		if (defaultLogger == null) {
			defaultLogger = Policy.getLog();
			Policy.setLog(this);
		}
	}

	private void dispose() {
		if (defaultLogger != null) {
			Policy.setLog(defaultLogger);
			defaultLogger = null;
		}
	}

	public void addListener(ILogger listener) {
		synchronized (this) {
			listeners.add(listener);
			if (listeners.size() > 0)
				inititialize();
		}
	}

	public void removeListener(ILogger listener) {
		synchronized (this) {
			listeners.remove(listener);
			if (listeners.size() <= 0)
				dispose();
		}
	}

	@Override
	public void log(IStatus status) {
		try {
			if (defaultLogger != null) {
				defaultLogger.log(status);
			}
		} catch (Exception e) {
			// Ignore
		}
		synchronized (this) {
			for (ILogger l : listeners) {
				try {
					l.log(status);
				} catch (Exception e) {
					// Ignore
				}
			}
		}
	}
}
