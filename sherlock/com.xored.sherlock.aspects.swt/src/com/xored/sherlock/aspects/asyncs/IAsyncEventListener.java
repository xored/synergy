package com.xored.sherlock.aspects.asyncs;

public interface IAsyncEventListener {
	// Async methods
	void asyncAdded(Runnable async, boolean sync);

	void timerAdded(Runnable async);
	
	void asyncRunning(Runnable async);

	void asyncDone(Runnable async);

}
