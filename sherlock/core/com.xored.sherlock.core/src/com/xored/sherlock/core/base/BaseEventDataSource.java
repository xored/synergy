package com.xored.sherlock.core.base;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;

/**
 * Base implementation of the event data source.<br>
 * <br>
 * This implementation allows lazy initialization/finalization when the first
 * listener will be added/the last will be removed
 * 
 * @see #attach()
 * @see #detach()
 * 
 * @author Yuri Strot
 */
public abstract class BaseEventDataSource implements EventDataSource {

	@Override
	public void addEventListener(EventListener listener) {
		if (listeners.add(listener)) {
			attach();
		}
	}

	@Override
	public void removeEventListener(EventListener listener) {
		if (listeners.remove(listener)) {
			detach();
		}
	}

	/**
	 * This method called when the first listener will be added. Should be
	 * overridden by client.
	 */
	protected void attach() {
	}

	/**
	 * This method called when the last listener will be removed. Should be
	 * overridden by client.
	 */
	protected void detach() {
	}

	protected void fire(EObject event) {
		for (EventListener listener : listeners.iterable()) {
			listener.handle(event);
		}
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	private ListenerList<EventListener> listeners = new ListenerList<EventListener>();

}
