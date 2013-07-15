package com.xored.af.ui.labels;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;

import com.xored.af.ui.internal.AfUiPlugin;

public class ResourceDecorator extends LabelProvider implements ILightweightLabelDecorator {

    public void decorate(Object element, IDecoration decoration) {
        if (element instanceof Resource) {
            final Resource resource = (Resource) element;
            if (!resource.getErrors().isEmpty()) {
                decoration.addOverlay(AfUiPlugin.OVR_ERROR);
            } else if (!resource.getWarnings().isEmpty()) {
                decoration.addOverlay(AfUiPlugin.OVR_WARN);
            }
        }
    }
}
