package com.xored.af;

import org.eclipse.emf.common.notify.Notifier;

/**
 * 
 */
public interface PreviewLabelProvider {
    /**
     * Can be called from any thread, does not require emf transaction context
     * 
     * @param o
     * @return
     */
    public Label getLabel(final Notifier o);
}
