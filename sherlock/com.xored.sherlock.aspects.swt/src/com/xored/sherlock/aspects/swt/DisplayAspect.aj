package com.xored.sherlock.aspects.swt;

import java.lang.reflect.Field;

import org.eclipse.swt.widgets.Display;

import com.xored.sherlock.aspects.asyncs.IAsyncEventListener;
import com.xored.sherlock.aspects.asyncs.AsyncEventManager;

public aspect DisplayAspect {
	public DisplayAspect() {
	}

	Object around(Display display, Runnable async): execution(void Display.syncExec(Runnable)) && target( display ) && args(async) {
		IAsyncEventListener[] listeners = AsyncEventManager.getDefault()
				.getListeners();
		for (IAsyncEventListener l : listeners) {
			l.asyncAdded(async, true);
		}
		// Runnable called
		try {
			return proceed(display, async);
		} finally {
			for (IAsyncEventListener l : listeners) {
				l.asyncDone(async);
			}
		}
	}

	Object around(): execution(void org.eclipse.swt.widgets.RunnableLock.run()) {
		IAsyncEventListener[] listeners = AsyncEventManager.getDefault()
				.getListeners();
		Runnable value = null;
		if (listeners.length > 0) {
			try {
				Object target = thisJoinPoint.getTarget();
				Field runable = target.getClass().getDeclaredField("runnable");
				runable.setAccessible(true);
				value = (Runnable) runable.get(target);
				for (IAsyncEventListener l : listeners) {
					l.asyncRunning(value);
				}
			} catch (Throwable e) {
				SWTAspectActivator.log(e);
			}
		}
		Object result = proceed();
		if (listeners.length > 0) {
			if (value != null) {
				for (IAsyncEventListener l : listeners) {
					l.asyncDone(value);
				}
			}
		}
		return result;
	}

	before(Display display, Runnable async): execution(void Display.asyncExec(Runnable)) && target( display ) && args(async) {
		// Runnable called
		if (async != null) {
			IAsyncEventListener[] listeners = AsyncEventManager.getDefault()
					.getListeners();
			for (IAsyncEventListener l : listeners) {
				l.asyncAdded(async, false);
			}
		}
	}

	// timer Exec
	Object around(int time, Runnable run):execution(void org.eclipse.swt.widgets.Display.timerExec(int, Runnable)) && args(time,run) {
		IAsyncEventListener[] listeners = AsyncEventManager.getDefault()
				.getListeners();
		Runnable newRunnable = run;
		for (IAsyncEventListener l : listeners) {
			l.timerAdded(newRunnable);
			newRunnable = l.processTimerProc(newRunnable);
		}
		return proceed(time, newRunnable);
	}
}
