package com.xored.sherlock.core.tests;

import org.eclipse.emf.ecore.EcoreFactory;

import junit.framework.TestCase;

import com.xored.sherlock.core.model.sherlock.report.Snaphot;
import com.xored.sherlock.core.reporting.ReportBuilder;
import com.xored.sherlock.core.reporting.SimpleReportGenerator;

public class SnapshotTests extends TestCase {
	public void testSnaphotCreation() throws Throwable {
		ReportBuilder builder = new ReportBuilder();

		builder.beginTask("scenario");
		Snaphot snaphot = builder.createSnapshot();
		snaphot.setData(EcoreFactory.eINSTANCE.createEObject());
		snaphot.getProperties().put("key", "value");
		builder.endTask();

		String content = new SimpleReportGenerator().generateContent(builder
				.getReport());
		TestCase.assertEquals(
				"Report:\n  scenario {\n       % object:\n        key=value\n      %\n  }\n",
				content);
	}
}
