package com.xored.af.ui.forms;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;

public class FeatureUIDescriptor {
    public static abstract class ControlDescriptor {
    }

    public static class TextControl extends ControlDescriptor {
    }

    public static class CheckboxControl extends ControlDescriptor {
    }

    public static abstract class ComboControl extends ControlDescriptor {
        public ILabelProvider createLabelProvider() {
            return new LabelProvider();
        }

        public IStructuredContentProvider createContentProvider() {
            return ArrayContentProvider.getInstance();
        }
    }

    public final EStructuralFeature feature;
    public final ControlDescriptor control;
    public final String tooltip;
    public final String label;
    private final UpdateValueStrategy targetToModel;
    private final UpdateValueStrategy modelToTarget;

    public FeatureUIDescriptor(final EStructuralFeature feature, final ControlDescriptor control,
        final String tooltip, final String label, final UpdateValueStrategy targetToModel,
        final UpdateValueStrategy modelToTarget) {

        this.feature = feature;
        this.control = control;
        this.tooltip = tooltip;
        this.label = label;
        this.targetToModel = targetToModel != null ? targetToModel : new UpdateValueStrategy();
        this.modelToTarget = modelToTarget != null ? modelToTarget : new UpdateValueStrategy();
    }

    public FeatureUIDescriptor(final EStructuralFeature feature, final ControlDescriptor control,
        final String tooltip, final String label) {
        this(feature, control, tooltip, label, null, null);
    }

    public boolean applicable(final EObject o) {
        return true;
    }

    public UpdateValueStrategy createTargetToModel() {
        return targetToModel;
    }

    public UpdateValueStrategy createModelToTarget() {
        return modelToTarget;
    }
}
