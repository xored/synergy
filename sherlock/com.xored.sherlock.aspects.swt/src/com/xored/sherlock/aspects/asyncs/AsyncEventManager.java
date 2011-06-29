package com.xored.sherlock.aspects.asyncs;

import java.util.ArrayList;
import java.util.List;

public class AsyncEventManager {
	private static AsyncEventManager INSTANCE = null;
	private List<IAsyncEventListener> listeners = new ArrayList<IAsyncEventListener>();

	public AsyncEventManager() {
	}

	public static AsyncEventManager getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new AsyncEventManager();
		}
		return INSTANCE;
	}

	public void addListener(IAsyncEventListener listener) {
		synchronized (listeners) {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	public void removeListener(IAsyncEventListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	public IAsyncEventListener[] getListeners() {
		synchronized (listeners) {
			return new ArrayList<IAsyncEventListener>(listeners)
					.toArray(new IAsyncEventListener[listeners.size()]);
		}
	}
}
