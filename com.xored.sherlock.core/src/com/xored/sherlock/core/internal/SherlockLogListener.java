package com.xored.sherlock.core.internal;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;

import com.xored.sherlock.core.IPluginFilter;
import com.xored.sherlock.core.IStatusFilter;
import com.xored.sherlock.core.PluginFilters;
import com.xored.sherlock.core.StatusFilters;

public class SherlockLogListener implements ILogListener {
	private static class ListenerEntry {
		public final ILogListener listener;
		public final IStatusFilter statusFilter;
		public final IPluginFilter pluginFilter;

		public ListenerEntry(ILogListener listener, IStatusFilter statusFilter, IPluginFilter pluginFilter) {
			this.listener = listener;
			this.statusFilter = statusFilter;
			this.pluginFilter = pluginFilter;
		}
	}

	private final ListenerList listeners = new ListenerList();

	public void addLogListener(ILogListener listener, IStatusFilter statusFilter, IPluginFilter pluginFilter) {
		if (statusFilter == null) {
			statusFilter = StatusFilters.all();
		}

		if (pluginFilter == null) {
			pluginFilter = PluginFilters.all();
		}

		listeners.add(new ListenerEntry(listener, statusFilter, pluginFilter));
	}

	public void removeLogListener(ILogListener listener) {
		synchronized (listeners) {
			for (Object obj : listeners.getListeners()) {
				if (((ListenerEntry) obj).listener == listener) {
					listeners.remove(listener);
					break;
				}
			}
		}
	}

	@Override
	public void logging(IStatus status, String plugin) {
		for (Object obj : listeners.getListeners()) {
			final ListenerEntry entry = (ListenerEntry) obj;
			if (entry.statusFilter.matches(status) && entry.pluginFilter.matches(plugin)) {
				entry.listener.logging(status, plugin);
			}
		}
	}
}
