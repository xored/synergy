package com.xored.sherlock.core;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EObject;

public class BaseProcessDataSource implements ProcessDataSource {

	@Override
	public void addProcessListener(ProcessListener listener) {
		listeners.addIfAbsent(listener);
		if (!listen) {
			listen = true;
			start();
		}
	}

	@Override
	public void removeProcessListener(ProcessListener listener) {
		listeners.remove(listener);
		if (listen && listeners.isEmpty()) {
			finish();
		}
	}

	protected void fireStart(EObject data) {
		for (ProcessListener listener : listeners) {
			listener.handleStart(data);
		}
	}

	protected void fireFinish(EObject data) {
		for (ProcessListener listener : listeners) {
			listener.handleFinish(data);
		}
	}

	protected void start() {
	}

	protected void finish() {
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	private CopyOnWriteArrayList<ProcessListener> listeners = new CopyOnWriteArrayList<ProcessListener>();
	private boolean listen = false;

}
