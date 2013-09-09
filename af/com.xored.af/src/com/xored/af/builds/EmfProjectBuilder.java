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
package com.xored.af.builds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

import com.xored.af.EmfTransactionJob;
import com.xored.af.internal.AfPlugin;

public abstract class EmfProjectBuilder extends IncrementalProjectBuilder {
    public static final String SKIP_MARKER = "com.xored.af.skipBuild";
    private static final String TIME_STAMP_ATTR = "timeStamp";

    public static void markForSkip(final IFile file) {
        Assert.isNotNull(file, "file");
        Assert.isTrue(file.exists(), "file.exists()");
        try {
            final IMarker marker = file.createMarker(SKIP_MARKER);
            marker.setAttribute(TIME_STAMP_ATTR, String.valueOf(file.getLocalTimeStamp()));
        } catch (final CoreException e) {
            throw new RuntimeException(e);
        }
    }

    protected final TransactionalEditingDomain editingDomain;
    private final IWorkspace workspace;

    public EmfProjectBuilder(final TransactionalEditingDomain editingDomain) {
        this.editingDomain = editingDomain;
        this.workspace = ResourcesPlugin.getWorkspace();
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected IProject[] build(final int kind, final Map args, IProgressMonitor pm) throws CoreException {
        if (pm == null) {
            pm = new NullProgressMonitor();
        }

        final long startTime = System.currentTimeMillis();

        // handle cases when it looks like an incremental build, but actually is
        // not.
        // if (kind == INCREMENTAL_BUILD || kind == AUTO_BUILD) {
        // final IResourceDelta projectDelta = getDelta(getProject());
        // if (projectDelta == null) {
        // kind = FULL_BUILD;
        // }
        // }

        if (AfPlugin.getInstance().isDebugging()) {
            System.out.println("Building " + getProject().getName() + " with kind=" + getKindString(kind)); //$NON-NLS-1$ //$NON-NLS-2$
        }

        try {
            workspace.run(new IWorkspaceRunnable() {

                public void run(final IProgressMonitor pm) throws CoreException {
                    doBuild(kind, SubMonitor.convert(pm));
                }
            }, pm);
        } finally {
            pm.done();
        }

        if (AfPlugin.getInstance().isDebugging()) {
            final long spent = System.currentTimeMillis() - startTime;
            System.out.println("Built " + getProject().getName() + " in " + spent + " millis"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }

        return new IProject[] {};
    }

    private void doBuild(final int kind, final SubMonitor monitor) throws CoreException {
        final long start = System.currentTimeMillis();
        if (kind == FULL_BUILD) {
            monitor.beginTask("Building " + getProject().getName(), 2);

            executeRunnable(new FullBuildRunnable(monitor), true);
            final long loadTimestamp = System.currentTimeMillis();
            if (AfPlugin.getInstance().isDebugging()) {
                final long loadElapsed = loadTimestamp - start;
                if (loadElapsed > 20) {
                    AfPlugin.getInstance().info("Full load done in " + loadElapsed + "ms");
                }
            }

            executeRunnable(new ValidationRunnable(monitor, kind), true);
            final long validateTimestamp = System.currentTimeMillis();
            if (AfPlugin.getInstance().isDebugging()) {
                final long validationElapsed = validateTimestamp - loadTimestamp;
                if (validationElapsed > 20) {
                    AfPlugin.getInstance().info("Full validation done in " + validationElapsed + "ms");
                }
            }
        } else if (kind == INCREMENTAL_BUILD || kind == AUTO_BUILD) {
            monitor.beginTask("Building " + getProject().getName(), 2);

            executeRunnable(new IncrementalBuildRunnable(monitor), false);
            final long loadTimestamp = System.currentTimeMillis();

            executeRunnable(new ValidationRunnable(monitor, kind), true);
            final long validateTimestamp = System.currentTimeMillis();
            if (AfPlugin.getInstance().isDebugging()) {
                final long validationElapsed = validateTimestamp - loadTimestamp;
                if (validationElapsed > 20) {
                    AfPlugin.getInstance()
                        .info("Incremenatal validation done in " + validationElapsed + "ms");
                }
            }
        } else if (kind == CLEAN_BUILD) {
            clean(monitor);
        }
    }

    protected void performIncrementalBuild(final SubMonitor monitor) {
        // incremental build
        final List<IFile> added = new ArrayList<IFile>();
        final List<IFile> removed = new ArrayList<IFile>();
        final List<IFile> changed = new ArrayList<IFile>();

        try {
            getDelta(getProject()).accept(new IResourceDeltaVisitor() {

                public boolean visit(final IResourceDelta delta) throws CoreException {
                    final IResource deltaResource = delta.getResource();
                    if (deltaResource instanceof IFile) {
                        final IFile file = (IFile) deltaResource;
                        if (isEmfResource(file) && (!file.exists() || !skip(file))) {

                            switch (delta.getKind()) {
                            case IResourceDelta.ADDED:
                                added.add(file);
                                break;
                            case IResourceDelta.REMOVED:
                                removed.add(file);
                                break;
                            case IResourceDelta.CHANGED:
                                changed.add(file);
                                break;
                            }
                        }
                        if (file.exists()) {
                            file.deleteMarkers(SKIP_MARKER, false, IResource.DEPTH_ZERO);
                        }
                    }
                    return true;
                }
            });
        } catch (final CoreException e1) {
            throw new RuntimeException(e1);
        }

        monitor.beginTask("Re-reading files", added.size() + removed.size() + changed.size());

        for (final IFile file : removed) {
            checkCanceled(monitor);

            if (AfPlugin.getInstance().isDebugging()) {
                System.out.println("Builder: removed " + file.getFullPath());
            }

            removed(file, monitor);
        }

        loadFiles(monitor.newChild(added.size()), added);

        for (final IFile file : changed) {
            checkCanceled(monitor);

            if (AfPlugin.getInstance().isDebugging()) {
                System.out.println("Builder: changed " + file.getFullPath());
            }

            changed(file, monitor);
        }
    }

    private boolean skip(final IFile file) {
        IMarker[] skipMarkers;
        try {
            skipMarkers = file.findMarkers(SKIP_MARKER, false, IResource.DEPTH_ZERO);
        } catch (final CoreException e) {
            throw new RuntimeException(e);
        }
        if (skipMarkers.length == 0) {
            return false;
        }
        final long timeStamp = file.getLocalTimeStamp();

        for (final IMarker skipMarker : skipMarkers) {
            if (skipMarker(skipMarker, timeStamp)) {
                return true;
            }
        }
        return false;
    }

    private boolean skipMarker(final IMarker skipMarker, final long timeStamp) {
        try {
            if (Long.valueOf(skipMarker.getAttribute(TIME_STAMP_ATTR, null)) == timeStamp) {
                return true;
            }
        } catch (final NumberFormatException ex) {
            return false;
        }
        return false;
    }

    protected void changed(final IFile file, final SubMonitor monitor) {
        try {
            final Resource resource = editingDomain.getResourceSet().getResource(
                URI.createPlatformResourceURI(file.getFullPath().toString(), true), false);
            if (resource != null) {
                if (resource.isLoaded()) {
                    resource.unload();
                }
                resource.load(editingDomain.getResourceSet().getLoadOptions());
            }
        } catch (final Exception e) {
            AfPlugin.getInstance().error(e);
        } finally {
            monitor.worked(1);
        }
    }

    protected void removed(final IFile file, final SubMonitor monitor) {
        try {
            final Resource resource = editingDomain.getResourceSet().getResource(
                URI.createPlatformResourceURI(file.getFullPath().toString(), true), false);
            if (resource != null) {
                if (resource.isLoaded()) {
                    resource.unload();
                }
                editingDomain.getResourceSet().getResources().remove(resource);
            }
        } catch (final Exception e) {
            AfPlugin.getInstance().error(e);
        } finally {
            monitor.worked(1);
        }
    }

    private static final int WORK_UNLOAD = 2;
    private static final int WORK_COLLECT = 1;
    private static final int WORK_LOAD = 20;
    private static final int WORK_TOTAL = WORK_UNLOAD + WORK_COLLECT + WORK_LOAD;

    protected void performFullBuild(final SubMonitor monitor) {
        monitor.beginTask("Building " + getProject().getName(), WORK_TOTAL);

        performClean(monitor.newChild(WORK_UNLOAD));

        final List<IFile> files = collectFiles(monitor.newChild(WORK_COLLECT));
        loadFiles(monitor.newChild(WORK_LOAD), files);
    }

    protected void loadFiles(final SubMonitor loadMonitor, final List<IFile> files) {
        loadMonitor.beginTask("Loading resources", files.size());
        for (final IFile file : files) {
            checkCanceled(loadMonitor);
            added(file, loadMonitor);
        }
        loadMonitor.done();
    }

    protected void added(final IFile file, final SubMonitor loadMonitor) {
        if (!file.exists()) {
            return;
        }
        loadMonitor.setTaskName("Loading " + file.getName());
        if (AfPlugin.getInstance().isDebugging()) {
            // System.out.println("Loading " + file.getName());
        }
        try {
            final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
            final Resource resource = editingDomain.getResourceSet().createResource(uri);
            resource.load(editingDomain.getResourceSet().getLoadOptions());
        } catch (final Exception e) {
            // TODO: create error diag
            // resource.getErrors().add();
            AfPlugin
                .getInstance()
                .getLog()
                .log(
                    new Status(IStatus.ERROR, AfPlugin.PLUGIN_ID, "Unable to load resource: "
                        + file.getFullPath(), e));
        } finally {
            loadMonitor.worked(1);
        }
    }

    private List<IFile> collectFiles(final SubMonitor collectMonitor) {
        collectMonitor.beginTask("Collecting resources", 1);
        final List<IFile> files = new ArrayList<IFile>();
        try {
            getProject().accept(new IResourceVisitor() {

                public boolean visit(final IResource resource) throws CoreException {
                    if (collectMonitor.isCanceled()) {
                        throw new CoreException(Status.CANCEL_STATUS);
                    }

                    if (resource instanceof IFile && isEmfResource((IFile) resource)) {
                        final IFile file = (IFile) resource;
                        files.add(file);
                        return false;
                    }
                    return resource instanceof IContainer;
                }
            });
        } catch (final CoreException e) {
            if (e.getStatus().getSeverity() == IStatus.CANCEL) {
                throw new OperationCanceledException();
            }
            throw new RuntimeException("Unable to build project " + getProject().getName(), e);
        }
        collectMonitor.done();
        return files;
    }

    protected void checkCanceled(final IProgressMonitor monitor) {
        if (monitor.isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    // as default XMI factory may be registered, we need to explicitly check if
    // the file is an EMF resource that we want to load into resource set
    protected abstract boolean isEmfResource(final IFile file);

    private boolean belongsToProject(final Resource resource) {
        return resource.getURI().isPlatformResource()
            && workspace.getRoot().getFile(new Path(resource.getURI().toPlatformString(true))).getProject()
                .equals(getProject());
    }

    private void executeRunnable(final Runnable runnable, final boolean readOnly) {
        if (editingDomain instanceof TransactionalEditingDomain) {
            final TransactionalEditingDomain tdomain = editingDomain;
            if (readOnly) {
                try {
                    tdomain.runExclusive(runnable);
                } catch (final InterruptedException e) {
                    AfPlugin.getInstance().error("Build interrupted", e);
                }
            } else {
                tdomain.getCommandStack().execute(new RecordingCommand(tdomain) {

                    @Override
                    protected void doExecute() {
                        runnable.run();
                    }
                });
            }
        } else {
            try {
                runnable.run();
            } catch (final Exception e) {
                AfPlugin.getInstance().error(e);
            }
        }
    }

    protected static IFile getPlatformResource(final Resource resource) {
        if (!resource.getURI().isPlatformResource()) {
            return null;
        }

        return (IFile) ResourcesPlugin.getWorkspace().getRoot()
            .findMember(Path.fromPortableString(resource.getURI().toPlatformString(true)));
    }

    private final IBatchValidator validator = createValidator();
    protected final Object validationFamily = new Object();

    protected IBatchValidator createValidator() {
        return ModelValidationService.getInstance().<EObject, IBatchValidator> newValidator(
            EvaluationMode.BATCH);
    }

    protected void scheduleValidation() {
        Job.getJobManager().cancel(validationFamily);

        try {
            getProject().deleteMarkers(getMarkerType(), true, IResource.DEPTH_INFINITE);
        } catch (final CoreException e) {
            AfPlugin.getInstance().error(e);
        }

        final Collection<Resource> resources = new ArrayList<Resource>();
        for (final Resource resource : editingDomain.getResourceSet().getResources()) {
            if (resource.getURI().isPlatformResource()) {
                final IFile platformResource = getPlatformResource(resource);
                if (platformResource != null && platformResource.getProject().equals(getProject())
                    && isEmfResource(platformResource)) {
                    resources.add(resource);
                }
            }
        }

        for (final Resource resource : resources) {
            resource.getErrors().clear();
            resource.getWarnings().clear();

            new ValidateResourceJob(resource).schedule();
        }
    }

    public class ValidateResourceJob extends EmfTransactionJob {
        public ValidateResourceJob(final Resource resource) {
            this(resource, getProject());
        }

        public ValidateResourceJob(final Resource resource, final IProject project) {
            super("Validate resource " + resource.getURI().toString(),
                new ValidateResourceRunnable(resource), EmfProjectBuilder.this.editingDomain);
            setPriority(DECORATE);
            setRule(MultiRule.combine(new TransactionRule(editingDomain), project.getParent()));
        }

        @Override
        public boolean belongsTo(final Object family) {
            if (family == validationFamily || family == EmfBuilds.VALIDATION_FAMILY) {
                return true;
            }

            return super.belongsTo(family);
        }

        @Override
        protected IStatus run(final IProgressMonitor monitor) {
            try {
                monitor.beginTask(getName(), IProgressMonitor.UNKNOWN);
                domain.runExclusive(runnable);
            } catch (final OperationCanceledException oce) {
                return Status.CANCEL_STATUS;
            } catch (final Exception e) {
                return new Status(IStatus.ERROR, AfPlugin.PLUGIN_ID, "Error in EMF transaction", e);
            } finally {
                monitor.done();
            }

            return Status.OK_STATUS;
        }

    }

    private class ValidateResourceRunnable implements Runnable {
        private final Resource resource;

        public ValidateResourceRunnable(final Resource resource) {
            this.resource = resource;
        }

        public void run() {
            // System.out.println("Validating " + resource.getURI().toString());
            validate(resource, SubMonitor.convert(new NullProgressMonitor()));
        }
    }

    protected void validate(final Resource resource, final SubMonitor monitor) {
        final IStatus result = validator.validate(resource.getContents(), monitor);

        // re-create markers
        try {
            com.xored.af.internal.MarkerUtil.createMarkers(result, IStatus.ERROR | IStatus.WARNING,
                getMarkerType(), null);
        } catch (final CoreException ce) {
            AfPlugin.getInstance().error(ce);
        }
    }

    private class FullBuildRunnable implements Runnable {
        public final SubMonitor monitor;

        public FullBuildRunnable(final SubMonitor monitor) {
            this.monitor = monitor;
        }

        public void run() {
            performFullBuild(monitor.newChild(1));
        }
    }

    private class ValidationRunnable implements Runnable {
        public final SubMonitor monitor;
        private final int kind;

        public ValidationRunnable(final SubMonitor monitor, final int kind) {
            this.monitor = monitor;
            this.kind = kind;
        }

        public void run() {
            if (kind == INCREMENTAL_BUILD || kind == AUTO_BUILD) {
                scheduleIncrementalValidation();
            } else {
                scheduleValidation();
            }
            monitor.done();
        }
    }

    private class IncrementalBuildRunnable implements Runnable {
        public final SubMonitor monitor;

        public IncrementalBuildRunnable(final SubMonitor monitor) {
            this.monitor = monitor;
        }

        public void run() {
            performIncrementalBuild(monitor.newChild(1));
        }
    }

    private class CleanRunnable implements Runnable {
        public final SubMonitor monitor;

        public CleanRunnable(final SubMonitor monitor) {
            this.monitor = monitor;
        }

        public void run() {
            performClean(monitor);
        }
    }

    @Override
    protected void clean(final IProgressMonitor monitor) throws CoreException {
        if (AfPlugin.getInstance().isDebugging()) {
            System.out.println("Builder: cleaning " + getProject().getName());
        }

        try {
            executeRunnable(new CleanRunnable(SubMonitor.convert(monitor)), false);
        } finally {
            monitor.done();
        }
    }

    public void scheduleIncrementalValidation() {
        scheduleValidation();
    }

    protected void performClean(final SubMonitor monitor) {
        monitor.beginTask("Unloading resources", 1);

        final List<Resource> resources = new ArrayList<Resource>();
        resources.addAll(editingDomain.getResourceSet().getResources());
        for (final Resource resource : resources) {
            checkCanceled(monitor);
            if (belongsToProject(resource)) {
                if (resource.isLoaded()) {
                    resource.unload();
                }
                editingDomain.getResourceSet().getResources().remove(resource);
            }
        }

        if (getProject().isOpen() && !workspace.isTreeLocked()) {
            try {
                getProject().deleteMarkers(SKIP_MARKER, false, IResource.DEPTH_INFINITE);
            } catch (final CoreException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String getKindString(final int kind) {
        switch (kind) {
        case INCREMENTAL_BUILD:
            return "INCREMENTAL_BUILD";
        case AUTO_BUILD:
            return "AUTO_BUILD";
        case FULL_BUILD:
            return "FULL_BUILD";
        case CLEAN_BUILD:
            return "CLEAN_BUILD";
        default:
            return String.valueOf(kind);
        }
    }

    protected String getMarkerType() {
        return MarkerUtil.VALIDATION_MARKER_TYPE;
    }
}
