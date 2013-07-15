package com.xored.af.databinding;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.eclipse.core.databinding.observable.Realm;

public class HeadlessRealm extends Realm {
    public static final HeadlessRealm INSTANCE = new HeadlessRealm();

    private final BlockingQueue<Runnable> queue = new LinkedBlockingDeque<Runnable>();

    private Thread thread;

    private boolean isExecuting = false;

    protected void ensureThreadWorking() {
        synchronized (queue) {
            if (thread == null) {
                thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            isExecuting = false;
                            while (true) {
                                if (queue.isEmpty()) {
                                    isExecuting = false;
                                } else {
                                    isExecuting = true;
                                }
                                final Runnable runnable = queue.take();
                                isExecuting = true;
                                runnable.run();
                            }
                        } catch (final InterruptedException e) {
                            e.printStackTrace(); // TODO:
                        }
                    }
                };
                thread.start();
            }
        }
    }

    protected HeadlessRealm() {
    }

    @Override
    public boolean isCurrent() {
        ensureThreadWorking();
        return Thread.currentThread() == thread;
    }

    @Override
    public void asyncExec(final Runnable runnable) {
        try {
            ensureThreadWorking();
            queue.put(new Runnable() {
                public void run() {
                    safeRun(runnable);
                    synchronized (queue) {
                        queue.notifyAll();
                    }

                }
            });
        } catch (final InterruptedException e) {
            e.printStackTrace(); // TODO:
        }
    }

    /**
     * Waits for all threads in queue to be finished. Should be used only in
     * tests.
     */
    public void joinExecutionThreads() {
        synchronized (queue) {
            while (!queue.isEmpty() || isExecuting) {
                try {
                    queue.wait(100);
                } catch (final InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
