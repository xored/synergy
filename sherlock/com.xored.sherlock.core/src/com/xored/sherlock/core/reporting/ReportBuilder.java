package com.xored.sherlock.core.reporting;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.sherlock.core.model.sherlock.report.Event;
import com.xored.sherlock.core.model.sherlock.report.EventSource;
import com.xored.sherlock.core.model.sherlock.report.Node;
import com.xored.sherlock.core.model.sherlock.report.Report;
import com.xored.sherlock.core.model.sherlock.report.ReportFactory;
import com.xored.sherlock.core.model.sherlock.report.Snaphot;

/**
 * Build a complex report.
 */
public class ReportBuilder implements IReportBuilder {
	private Report report;
	private Node currentNode;

	public ReportBuilder() {
		report = ReportFactory.eINSTANCE.createReport();
		currentNode = ReportFactory.eINSTANCE.createNode();
		report.setRoot(currentNode);
		currentNode.setName("root");
		currentNode.setStartTime(getTimeConverter().getTime());
	}

	@Override
	public EventSource registerEventSource(String name) {
		EventSource source = ReportFactory.eINSTANCE.createEventSource();
		source.setName(name);
		synchronized (report) {
			report.getSources().add(source);
		}
		return source;
	}

	/**
	 * Will add new node to current one and go one level down.
	 */
	@Override
	public Node beginTask(String name) {
		Node nde = ReportFactory.eINSTANCE.createNode();
		nde.setName(name);
		nde.setStartTime(getTimeConverter().getTime());
		synchronized (report) {
			currentNode.getChildren().add(nde);
			currentNode = nde;
		}
		doSave();
		return nde;
	}

	@Override
	public Node getCurrentNode() {
		synchronized (report) {
			return currentNode;
		}
	}

	@Override
	public Report getReport() {
		synchronized (report) {
			report.getRoot().setEndTime(getTimeConverter().getTime());
		}
		return report;
	}

	public Report getReportCopy() {
		synchronized (report) {
			Report reportCopy = EcoreUtil.copy(report);
			reportCopy.getRoot().setEndTime(getTimeConverter().getTime());

			return reportCopy;
		}
	}

	/**
	 * Will go one level up.
	 */
	@Override
	public void endTask() {
		synchronized (report) {
			currentNode.setEndTime(getTimeConverter().getTime());
			if (!report.getRoot().equals(currentNode)) {
				currentNode = currentNode.getParent();
			}
		}
		doSave();
	}

	// / Customization
	protected TimeConverter getTimeConverter() {
		return TimeConverter.DEFAULT;
	}

	@Override
	public Event createEvent() {
		Event event = ReportFactory.eINSTANCE.createEvent();
		event.setTime(getTimeConverter().getTime());

		synchronized (report) {
			currentNode.getEvents().add(event);
		}
		doSave();
		return event;
	}

	public void doSave() {
	}

	@Override
	public Snaphot createSnapshot() {
		Snaphot snapshot = ReportFactory.eINSTANCE.createSnaphot();
		snapshot.setTime(getTimeConverter().getTime());
		synchronized (report) {
			currentNode.getSnapshots().add(snapshot);
		}
		doSave();
		return snapshot;
	}

	@Override
	public void takeSnapshot(String type, String... id) {
		if (id.length == 0) {
			EventProviderManager.getInstance().takeSnapshot(this, null, type);
		} else {
			for (String lid : id) {
				EventProviderManager.getInstance()
						.takeSnapshot(this, lid, type);
			}
		}
		doSave();
	}

	public void registerProviders(String... id) {
		if (id.length == 0) {
			EventProviderManager.getInstance().register(this, null);
		} else {
			for (String lid : id) {
				EventProviderManager.getInstance().register(this, lid);
			}
		}
	}

	public void unregisterProviders(String... id) {
		if (id.length == 0) {
			EventProviderManager.getInstance().unregister(this, null);
		} else {
			for (String lid : id) {
				EventProviderManager.getInstance().unregister(this, lid);
			}
		}
	}

	public void setReport(Report eObject, Node node) {
		report = eObject;
		currentNode = node;
	}

	/**
	 * Search for event source with equals eobject specified in property
	 */
	public EventSource findSource(String attr, EObject info) {
		synchronized (report) {
			EList<EventSource> sources = report.getSources();
			for (EventSource eventSource : sources) {
				EObject object = eventSource.getProperties().get(attr);
				if (object != null && EcoreUtil.equals(object, info)) {
					return eventSource;
				}
			}
		}
		return null;
	}
}
