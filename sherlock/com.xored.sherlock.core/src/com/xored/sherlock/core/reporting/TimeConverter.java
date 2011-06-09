package com.xored.sherlock.core.reporting;

public class TimeConverter {
	public static final TimeConverter DEFAULT = new TimeConverter();

	public long getTime() {
		return System.currentTimeMillis(); 
	}
}
