/*******************************************************************************
 * Copyright (c) 2010-2013 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Igor Zapletnev)
 *******************************************************************************/
package com.xored.af.ui.forms.parts;

import com.xored.af.ui.internal.AfUiPlugin;
import com.xored.af.validation.EmfDiagnostic;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.MarkerResolutionSelectionDialog;
import org.eclipse.ui.ide.IDE;

public class ControlDecorationAdapter extends AdapterImpl {
    private static final String EMF_CODE = "emf.code";
    private static final Image IMG_WARN = FieldDecorationRegistry.getDefault()
        .getFieldDecoration(FieldDecorationRegistry.DEC_WARNING).getImage();
    private static final Image IMG_ERR = FieldDecorationRegistry.getDefault()
        .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage();
    private static final Image IMG_ERR_QUICKFIX = FieldDecorationRegistry.getDefault()
        .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR_QUICKFIX).getImage();
    private static final Image IMG_INFORMATION = FieldDecorationRegistry.getDefault()
        .getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage();

    private static final Color COLOR_DEF = PlatformUI.getWorkbench().getDisplay()
        .getSystemColor(SWT.COLOR_WHITE);
    private static final Color COLOR_ERR = new Color(null, 255, 175, 175);
    private static final Color COLOR_WARN = new Color(null, 255, 255, 175);

    private final ControlDecoration decoration;
    private final EObject object;
    private final EStructuralFeature feature;
    private final Color originalBg;
    private final boolean useQuickFix;

    private MarkerResolutionSelectionDialog resolutionDialog;
    private List<IMarker> currentMarkers;
    private final List<IMarkerResolution> markerResolutions;
    private final KeyListener keyListener = new KeyListener() {
        public void keyReleased(final KeyEvent e) {
        }

        public void keyPressed(final KeyEvent e) {
            if (e.stateMask == 262144 && e.character == '1') {
                showQuickFixDialog();
            }

        }
    };

    private boolean keyListenerAdded = false;

    /**
     * Default constructor, do no use QuickFix and grey controls before save
     * 
     * @param decoration
     * @param object
     * @param feature
     */
    public ControlDecorationAdapter(final ControlDecoration decoration, final EObject object,
        final EStructuralFeature feature) {
        this(decoration, object, feature, false);
    }

    /**
     * @param decoration
     * @param object
     * @param feature
     * @param useQuickFix
     *            - use true for QuickFix on errors and grey control on not
     *            saved resource
     */
    public ControlDecorationAdapter(final ControlDecoration decoration, final EObject object,
        final EStructuralFeature feature, final boolean useQuickFix) {
        this.useQuickFix = useQuickFix;
        this.decoration = decoration;
        this.object = object;
        this.feature = feature;
        if (decoration.getControl() != null) {
            this.originalBg = COLOR_DEF;
        } else {
            this.originalBg = null;
        }

        currentMarkers = new ArrayList<IMarker>();
        markerResolutions = new ArrayList<IMarkerResolution>();
        if (useQuickFix) {
            final IWorkspace workspace = ResourcesPlugin.getWorkspace();
            workspace.addResourceChangeListener(new IResourceChangeListener() {

                public void resourceChanged(final IResourceChangeEvent event) {
                    final IResourceDelta delta = event.getDelta();
                    if (delta != null && getTarget() != null) {
                        final IResourceDelta thisDelta = delta.findMember(getPlatformPath(getTarget()));
                        if (thisDelta == null || thisDelta.getMarkerDeltas() == null) {
                            return;
                        }
                        boolean changed = false;
                        for (final IMarkerDelta mdelta : thisDelta.getMarkerDeltas()) {
                            if (mdelta.getKind() == IResourceDelta.ADDED
                                && !currentMarkers.contains(mdelta.getMarker())) {
                                currentMarkers.add(mdelta.getMarker());
                                changed = true;
                            } else if (mdelta.getKind() == IResourceDelta.REMOVED) {
                                currentMarkers.remove(mdelta.getMarker());
                                changed = true;
                            }
                        }
                        if (changed && thisDelta.getResource() != null && thisDelta.getResource().exists()) {
                            final WorkspaceJob updateDecorationJob = new WorkspaceJob(
                                "Update control decoration") {

                                @Override
                                public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                                    if (decoration.getControl() != null
                                        && !decoration.getControl().isDisposed()) {
                                        refreshResolutions();
                                        updateDecoration();
                                    }
                                    return Status.OK_STATUS;
                                }
                            };
                            updateDecorationJob.setRule(thisDelta.getResource());
                            updateDecorationJob.setUser(false);
                            updateDecorationJob.setSystem(true);
                            updateDecorationJob.schedule();
                        }
                    }
                }
            });

        }

    }

    public void updateDecoration() {

        final IFile file = getPlatformResource(getTarget());
        if (file == null || getTarget() == null || getTarget().getErrors() == null) {
            return;
        }

        for (final Diagnostic diag : getTarget().getErrors()) {
            if (diag instanceof EmfDiagnostic) {
                final EmfDiagnostic vozoneDiagnostic = (EmfDiagnostic) diag;
                if (feature == vozoneDiagnostic.getFeature() && vozoneDiagnostic.isInLocus(object, false)) {
                    cacheMarkers(file, vozoneDiagnostic.getErrCode());
                    if (useQuickFix && markerResolutions.size() > 0) {
                        addQuickFixListeners(true);
                        ControlDecorationUpdater.update(decoration, IMG_ERR_QUICKFIX,
                            vozoneDiagnostic.getMessage(), COLOR_ERR);
                        return;
                    } else {
                        if (useQuickFix) {
                            addQuickFixListeners(false);
                        }
                        ControlDecorationUpdater.update(decoration, IMG_ERR, vozoneDiagnostic.getMessage(),
                            COLOR_ERR);
                        return;
                    }
                }
            }
        }
        if (useQuickFix) {
            addQuickFixListeners(false);
        }
        for (final Diagnostic diag : getTarget().getWarnings()) {
            if (diag instanceof EmfDiagnostic) {
                final EmfDiagnostic vozoneDiagnostic = (EmfDiagnostic) diag;
                if (feature == vozoneDiagnostic.getFeature() && vozoneDiagnostic.isInLocus(object, false)) {
                    ControlDecorationUpdater.update(decoration, IMG_WARN, vozoneDiagnostic.getMessage(),
                        COLOR_WARN);
                    return;
                }
            }
        }
        ControlDecorationUpdater.update(decoration, null, "", originalBg);
    }

    private void addQuickFixListeners(final boolean add) {
        if (useQuickFix && decoration != null && decoration.getControl() != null) {
            decoration.getControl().getDisplay().asyncExec(new Runnable() {

                public void run() {
                    if (add && !keyListenerAdded) {
                        keyListenerAdded = true;
                        decoration.getControl().addKeyListener(keyListener);
                    } else if (keyListenerAdded) {
                        keyListenerAdded = false;
                        decoration.getControl().removeKeyListener(keyListener);
                    }
                }
            });
        }
    }

    private void cacheMarkers(final IFile file, final int statusCode) {
        if (useQuickFix) {
            currentMarkers = getMarkers(file, statusCode);

            refreshResolutions();
            if (!markerResolutions.isEmpty()) {
                decoration.getControl().getDisplay().asyncExec(new Runnable() {

                    public void run() {
                        if (!markerResolutions.isEmpty()) {
                            resolutionDialog = new MarkerResolutionSelectionDialog(decoration.getControl()
                                .getShell(), markerResolutions.toArray(new IMarkerResolution[0]));
                        }
                    }
                });
            } else {
                resolutionDialog = null;
            }
        }
    }

    private void showQuickFixDialog() {
        if (resolutionDialog == null) {
            return;
        }
        if (resolutionDialog.open() != Window.OK) {
            return;
        }
        final Object[] result = resolutionDialog.getResult();
        if (result != null && result.length > 0) {
            ((IMarkerResolution) result[0]).run(getMarkerByResolution((IMarkerResolution) result[0]));
        }

    }

    private IMarker getMarkerByResolution(final IMarkerResolution toFindMarker) {
        for (final IMarker marker : currentMarkers) {
            for (final IMarkerResolution res : markerResolutions) {
                if (res.equals(toFindMarker)) {
                    return marker;
                }
            }
        }
        return null;

    }

    private void refreshResolutions() {
        markerResolutions.clear();
        for (final IMarker marker : currentMarkers) {
            for (final IMarkerResolution res : IDE.getMarkerHelpRegistry().getResolutions(marker)) {
                if (!markerResolutions.contains(res)) {
                    markerResolutions.add(res);
                }
            }
        }
    }

    private List<IMarker> getMarkers(final IFile file, final int statusCode) {

        final List<IMarker> markers = new ArrayList<IMarker>();
        if (file == null) {
            return markers;
        }
        try {
            for (final IMarker marker : file.findMarkers(MarkerUtil.VALIDATION_MARKER_TYPE, true,
                IResource.DEPTH_INFINITE)) {
                if (marker.getAttribute(EMF_CODE, 0) == statusCode
                    && IDE.getMarkerHelpRegistry().hasResolutions(marker)) {
                    markers.add(marker);
                }
            }
        } catch (final CoreException e) {

        }
        return markers;
    }

    @Override
    public Resource getTarget() {
        return (Resource) super.getTarget();
    }

    @Override
    public void notifyChanged(final Notification msg) {
        if (!useQuickFix
            && msg.getNotifier() == target
            && (msg.getFeatureID(Resource.class) == Resource.RESOURCE__ERRORS || msg
                .getFeatureID(Resource.class) == Resource.RESOURCE__WARNINGS)) {
            updateDecoration();
        }
    }

    private final EContentAdapter liveValidationContentAdapter = new LiveValidationContentAdapter(this);

    public void install(final Resource resource) {

        final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(resource);
        if (domain != null) {
            try {
                domain.runExclusive(new Runnable() {

                    public void run() {
                        resource.eAdapters().add(ControlDecorationAdapter.this);
                        resource.eAdapters().add(liveValidationContentAdapter);
                    }
                });
            } catch (final InterruptedException e) {
                AfUiPlugin.getDefault().error(e);
            }
        } else {
            resource.eAdapters().add(this);
            resource.eAdapters().add(liveValidationContentAdapter);
        }
        updateDecoration();
    }

    public void uninstall() {
        if (getTarget() != null) {
            final Notifier targetRef = getTarget();

            targetRef.eAdapters().remove(this);
            targetRef.eAdapters().remove(liveValidationContentAdapter);
        }
    }

    private class LiveValidationContentAdapter extends EContentAdapter {
        private static final String SAVE_TO_REVALIDATE_TEXT = "Save this document to revalidate the changes";

        private final ControlDecorationAdapter controlDecorationAdapter;

        public LiveValidationContentAdapter(final ControlDecorationAdapter controlDecorationAdapter) {
            this.controlDecorationAdapter = controlDecorationAdapter;
        }

        @Override
        public void notifyChanged(final Notification notification) {
            if (controlDecorationAdapter.getTarget() != null && notification.getFeature() != null
                && notification.getFeature() == controlDecorationAdapter.feature) {
                ControlDecorationUpdater.update(decoration, IMG_INFORMATION, SAVE_TO_REVALIDATE_TEXT,
                    originalBg);
            }
        }
    }

    protected static IFile getPlatformResource(final Resource resource) {
        final IResource file = ResourcesPlugin.getWorkspace().getRoot().findMember(getPlatformPath(resource));
        return (file instanceof IFile) ? (IFile) file : null;
    }

    private static IPath getPlatformPath(final Resource resource) {
        if (resource == null || !resource.getURI().isPlatformResource()) {
            return null;
        }

        return Path.fromPortableString(resource.getURI().toPlatformString(true));
    }
}