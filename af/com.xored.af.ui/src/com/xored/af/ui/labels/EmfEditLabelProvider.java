package com.xored.af.ui.labels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IViewerNotification;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.xored.af.EmfTransactionJob;
import com.xored.af.EventGroup;
import com.xored.af.EventGroup.EventHandler;
import com.xored.af.GlobalPreviewLabelProvider;
import com.xored.af.Label;
import com.xored.af.PreviewLabelProvider;
import com.xored.af.ui.UIEventGroup;
import com.xored.af.ui.internal.AfUiPlugin;

public class EmfEditLabelProvider extends LabelProvider {
    private static final PreviewLabelProvider GLOBAL_PREVIEW_LABELS = GlobalPreviewLabelProvider
        .getInstance();

    private static final String AF_EXT_ID = "org.eclipse.emf.edit.itemProviderAdapterFactories";
    private static final ComposedAdapterFactory GLOBAL_ADAPTER_FACTORY = new ComposedAdapterFactory() {
        private final INotifyChangedListener afListener = new INotifyChangedListener() {

            public void notifyChanged(final Notification notification) {
                fireNotifyChanged(notification);
            }
        };

        @Override
        public void addAdapterFactory(final AdapterFactory adapterFactory) {
            if (!adapterFactories.contains(adapterFactory)) {
                adapterFactories.add(adapterFactory);
                ((IChangeNotifier) adapterFactory).addListener(afListener);

                if (adapterFactory instanceof ComposeableAdapterFactory) {
                    ((ComposeableAdapterFactory) adapterFactory).setParentAdapterFactory(this);
                }
            }
        }
    };

    static {
        for (final IConfigurationElement conf : Platform.getExtensionRegistry().getConfigurationElementsFor(
            AF_EXT_ID)) {
            try {
                GLOBAL_ADAPTER_FACTORY.addAdapterFactory((AdapterFactory) conf
                    .createExecutableExtension("class"));
            } catch (final CoreException e) {
                AfUiPlugin.getDefault().error(e);
            }
        }
    }

    private final ISchedulingRule rule;
    private final INotifyChangedListener adapterFactoryListener = new INotifyChangedListener() {
        private final List<Object> singleElementList = new ArrayList<Object>(1);

        public void notifyChanged(final Notification msg) {
            if (msg instanceof IViewerNotification) {
                final IViewerNotification viewerMsg = (IViewerNotification) msg;
                final Object viewerElement = viewerMsg.getElement();

                if (viewerMsg.isLabelUpdate() && viewerElement instanceof EObject) {
                    calculateLabel((EObject) viewerElement);

                    if (disposed) {
                        return;
                    }

                    if (Display.getCurrent() != null) {
                        if (singleElementList.isEmpty()) {
                            singleElementList.add(viewerElement);
                        } else {
                            singleElementList.set(0, viewerElement);
                        }
                        updateLabelUis(singleElementList);
                    } else {
                        labelUiUpdates.post(viewerElement);
                    }
                }
            }
        }
    };

    private final ILabelProvider genericLabelProvider;
    private volatile boolean disposed = false;

    private static class LabelUi {
        public Image image;
        public String text;

        public LabelUi(final Image image, final String text) {
            this.image = image;
            this.text = text;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((image == null) ? 0 : image.hashCode());
            result = prime * result + ((text == null) ? 0 : text.hashCode());
            return result;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof LabelUi))
                return false;
            final LabelUi other = (LabelUi) obj;
            if (image == null) {
                if (other.image != null)
                    return false;
            } else if (!image.equals(other.image))
                return false;
            if (text == null) {
                if (other.text != null)
                    return false;
            } else if (!text.equals(other.text))
                return false;
            return true;
        }
    }

    private final Map<Object, LabelUi> labelUiStore = new WeakHashMap<Object, LabelUi>(300);
    private final Map<EObject, Label> labelModelStore = new WeakHashMap<EObject, Label>(300);

    private final EventGroup<Object> labelModelUpdates;

    private final UIEventGroup<Object> labelUiUpdates = new UIEventGroup<Object>("Label ui updates",
        new EventHandler<Object>() {

            public HandleResult handle(final List<Object> events) {
                if (disposed) {
                    return HandleResult.DONE;
                }

                updateLabelUis(events);

                return HandleResult.DONE;
            }
        }).setBatchInterval(20);

    public EmfEditLabelProvider(final TransactionalEditingDomain domain) {
        this(domain, false);
    }

    public EmfEditLabelProvider(final TransactionalEditingDomain domain, final boolean supportDecoration) {
        this.rule = new EmfTransactionJob.TransactionRule(domain);

        final Job initializeJob = new EmfTransactionJob("LabelRegistry.initialize()", new Runnable() {

            public void run() {
                initialize();
            }
        }, domain);
        initializeJob.setPriority(Job.INTERACTIVE);
        initializeJob.schedule();

        labelModelUpdates = new EventGroup<Object>("Label model", new EventHandler<Object>() {

            public HandleResult handle(final List<Object> events) {
                if (disposed) {
                    return HandleResult.DONE;
                }

                synchronized (labelModelStore) {
                    for (final Object object : events) {
                        if (object instanceof EObject) {
                            calculateLabel((EObject) object);
                            labelUiUpdates.post(object);
                        }
                    }
                }
                return HandleResult.DONE;
            }
        }) {

            @Override
            protected Job createHandlerJob() {
                final Job job = new EmfTransactionJob("Update label model", new Runnable() {

                    public void run() {
                        handleEvents();
                    }
                }, domain);
                job.setRule(rule);
                job.setPriority(Job.INTERACTIVE);
                return job;
            }
        };

        if (supportDecoration) {
            genericLabelProvider = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
        } else {
            genericLabelProvider = new WorkbenchLabelProvider();
        }

        genericLabelProvider.addListener(new ILabelProviderListener() {

            public void labelProviderChanged(final LabelProviderChangedEvent event) {
                if (disposed) {
                    return;
                }

                if (event.getElements() == null) {
                    synchronized (labelUiStore) {
                        labelUiStore.clear();
                    }
                    fireLabelProviderChanged(new LabelProviderChangedEvent(EmfEditLabelProvider.this));
                } else {
                    synchronized (labelUiStore) {
                        for (final Object o : event.getElements()) {
                            labelUiStore.remove(o);
                        }
                    }
                    fireLabelProviderChanged(new LabelProviderChangedEvent(EmfEditLabelProvider.this, event
                        .getElements()));
                }
            }
        });

    }

    @Override
    public Image getImage(final Object element) {
        if (!(element instanceof Notifier)) {
            return genericLabelProvider.getImage(element);
        }

        synchronized (labelUiStore) {
            final LabelUi label = labelUiStore.get(element);
            if (label != null) {
                return label.image;
            } else {
                labelModelUpdates.post(element);
                return createStaticLabel(element).image;
            }
        }
    }

    @Override
    public String getText(final Object element) {
        if (!(element instanceof Notifier)) {
            return genericLabelProvider.getText(element);
        }

        synchronized (labelUiStore) {
            final LabelUi label = labelUiStore.get(element);
            if (label != null) {
                return label.text;
            } else {
                labelModelUpdates.post(element);
                return createStaticLabel(element).text;
            }
        }
    }

    private LabelUi createStaticLabel(final Object element) {
        final com.xored.af.Label staticLabel = element instanceof Notifier ? GLOBAL_PREVIEW_LABELS
            .getLabel((Notifier) element) : new com.xored.af.Label(null, null);

        String staticText = staticLabel != null ? staticLabel.text : null;
        if (staticLabel == null || staticLabel.text == null || "".equals(staticLabel.text.trim())) {
            staticText = "<Pending>";
        }

        final Image image = staticLabel != null && staticLabel.image != null ? ExtendedImageRegistry
            .getInstance().getImage(staticLabel.image) : null;

        final LabelUi label = new LabelUi(image, staticText);
        labelUiStore.put(element, label);
        return label;
    }

    @Override
    public void dispose() {
        disposed = true;
        GLOBAL_ADAPTER_FACTORY.removeListener(adapterFactoryListener);
        genericLabelProvider.dispose();
        super.dispose();
    }

    private void updateLabelUis(final List<Object> elements) {
        final List<Object> updated = new ArrayList<Object>(elements.size());

        for (final Object element : elements) {
            final Label labelModel = labelModelStore.get(element);
            final LabelUi label = new LabelUi(labelModel != null ? getImageFromDescriptor(labelModel.image)
                : null, labelModel != null && labelModel.text != null ? labelModel.text : "");
            synchronized (labelUiStore) {
                final LabelUi prevLabel = labelUiStore.put(element, label);
                if (!label.equals(prevLabel)) {
                    updated.add(element);
                }
            }
        }

        if (!updated.isEmpty()) {
            fireLabelProviderChanged(new LabelProviderChangedEvent(EmfEditLabelProvider.this,
                updated.toArray()));
        }
    }

    protected void initialize() {
        // for (final Resource r : domain.getResourceSet().getResources()) {
        // if (r.getURI().isPlatformResource()) {
        // for (final EObject o : r.getContents()) {
        // enqueue(o);
        // }
        // }
        // }

        final IChangeNotifier notifier = GLOBAL_ADAPTER_FACTORY;
        notifier.addListener(adapterFactoryListener);

        // prefetchJob.schedule();
    }

    private static Label EMPTY = new Label("", null);

    public void calculateLabel(final EObject o) {
        // // object is no longer relevant
        // if (o.eResource() == null || o.eResource().getResourceSet() == null)
        // {
        // labelModelStore.remove(o);
        // return;
        // }

        final IItemLabelProvider labelProvider = (IItemLabelProvider) GLOBAL_ADAPTER_FACTORY.adapt(o,
            IItemLabelProvider.class);
        labelModelStore.put(o,
            labelProvider != null ? new Label(labelProvider.getText(o), labelProvider.getImage(o)) : EMPTY);
    }

    private Image getImageFromDescriptor(final Object imageDescriptor) {
        return ExtendedImageRegistry.getInstance().getImage(imageDescriptor);
    }

}
