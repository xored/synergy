package com.xored.x5.internal.core;

import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.xored.sherlock.core.DataSourceManager;
import com.xored.sherlock.core.EntityDataSource;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;
import com.xored.x5.core.CompositeDataSource;
import com.xored.x5.core.DataSourceReference;

public class X5EventDataSource extends X5DataSource implements EventDataSource, EventListener {

	public X5EventDataSource(DataSourceManager manager, CompositeDataSource descriptor, EventDataSource base) {
		super(manager, descriptor);
		this.base = base;
	}

	@Override
	public void addEventListener(EventListener listener) {
		listeners.addIfAbsent(listener);
		if (!listen) {
			listen = true;
			base.addEventListener(this);
		}
	}

	@Override
	public void removeEventListener(EventListener listener) {
		listeners.remove(listener);
		if (listen && listeners.isEmpty()) {
			base.removeEventListener(this);
		}
	}

	protected void fire(EObject event) {
		for (EventListener listener : listeners) {
			listener.handle(event);
		}
	}

	@Override
	public void handle(EObject event) {
		EObject result = createData(event);
		EClass eClass = result.eClass();
		for (DataSourceReference reference : descriptor.getReferences()) {
			EntityDataSource source = (EntityDataSource) getSource(reference.getSource());
			EObject object = source.getData();
			EReference ref = (EReference) eClass.getEStructuralFeature(reference.getName());
			ref.setEType(object.eClass());
			result.eSet(ref, object);
		}
		fire(result);
	}

	private EventDataSource base;
	private CopyOnWriteArrayList<EventListener> listeners = new CopyOnWriteArrayList<EventListener>();
	private boolean listen = false;

}
