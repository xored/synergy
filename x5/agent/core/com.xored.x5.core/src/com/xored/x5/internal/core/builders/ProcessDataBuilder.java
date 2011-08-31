package com.xored.x5.internal.core.builders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;
import com.xored.sherlock.core.IntervalDataSource;
import com.xored.sherlock.core.data.ProcessData;

public class ProcessDataBuilder extends DataBuilder {

	public ProcessDataBuilder(EClass eClass, List<DataLink> links) {
		super(eClass, links);
	}

	public EObject start(EObject input) {
		data = (ProcessData) createInstance();
		input = EcoreUtil.copy(input);
		data.setInput(input);
		firePrepare(data);
		for (DataLink link : links) {
			DataSource source = link.getSource();
			if (source instanceof EventDataSource) {
				@SuppressWarnings("unchecked")
				List<EObject> events = (List<EObject>) data.eGet(link.getEReference());
				FieldListener listener = new FieldListener(events);
				((EventDataSource) source).addEventListener(listener);
				listeners.put(link, listener);
			} else if (source instanceof IntervalDataSource) {
				((IntervalDataSource) source).start();
			} else {
				throw new IllegalArgumentException(source + " source is not a valid child for process data source");
			}
		}
		return input;
	}

	public EObject finish(EObject output) {
		output = EcoreUtil.copy(output);
		data.setOutput(output);
		for (DataLink link : links) {
			DataSource source = link.getSource();
			if (source instanceof EventDataSource) {
				FieldListener listener = listeners.get(link);
				((EventDataSource) source).removeEventListener(listener);
			} else {
				EObject object = ((IntervalDataSource) source).finish();
				data.eSet(link.getEReference(), object);
			}
		}
		firePush(data);
		return output;
	}

	private class FieldListener implements EventListener {

		public FieldListener(List<EObject> events) {
			this.events = events;
		}

		@Override
		public void handle(EObject event) {
			events.add(event);
		}

		private List<EObject> events;

	}

	private Map<DataLink, FieldListener> listeners = new HashMap<DataLink, FieldListener>();
	private ProcessData data;

}
