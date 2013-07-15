package com.xored.af.ui.forms.parts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.progress.UIJob;

import com.xored.af.ui.internal.AfUiPlugin;

public class ControlDecorationUpdater {

    public static class Update {
        public final Image image;
        public final String text;
        public final Color controlBg;

        public Update(final Image image, final String text, final Color background) {
            this.image = image;
            this.text = text;
            this.controlBg = background;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((controlBg == null) ? 0 : controlBg.hashCode());
            result = prime * result + ((image == null) ? 0 : image.hashCode());
            result = prime * result + ((text == null) ? 0 : text.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Update)) {
                return false;
            }
            final Update other = (Update) obj;
            if (controlBg == null) {
                if (other.controlBg != null) {
                    return false;
                }
            } else if (!controlBg.equals(other.controlBg)) {
                return false;
            }
            if (image == null) {
                if (other.image != null) {
                    return false;
                }
            } else if (!image.equals(other.image)) {
                return false;
            }
            if (text == null) {
                if (other.text != null) {
                    return false;
                }
            } else if (!text.equals(other.text)) {
                return false;
            }
            return true;
        }
    }

    private static class UpdateDecorationJob extends UIJob {
        private static final UpdateDecorationJob JOB_INSTANCE = new UpdateDecorationJob();

        private UpdateDecorationJob() {
            super("Update control decorations");
        }

        @Override
        public IStatus runInUIThread(final IProgressMonitor monitor) {
            UPDATER_INSTANCE.runUpdates();
            return Status.OK_STATUS;
        }
    }

    private static final ControlDecorationUpdater UPDATER_INSTANCE = new ControlDecorationUpdater();

    private static final String PROP_UPDATE_DELAY = "com.xored.af.ui.ControlDecorationUpdater.delay";
    private static final int UPDATE_DELAY_DEFAULT = 50;

    private final Map<ControlDecoration, Update> updates = new HashMap<ControlDecoration, Update>();

    private int updateDelay;

    public ControlDecorationUpdater() {
        final String propValue = System.getProperty(PROP_UPDATE_DELAY);
        if (propValue != null) {
            try {
                final int updatePropValue = Integer.valueOf(propValue);
                if (updatePropValue >= 0) {
                    updateDelay = updatePropValue;
                } else {
                    updateDelay = UPDATE_DELAY_DEFAULT;
                }
            } catch (final NumberFormatException nfe) {
                updateDelay = UPDATE_DELAY_DEFAULT;
            }
        }
    }

    public synchronized void update(final ControlDecoration decoration, final Update update) {
        updates.put(decoration, update);
        UpdateDecorationJob.JOB_INSTANCE.schedule(updateDelay);
    }

    private final static boolean DEBUG = AfUiPlugin.getDefault().isDebugging();

    private synchronized void runUpdates() {
        final long startTime = System.currentTimeMillis();

        final Map<ControlDecoration, Update> updatesCopy = new HashMap<ControlDecoration, Update>(updates);
        updates.clear();

        final int size = updatesCopy.size();
        int changes = 0;

        for (final Map.Entry<ControlDecoration, Update> entry : updatesCopy.entrySet()) {
            final ControlDecoration decoration = entry.getKey();
            // decoration itself may be already disposed, and also its control
            // may be disposed separately because of non-atomicity of disposal
            if (decoration.getControl() != null && !decoration.getControl().isDisposed()) {
                final Update update = entry.getValue();
                boolean changed = false;
                if (!equals(decoration.getImage(), update.image)) {
                    decoration.setImage(update.image);
                    changed = true;
                }
                if (!equals(decoration.getDescriptionText(), update.text)) {
                    decoration.setDescriptionText(update.text);
                    changed = true;
                }
                if (!equals(decoration.getControl().getBackground(), update.controlBg)) {
                    decoration.getControl().setBackground(update.controlBg);
                    changed = true;
                }
                if (changed) {
                    changes++;
                }
            }
        }

        if (DEBUG) {
            AfUiPlugin.getDefault().info(
                "Updated " + changes + " decorations in " + size + " requests in "
                    + (System.currentTimeMillis() - startTime) + " millis");
        }
    }

    private boolean equals(final Object o1, final Object o2) {
        return o1 != null ? o1.equals(o2) : (o2 == null);
    }

    public static void update(final ControlDecoration decoration, final Image image, final String text,
        final Color controlBg) {
        UPDATER_INSTANCE.update(decoration, new Update(image, text, controlBg));
    }
}
