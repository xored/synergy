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
	}

	@Override
	public Category registerCategory(String id, String name) {
		Category category = ReportFactory.eINSTANCE.createCategory();
		report.getCategories().add(category);
		category.setId(id);
		category.setName(name);
		return category;
	}

	@Override
	public EventSource registerEventSource(String name) {
		EventSource source = ReportFactory.eINSTANCE.createEventSource();
		report.getSources().add(source);
		source.setName(name);
		return source;
	}

	/**
	 * Will add new node to current one and go one level down.
	 */
	@Override
	public Node beginTask(String name) {
		Node nde = ReportFactory.eINSTANCE.createNode();
		nde.setName(name);
		nde.setReport(report);
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
	public void storeSnapshot(String id, String type) {
		EventProviderManager.getInstance().storeSnapshot(this, id, type);
	}
}
