package com.xored.sherlock.ui.reportdetails.figures;

import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.RectangleFigure;

import com.xored.sherlock.core.model.sherlock.report.Event;
import com.xored.sherlock.core.model.sherlock.report.EventSource;
import com.xored.sherlock.core.model.sherlock.report.Node;

public class NodeFigure extends RectangleFigure {

	private Node node;
	private Map<EventSource, List<Event>> sources;

	public void setNode(Node node) {
		this.node = node;
	}

	public Node getNode() {
		return node;
	}

	public void setSources(Map<EventSource, List<Event>> localSourceEvents) {
		this.sources = localSourceEvents;
	}

	public Map<EventSource, List<Event>> getSources() {
		return sources;
	}
}
