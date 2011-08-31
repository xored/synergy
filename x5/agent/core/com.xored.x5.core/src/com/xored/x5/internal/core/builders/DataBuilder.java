package com.xored.x5.internal.core.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.xored.x5.core.X5DataListener;

public class DataBuilder {

	public DataBuilder(EClass eClass, List<DataLink> links) {
		this.eClass = eClass;
		this.links = links;
	}

	public void addDataListener(X5DataListener listener) {
		listeners.add(listener);
	}

	public void removeDataListener(X5DataListener listener) {
		listeners.remove(listener);
	}

	protected void firePrepare(EObject object) {
		for (X5DataListener listener : listeners) {
			listener.prepare(object);
		}
	}

	protected void firePush(EObject object) {
		for (X5DataListener listener : listeners) {
			listener.push(object);
		}
	}

	protected EObject createInstance() {
		return eClass.getEPackage().getEFactoryInstance().create(eClass);
	}

	protected EClass eClass;
	protected List<DataLink> links = new ArrayList<DataLink>();
	protected CopyOnWriteArrayList<X5DataListener> listeners = new CopyOnWriteArrayList<X5DataListener>();

}