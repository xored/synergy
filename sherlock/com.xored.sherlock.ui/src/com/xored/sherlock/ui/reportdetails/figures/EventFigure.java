package com.xored.sherlock.ui.reportdetails.figures;

import org.eclipse.draw2d.RectangleFigure;

import com.xored.sherlock.core.model.sherlock.report.Event;

public class EventFigure extends RectangleFigure {

	private Event event;
	private Event endEvent;

	public EventFigure() {
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Event getEvent() {
		return event;
	}

	public void setEndEvent(Event endEvent) {
		this.endEvent = endEvent;
	}

	public Event getEndEvent() {
		return endEvent;
	}
}
