package com.xored.sherlock.core.reporting;

import com.xored.sherlock.core.model.sherlock.report.Category;
import com.xored.sherlock.core.model.sherlock.report.Event;
import com.xored.sherlock.core.model.sherlock.report.EventSource;
import com.xored.sherlock.core.model.sherlock.report.Node;
import com.xored.sherlock.core.model.sherlock.report.Report;
import com.xored.sherlock.core.model.sherlock.report.Snaphot;

public interface IReportBuilder {

	/**
	 * Register new category
	 */
	public Category registerCategory(String id, String name);

	/**
	 * Return category identified by ID.
	 */
	public Category getCategory(String logCategory);

	/**
	 * Register new event source
	 */
	public EventSource registerEventSource(String name);

	/**
	 * Create new event in current structure model
	 */
	public Event createEvent();

	/**
	 * Return current report. Direct operations are not thread safe.
	 */
	public Report getReport();

	/**
	 * Add subnode to current one and make it active.
	 */
	public Node beginTask(String name);

	/**
	 * Return current node. Direct operations are not thread safe.
	 */
	public Node getCurrentNode();

	/**
	 * End current task and go level up
	 */
	public void endTask();

	/**
	 * Create snaphot instance and add it to current node.
	 * 
	 * @return
	 */
	public Snaphot createSnapshot();

	/**
	 * Store snapshot using following event provider. 'id' used for prefix
	 * match.
	 * 
	 * So if we have providers: 'a.b.c', 'a.b', 'a.d'
	 * 
	 * and pass id as 'a.b' then 'a.b.c' and 'a.b' will be selected.
	 * 
	 * 
	 */
	public void takeSnapshot(String type, String... id);

}