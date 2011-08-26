package com.xored.sherlock.core.base;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.ProcessDataSource;
import com.xored.sherlock.core.ProcessListener;

/**
 * Base implementation of the process data source.<br>
 * <br>
 * This implementation allows lazy initialization/finalization when the first
 * listener will be added/the last will be removed
 * 
 * @see #attach()
 * @see #detach()
 * 
 * @author Yuri Strot
 */
public class BaseProcessDataSource implements ProcessDataSource {

	@Override
	public void addProcessListener(ProcessListener listener) {
		if (listeners.add(listener)) {
			attach();
		}
	}

	@Override
	public void removeProcessListener(ProcessListener listener) {
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

	protected void fireStart(EObject data) {
		for (ProcessListener listener : listeners.iterable()) {
			listener.handleStart(data);
		}
	}

	protected void fireFinish(EObject data) {
		for (ProcessListener listener : listeners.iterable()) {
			listener.handleFinish(data);
		}
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	private ListenerList<ProcessListener> listeners = new ListenerList<ProcessListener>();

}
