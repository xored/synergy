package com.xored.sherlock.core;

public class SherlockTimerRunnable implements Runnable {
	private Runnable runnable;

	public SherlockTimerRunnable(Runnable run) {
		this.runnable = run;
	}

	public void run() {
		preExecute();
		RuntimeException ee = null;
		try {
			runnable.run();
		} catch (RuntimeException e) {
			ee = e;
		}
		postExecute();
		if (ee != null) {
			throw ee;
		}
	}

	protected void preExecute() {
	}

	protected void postExecute() {

	}

	public Runnable getRunnable() {
		return runnable;
	}
}