package com.xored.sherlock.core;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EObject;

/**
 * Base implementation of event data source.<br>
 * <br>
 * 
 * TODO need to make it thread safe
 * 
 * @author Yuri Strot
 */
public abstract class BaseEventDataSource implements EventDataSource {

	@Override
	public void addEventListener(EventListener listener) {
		listeners.addIfAbsent(listener);
		if (!listen) {
			listen = true;
			start();
		}
	}

	@Override
	public void removeEventListener(EventListener listener) {
		listeners.remove(listener);
		if (listen && listeners.isEmpty()) {
			finish();
		}
	}

	protected void fire(EObject event) {
		for (EventListener listener : listeners) {
			listener.handle(event);
		}
	}

	protected void start() {

	}

	protected void finish() {

	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	private CopyOnWriteArrayList<EventListener> listeners = new CopyOnWriteArrayList<EventListener>();
	private boolean listen = false;

}
