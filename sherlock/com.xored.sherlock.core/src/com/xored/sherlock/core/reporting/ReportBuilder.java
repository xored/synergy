package com.xored.sherlock.core.reporting;

import org.eclipse.emf.common.util.EList;

import com.xored.sherlock.core.model.sherlock.report.Category;
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
	public Category registerCategory(String id, String name) {
		Category category = ReportFactory.eINSTANCE.createCategory();
		category.setId(id);
		category.setName(name);
		report.getCategories().add(category);
		return category;
	}

	@Override
	public EventSource registerEventSource(String name) {
		EventSource source = ReportFactory.eINSTANCE.createEventSource();
		source.setName(name);
		report.getSources().add(source);
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
		synchronized (this.currentNode) {
			this.currentNode.getChildren().add(nde);
			this.currentNode = nde;
		}
		return nde;
	}

	@Override
	public Node getCurrentNode() {
		synchronized (currentNode) {
			return currentNode;
		}
	}

	@Override
	public Report getReport() {
		report.getRoot().setEndTime(getTimeConverter().getTime());
		return report;
	}

	@Override
	public Category getCategory(String logCategory) {
		EList<Category> categories = report.getCategories();
		for (Category category : categories) {
			if (category.getId().equals(logCategory)) {
				return category;
			}
		}
		return null;
	}

	/**
	 * Will go one level up.
	 */
	@Override
	public void endTask() {
		synchronized (currentNode) {
			currentNode.setEndTime(getTimeConverter().getTime());
			if (!report.getRoot().equals(currentNode)) {
				currentNode = currentNode.getParent();
			}
		}
	}

	// / Customization
	protected TimeConverter getTimeConverter() {
		return TimeConverter.DEFAULT;
	}

	@Override
	public Event createEvent() {
		Event event = ReportFactory.eINSTANCE.createEvent();
		event.setTime(getTimeConverter().getTime());

		synchronized (currentNode) {
			currentNode.getEvents().add(event);
		}

		return event;
	}

	@Override
	public Snaphot createSnapshot() {
		Snaphot snapshot = ReportFactory.eINSTANCE.createSnaphot();
		snapshot.setTime(getTimeConverter().getTime());
		synchronized (currentNode) {
			currentNode.getSnapshots().add(snapshot);
		}
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
}
