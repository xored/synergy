package com.xored.x5.internal.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceManager;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;
import com.xored.sherlock.core.IntervalDataSource;
import com.xored.sherlock.core.ProcessDataSource;
import com.xored.sherlock.core.ProcessListener;
import com.xored.x5.core.CompositeDataSource;
import com.xored.x5.core.DataSourceReference;

public class X5ProcessDataSource extends X5DataSource implements ProcessDataSource, ProcessListener {

	public X5ProcessDataSource(DataSourceManager manager, CompositeDataSource descriptor, ProcessDataSource base) {
		super(manager, descriptor);
		this.base = base;
	}

	@Override
	public void handleStart(EObject data) {
		for (DataSourceReference reference : descriptor.getReferences()) {
			DataSource source = getSource(reference.getSource());
			sources.put(reference, source);
			if (source instanceof EventDataSource) {
				FieldListener listener = new FieldListener();
				((EventDataSource) source).addEventListener(listener);
				sourceListeners.put(reference, listener);
			} else if (source instanceof IntervalDataSource) {
				((IntervalDataSource) source).start();
			} else {
				throw new IllegalArgumentException(source + " source is not a valid child for process data source");
			}
		}
		fireStart(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleFinish(EObject data) {
		EObject result = createData(data);
		EClass eClass = result.eClass();
		for (DataSourceReference reference : descriptor.getReferences()) {
			DataSource source = sources.get(reference);
			EReference ref = (EReference) eClass.getEStructuralFeature(reference.getName());
			if (source instanceof EventDataSource) {
				FieldListener listener = sourceListeners.get(reference);
				((EventDataSource) source).removeEventListener(listener);

				ref.setUpperBound(-1);

				List<EObject> events = listener.getEvents();
				if (events.size() > 0) {
					ref.setEType(events.get(0).eClass());
					((List<EObject>) result.eGet(ref)).addAll(events);
				} else {
					ref.setEType(EcorePackage.eINSTANCE.getEObject());
				}
			} else {
				EObject object = ((IntervalDataSource) source).finish();
				ref.setEType(object.eClass());
				result.eSet(ref, object);
			}
		}
		fireFinish(result);
	}

	@Override
	public void addProcessListener(ProcessListener listener) {
		listeners.addIfAbsent(listener);
		if (!listen) {
			listen = true;
			base.addProcessListener(this);
		}
	}

	@Override
	public void removeProcessListener(ProcessListener listener) {
		listeners.remove(listener);
		if (listen && listeners.isEmpty()) {
			base.removeProcessListener(this);
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

	private ProcessDataSource base;
	private Map<DataSourceReference, DataSource> sources = new HashMap<DataSourceReference, DataSource>();
	private Map<DataSourceReference, FieldListener> sourceListeners = new HashMap<DataSourceReference, FieldListener>();

	private CopyOnWriteArrayList<ProcessListener> listeners = new CopyOnWriteArrayList<ProcessListener>();
	private boolean listen = false;

	private class FieldListener implements EventListener {

		@Override
		public void handle(EObject event) {
			events.add(event);
		}

		public List<EObject> getEvents() {
			return events;
		}

		private List<EObject> events = new ArrayList<EObject>();

	}

}
