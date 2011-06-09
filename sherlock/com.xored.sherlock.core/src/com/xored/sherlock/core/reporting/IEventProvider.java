package com.xored.sherlock.core.reporting;

/**
 * Interface to provide events to Report
 */
public interface IEventProvider {
	/**
	 * Register builder as event listener.
	 */
	void addListener(IReportBuilder builder);

	/**
	 * Remove builder from listeners
	 */
	void removeListener(IReportBuilder builder);

	/**
	 * Store specified information snapshot (static data) into report
	 */
	void storeSnapshot(IReportBuilder builder, String type);
}
