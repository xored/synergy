package com.xored.af;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

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
public class EventGroup<E> {
    public interface EventHandler<E> {
        public enum HandleResult {
            DONE, RETRY
        }

        public HandleResult handle(final List<E> events);
    }

    private final String name;
    private volatile int batchInterval = 100;
    private final List<E> events = new ArrayList<E>();
    private final EventHandler<E> handler;

    private final Job handleJob;

    public EventGroup(final String name, final EventHandler<E> handler) {
        this.name = name;
        this.handler = handler;

        handleJob = createHandlerJob();
        handleJob.setUser(false);
        handleJob.setSystem(true);
    }

    protected Job createHandlerJob() {
        return new Job("Handle events of " + name) {
            @Override
            public IStatus run(final IProgressMonitor monitor) {
                handleEvents();
                return Status.OK_STATUS;
            }
        };
    }

    protected void handleEvents() {
        final List<E> eventsCopy;
        synchronized (events) {
            eventsCopy = new ArrayList<E>(events);
            events.clear();
        }

        final EventHandler.HandleResult result = EventGroup.this.handler.handle(eventsCopy);

        if (result == EventHandler.HandleResult.RETRY) {
            synchronized (events) {
                for (final E event : eventsCopy) {
                    events.add(event);
                }
            }
            handleJob.schedule(batchInterval);
        }
    }

    /**
     * 
     * @param interval
     *            Batching interval, in milliseconds
     * @return
     */
    public EventGroup<E> setBatchInterval(final int interval) {
        this.batchInterval = interval;
        return this;
    }

    /**
     * Posting event that equals() to the existing event in the queue, will have
     * no effect.
     * 
     * @param event
     */
    public void post(final E event) {
        synchronized (events) {
            if (!events.contains(event)) {
                events.add(event);
                handleJob.schedule(batchInterval);
            }
        }
    }

    @Override
    public String toString() {
        return "EventGroup[ name=" + name + ", events.size()=" + events.size() + "]";
    }

    public void remove(final E event) {
        synchronized (events) {
            events.remove(event);
        }
    }
}
