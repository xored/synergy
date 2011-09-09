package com.xored.sherlock.thread.sources;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EntityDataSource;
import com.xored.sherlock.thread.ThreadFactory;
import com.xored.sherlock.thread.ThreadState;

public class ThreadSource implements EntityDataSource {

	@Override
	public EObject getData() {
		Thread jt = Thread.currentThread();
		com.xored.sherlock.thread.Thread thread = ThreadFactory.eINSTANCE.createThread();
		thread.setName(jt.getName());
		thread.setId(jt.getId());
		thread.setState(getState(jt));
		return thread;
	}

	private ThreadState getState(java.lang.Thread jt) {
		switch (jt.getState()) {
		case NEW:
			return ThreadState.NEW;
		case BLOCKED:
			return ThreadState.BLOCKED;
		case TERMINATED:
			return ThreadState.TERMINATED;
		case RUNNABLE:
			return ThreadState.RUNNABLE;
		case TIMED_WAITING:
			return ThreadState.TIMED_WAITING;
		case WAITING:
			return ThreadState.WAITING;
		}
		throw new IllegalArgumentException("Unknown thread state: " + jt.getState());
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

}
