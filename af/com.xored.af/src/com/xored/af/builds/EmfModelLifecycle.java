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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspace.ProjectOrder;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.xored.af.internal.AfPlugin;

public class EmfModelLifecycle {
    private final String natureId;
    private final EditingDomain domain;

    public EmfModelLifecycle(final EditingDomain domain, final String natureId) {
        this.natureId = natureId;
        this.domain = domain;
    }

    public void start() {
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();

        final List<IProject> toBuild = new ArrayList<IProject>();
        for (final IProject project : workspace.getRoot().getProjects()) {
            try {
                if (project.isAccessible() && project.getNature(natureId) != null) {
                    toBuild.add(project);
                }
            } catch (final CoreException e) {
                AfPlugin.getInstance().error(e);
            }
        }

        final ProjectOrder order = workspace.computeProjectOrder(toBuild.toArray(new IProject[0]));
        for (final IProject project : order.projects) {
            EmfBuilds.scheduleBuild(project, true);
        }

        workspace.addResourceChangeListener(workspaceListener);

        final IWorkspaceDescription description = workspace.getDescription();
        if (!description.isAutoBuilding()) {
            description.setAutoBuilding(true);
            try {
                workspace.setDescription(description);
            } catch (final CoreException e) {
                AfPlugin.getInstance().error(e);
            }
        }
    }

    public void stop() {
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(workspaceListener);
    }

    public String getNatureId() {
        return natureId;
    }

    private final IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {

        public boolean visit(final IResourceDelta delta) throws CoreException {
            if (delta.getResource() instanceof IProject) {
                final IProject project = (IProject) delta.getResource();
                if (delta.getKind() == IResourceDelta.CHANGED
                    && (delta.getFlags() & IResourceDelta.OPEN) != 0 && project.isOpen()
                    && project.getNature(natureId) != null) {
                    EmfBuilds.scheduleBuild(project, true);
                } else if (delta.getKind() == IResourceDelta.ADDED && project.isOpen()) {
                    project.getNature(natureId);
                }
                return false;
            }
            return delta.getResource() instanceof IWorkspaceRoot;
        }
    };

    private final IResourceChangeListener workspaceListener = new IResourceChangeListener() {

        public void resourceChanged(final IResourceChangeEvent event) {
            try {
                if (event.getType() == IResourceChangeEvent.PRE_CLOSE
                    || event.getType() == IResourceChangeEvent.PRE_DELETE) {
                    final IProject project = (IProject) event.getResource();
                    if (project.isOpen() && project.getNature(natureId) != null) {
                        unload(project);
                    }
                } else if (event.getDelta() != null) {
                    event.getDelta().accept(visitor);
                }
            } catch (final CoreException e) {
                AfPlugin.getInstance().error(e);
            }
        }

        private void unload(final IProject project) {
            run(new Runnable() {
                public void run() {
                    final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
                    final List<Resource> resources = new ArrayList<Resource>();
                    resources.addAll(domain.getResourceSet().getResources());
                    for (final Resource resource : resources) {
                        final URI uri = resource.getURI();
                        if (uri.isPlatformResource()) {
                            if (project.equals(root.getFile(new Path(uri.toPlatformString(true)))
                                .getProject())) {
                                if (resource.isLoaded()) {
                                    resource.unload();
                                }
                                domain.getResourceSet().getResources().remove(resource);
                            }
                        }
                    }
                }
            });
        }
    };

    private static final Map<Object, Object> OPTIONS;
    static {
        final Map<Object, Object> settings = new HashMap<Object, Object>();
        settings.put(Transaction.OPTION_NO_UNDO, Boolean.TRUE);
        OPTIONS = Collections.unmodifiableMap(settings);
    }

    private void run(final Runnable r) {
        if (!(domain instanceof TransactionalEditingDomain)) {
            r.run();
        } else {
            try {
                new AbstractEMFOperation((TransactionalEditingDomain) domain, "Runnable", OPTIONS) {

                    @Override
                    protected IStatus doExecute(final IProgressMonitor monitor, final IAdaptable info)
                        throws ExecutionException {
                        r.run();
                        return Status.OK_STATUS;
                    }
                }.execute(null, null);
            } catch (final ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
