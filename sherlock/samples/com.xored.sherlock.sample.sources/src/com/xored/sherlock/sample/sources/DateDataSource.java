package com.xored.sherlock.sample.sources;

import java.util.Calendar;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EntityDataSource;

public class DateDataSource implements EntityDataSource {

	@Override
	public EObject getData() {
		Date date = SourcesFactory.eINSTANCE.createDate();
		date.setTime(Calendar.getInstance().getTime().toString());
		return date;
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

}
