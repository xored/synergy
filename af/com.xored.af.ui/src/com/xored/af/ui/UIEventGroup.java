package com.xored.af.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.progress.UIJob;

import com.xored.af.EventGroup.EventHandler;
import com.xored.af.EventGroup.EventHandler.HandleResult;

/**
 * Helps developer with a common task of grouping events to avoid cluttering GUI
 * thread with a lot of asyncExec's.
 * 
 * Events posted to this group will be handled in batches with at least
 * <code>batchInterval</code> intervals.
 * 
 * @param <E>
 *            Event type
 */
public class UIEventGroup<E> {
    private final String name;
    private volatile int batchInterval = 100;
    private final List<E> events = new ArrayList<E>();
    private final EventHandler<E> handler;

    private final Job handleJob;

    public UIEventGroup(final String name, final EventHandler<E> handler) {
        this.name = name;
        this.handler = handler;

        handleJob = new UIJob("Handle events of " + name) {
            @Override
            public IStatus runInUIThread(final IProgressMonitor monitor) {
                final List<E> eventsCopy = new ArrayList<E>(events);
                events.clear();

                final HandleResult result = UIEventGroup.this.handler.handle(eventsCopy);

                if (result == HandleResult.RETRY) {
                    for (final E event : eventsCopy) {
                        events.add(event);
                    }
                    schedule(batchInterval);
                }

                return Status.OK_STATUS;
            }
        };
        handleJob.setUser(false);
        handleJob.setSystem(true);
        handleJob.setPriority(Job.INTERACTIVE);
    }

    /**
     * 
     * @param interval
     *            Batching interval, in milliseconds
     * @return
     */
    public UIEventGroup<E> setBatchInterval(final int interval) {
        this.batchInterval = interval;
        return this;
    }

    /**
     * Posting event that equals() to the exising event in the queue, will have
     * no effect.
     * 
     * @param event
     */
    public void post(final E event) {
        synchronized (events) {
            if (!checkForDuplicates() || !events.contains(event)) {
                events.add(event);
                handleJob.schedule(batchInterval);
            }
        }
    }

    protected boolean checkForDuplicates() {
        return true;
    }

    @Override
    public String toString() {
        return "EventGroup[ name=" + name + ", events.size()=" + events.size() + "]";
    }
}
