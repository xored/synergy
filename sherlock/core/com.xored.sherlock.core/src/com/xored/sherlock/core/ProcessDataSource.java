package com.xored.sherlock.core;

public interface ProcessDataSource extends DataSource {

	public void addProcessListener(ProcessListener listener);

	public void removeProcessListener(ProcessListener listener);

}
