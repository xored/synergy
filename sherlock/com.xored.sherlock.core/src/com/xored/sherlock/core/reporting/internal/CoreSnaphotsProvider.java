package com.xored.sherlock.core.reporting.internal;

import com.xored.sherlock.core.info.Info;
import com.xored.sherlock.core.model.sherlock.report.Snaphot;
import com.xored.sherlock.core.reporting.AbstractEventProvider;
import com.xored.sherlock.core.reporting.IReportBuilder;

public class CoreSnaphotsProvider extends AbstractEventProvider {

	public CoreSnaphotsProvider() {
	}

	@Override
	public void storeSnapshot(IReportBuilder builder, String type) {
		Snaphot snaphot = builder.createSnapshot();
		snaphot.setData(Info.getEclipse());
		//
		snaphot = builder.createSnapshot();
		snaphot.setData(Info.getJava());
		//
		snaphot = builder.createSnapshot();
		snaphot.setData(Info.getSystem());
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
	}

}
