package com.xored.af;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class LabelRegistry implements IChangeNotifier {
    private class PrefetchRunnable implements Runnable {

        public void run() {
            synchronized (labels) {
                // final long time = System.currentTimeMillis();
                final int batchSize = Math.min(prefetchQueue.size(), maxBatchSize);

                // System.out.println("!prefetching " + batchSize);
                for (int i = 0; i < batchSize; i++) {
                    final EObject o = prefetchQueue.remove(0);

                    calculateLabel(o);
                }
                // final long time2 = System.currentTimeMillis();
                // System.out.println("!done in " + (time2 - time));
            }
        }
    }

    private class PrefetchJob extends EmfTransactionJob {

        public PrefetchJob(final TransactionalEditingDomain domain) {
            super("Labels prefetch", new PrefetchRunnable(), domain);
            setPriority(Job.SHORT);
            setRule(new TransactionRule(domain));
        }

        @Override
        protected IStatus run(final IProgressMonitor monitor) {
            final IStatus status = super.run(monitor);

            if (!prefetchQueue.isEmpty()) {
                schedule(batchInterval);
            }
            return status;
        }
    }

    private final AdapterFactory adapterFactory;
    private final Map<EObject, Label> labels = new WeakHashMap<EObject, Label>(300);
    protected final List<EObject> prefetchQueue = new ArrayList<EObject>(300);

    private final int maxBatchSize = 100;
    private final int batchInterval = 50;

    private final ChangeNotifier changeSupport = new ChangeNotifier();

    private final TransactionalEditingDomain domain;
    private final PrefetchJob prefetchJob;

    public LabelRegistry(final TransactionalEditingDomain domain, final AdapterFactory adapterFactory) {
        if (!(adapterFactory instanceof IChangeNotifier)) {
            throw new IllegalArgumentException("adapterFactory must be an instance of IChangeNotifier: "
                + adapterFactory);
        }

        this.adapterFactory = adapterFactory;
        this.domain = domain;
        this.prefetchJob = new PrefetchJob(domain);

        final Job initializeJob = new EmfTransactionJob("LabelRegistry.initialize()", new Runnable() {

            public void run() {
                initialize();
            }
        }, domain);
        initializeJob.setPriority(Job.INTERACTIVE);
        initializeJob.schedule();
    }

    protected void enqueue(final EObject o) {
        prefetchQueue.add(o);

        if (prefetchJob.getState() == Job.NONE) {
            prefetchJob.schedule(batchInterval);
        }
    }

    protected void dequeue(final EObject o) {
        prefetchQueue.remove(o);
    }

    public Object getImage(final Object object) {
        synchronized (labels) {
            return labels.get(object).image;
        }
    }

    public String getText(final Object object) {
        synchronized (labels) {
            return labels.get(object).text;
        }
    }

    public boolean contains(final Object object) {
        synchronized (labels) {
            return labels.containsKey(object);
        }
    }

    protected void initialize() {
        for (final Resource r : domain.getResourceSet().getResources()) {
            if (r.getURI().isPlatformResource()) {
                for (final EObject o : r.getContents()) {
                    enqueue(o);
                }
            }
        }

        final IChangeNotifier notifier = (IChangeNotifier) adapterFactory;
        notifier.addListener(new INotifyChangedListener() {

            public void notifyChanged(final Notification msg) {
                if (msg instanceof ViewerNotification) {
                    final ViewerNotification viewerMsg = (ViewerNotification) msg;
                    if (viewerMsg.isLabelUpdate() && viewerMsg.getElement() instanceof EObject) {
                        calculateLabel((EObject) viewerMsg.getElement());
                        fireNotifyChanged(msg);
                    }
                }
            }
        });

        prefetchJob.schedule();
    }

    protected void removeLabel(final EObject o) {
        synchronized (labels) {
            labels.remove(o);
        }
        dequeue(o);
    }

    protected void calculateLabel(final EObject o) {
        synchronized (labels) {
            // object is no longer relevant
            if (o.eResource() == null || o.eResource().getResourceSet() == null) {
                labels.remove(o);
                return;
            }

            final IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(o,
                IItemLabelProvider.class);
            labels.put(o, new Label(labelProvider.getText(o), labelProvider.getImage(o)));
        }

    }

    public void fireNotifyChanged(final Notification notification) {
        changeSupport.fireNotifyChanged(notification);
    }

    public void addListener(final INotifyChangedListener notifyChangedListener) {
        changeSupport.addListener(notifyChangedListener);
    }

    public void removeListener(final INotifyChangedListener notifyChangedListener) {
        changeSupport.removeListener(notifyChangedListener);
    }
}
