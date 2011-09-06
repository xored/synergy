package com.xored.x5.internal.agent.sources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;
import com.xored.sherlock.core.IntervalDataSource;
import com.xored.x5.internal.agent.util.EUtil;

public class ProcessDataBuilder extends DataBuilder {

	public ProcessDataBuilder(EClass eClass, List<DataLink> links) {
		super(eClass, links);
	}

	public EObject start(EObject data) {
		EObject result = createAndCopy(data);
		map.put(data, result);
		firePrepare(result);
		for (DataLink link : links) {
			DataSourceHandler handler = getHandler(result, link.getSource(), link.getEReference());
			handler.start();
			handlers.put(link, handler);
		}
		return result;
	}

	public EObject finish(EObject data) {
		EObject result = map.remove(data);
		if (result == null) {
			// No start for specified data
			return null;
		}
		// update changed features
		for (EStructuralFeature feature : data.eClass().getEAllStructuralFeatures()) {
			if (!EUtil.haveEqualFeature(data, result, feature)) {
				EUtil.copyFeature(data, result, feature);
			}
		}
		// collect finished handlers
		for (DataLink link : links) {
			handlers.get(link).finish();
		}
		firePush(data);
		return result;
	}

	private DataSourceHandler getHandler(EObject object, DataSource source, EReference reference) {
		if (source instanceof EventDataSource) {
			return new EventHandler(object, reference, (EventDataSource) source);
		} else if (source instanceof IntervalDataSource) {
			return createIntervalHandler(object, reference, (IntervalDataSource<?>) source);
		} else {
			throw new IllegalArgumentException(source + " source is not a valid child for process data source");
		}
	}

	private <T extends EObject> IntervalHandler<T> createIntervalHandler(EObject object, EReference reference,
			IntervalDataSource<T> source) {
		return new IntervalHandler<T>(object, reference, source);
	}

	private abstract class DataSourceHandler {

		public DataSourceHandler(EObject object, EReference reference) {
			this.object = object;
			this.reference = reference;
		}

		abstract void start();

		abstract void finish();

		EObject object;
		EReference reference;

	}

	private class EventHandler extends DataSourceHandler implements EventListener {

		public EventHandler(EObject object, EReference reference, EventDataSource source) {
			super(object, reference);
			this.source = source;
		}

		@SuppressWarnings("unchecked")
		@Override
		void start() {
			events = (List<EObject>) object.eGet(reference);
			source.addEventListener(this);
		}

		@Override
		void finish() {
			source.removeEventListener(this);
		}

		@Override
		public void handle(EObject event) {
			events.add(event);
		}

		private List<EObject> events;
		private EventDataSource source;

	}

	private class IntervalHandler<T extends EObject> extends DataSourceHandler {

		public IntervalHandler(EObject object, EReference reference, IntervalDataSource<T> source) {
			super(object, reference);
			this.source = source;
		}

		void start() {
			data = source.start();
		}

		void finish() {
			source.finish(data);
			object.eSet(reference, data);
		}

		IntervalDataSource<T> source;
		T data;

	}

	private Map<EObject, EObject> map = new HashMap<EObject, EObject>();
	private Map<DataLink, DataSourceHandler> handlers = new HashMap<DataLink, DataSourceHandler>();

}
