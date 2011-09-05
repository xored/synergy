package com.xored.sherlock.sample.sources.ui;

import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EventListener;
import com.xored.sherlock.core.ProcessListener;

public class SampleRegistry {

	public static SampleRegistry getInstance() {
		return instance;
	}

	public void addEventListener(EventListener listener) {
		eventListeners.addIfAbsent(listener);
	}

	public void removeEventListener(EventListener listener) {
		eventListeners.remove(listener);
	}

	public void addEventListener(ProcessListener listener) {
		processListeners.addIfAbsent(listener);
	}

	public void removeEventListener(ProcessListener listener) {
		processListeners.remove(listener);
	}

	void fireEvent(EObject event) {
		for (EventListener listener : eventListeners) {
			listener.handle(event);
		}
	}

	void fireProcessStart(EObject data) {
		processData = data;
		for (ProcessListener listener : processListeners) {
			listener.handleStart(data);
		}
	}

	void fireProcessEnd() {
		for (ProcessListener listener : processListeners) {
			listener.handleFinish(processData);
		}
	}

	private static SampleRegistry instance = new SampleRegistry();

	private CopyOnWriteArrayList<EventListener> eventListeners = new CopyOnWriteArrayList<EventListener>();

	private CopyOnWriteArrayList<ProcessListener> processListeners = new CopyOnWriteArrayList<ProcessListener>();

	private EObject processData;

	private SampleRegistry() {
	}

}
