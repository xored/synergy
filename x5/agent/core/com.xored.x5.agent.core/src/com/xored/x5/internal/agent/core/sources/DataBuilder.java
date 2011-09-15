package com.xored.x5.internal.agent.core.sources;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.xored.x5.internal.agent.core.util.EUtil;

public class DataBuilder {

	public DataBuilder(EClass eClass, List<DataLink> links) {
		this.eClass = eClass;
		this.links = links;
	}

	public boolean addDataListener(X5DataListener listener) {
		return listeners.add(listener);
	}

	public boolean removeDataListener(X5DataListener listener) {
		return listeners.remove(listener);
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

	protected EObject createAndCopy(EObject data) {
		EObject result = createInstance();
		EUtil.copy(data, result);
		return result;
	}

	protected EObject createInstance() {
		return eClass.getEPackage().getEFactoryInstance().create(eClass);
	}

	protected EClass eClass;
	protected List<DataLink> links = new ArrayList<DataLink>();
	protected CopyOnWriteArrayList<X5DataListener> listeners = new CopyOnWriteArrayList<X5DataListener>();

}