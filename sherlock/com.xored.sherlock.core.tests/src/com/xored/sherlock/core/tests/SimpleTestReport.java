package com.xored.sherlock.core.tests;

import junit.framework.TestCase;

import com.xored.sherlock.core.IEventProviders;
import com.xored.sherlock.core.SherlockCore;
import com.xored.sherlock.core.model.sherlock.report.Report;
import com.xored.sherlock.core.reporting.ReportBuilder;
import com.xored.sherlock.core.reporting.SimpleReportGenerator;

public class SimpleTestReport extends TestCase {
	public void testReportCreation001() throws Throwable {
		ReportBuilder reportBuilder = new ReportBuilder();
		reportBuilder.registerProviders(IEventProviders.LOG_EVENT_PROVIDER);
		// ctx 1
		{
			reportBuilder.beginTask("context1");
			// subctx1
			{
				reportBuilder.beginTask("subcontext1");
				SherlockCore.log("msg1");
				reportBuilder.endTask();
			}
			// subctx2
			{
				reportBuilder.beginTask("subcontext2");
				SherlockCore.log("msg2");
				reportBuilder.endTask();
			}
			reportBuilder.endTask();
		}
		// scenario
		reportBuilder.beginTask("scenario");
		SherlockCore.log("msg3");
		reportBuilder.endTask();
		reportBuilder.unregisterProviders();
		Report report = reportBuilder.getReport();
		String content = new SimpleReportGenerator().generateContent(report);
		TestCase.assertEquals(
				"Report:\n"
						+ "  context1 {"
						+ "\n"
						+ "      subcontext1 {"
						+ "\n           < object: message={msg1} plugin={com.xored.sherlock.core} sevirity={4}"
						+ "\n            thread.name=main"
						+ "\n            plugin=org.eclipse.core.runtime"
						+ "\n          >"
						+ "\n      }"
						+ "\n      subcontext2 {"
						+ "\n           < object: message={msg2} plugin={com.xored.sherlock.core} sevirity={4}"
						+ "\n            thread.name=main"
						+ "\n            plugin=org.eclipse.core.runtime"
						+ "\n          >"
						+ "\n      }"
						+ "\n  }"
						+ "\n  scenario {"
						+ "\n       < object: message={msg3} plugin={com.xored.sherlock.core} sevirity={4}"
						+ "\n        thread.name=main"
						+ "\n        plugin=org.eclipse.core.runtime"
						+ "\n      >" + "\n  }" + "\n", content);
	}
}
