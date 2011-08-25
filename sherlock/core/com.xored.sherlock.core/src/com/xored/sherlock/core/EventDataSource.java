package com.xored.sherlock.core;

public interface EventDataSource extends DataSource {

	public void addEventListener(EventListener listener);

	public void removeEventListener(EventListener listener);

}
