package com.xored.sherlock.eclipse.workspace;

import java.io.File;
import java.net.URI;
import java.util.Map;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EntityDataSource;

public class WorkspaceSource implements EntityDataSource {

	@Override
	public EObject getData() {
		final Workspace workspace = WorkspaceFactory.eINSTANCE.createWorkspace();
		String location = getLocation();
		if (location != null) {
			workspace.setLocation(location);
			try {
				File workspaceDir = new File(location);
				DiskPartition partition = WorkspaceFactory.eINSTANCE.createDiskPartition();
				partition.setTotalSpace(workspaceDir.getTotalSpace());
				partition.setUsableSpace(workspaceDir.getUsableSpace());
				partition.setFreeSpace(workspaceDir.getFreeSpace());
				workspace.setPartition(partition);
			} catch (Throwable t) {
			}
		}
		return workspace;
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	private static String getLocation() {
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IPath path = root.getLocation();
		if (path != null) {
			return path.toFile().getAbsolutePath();
		} else {
			final URI uri = root.getLocationURI();
			if (uri != null) {
				return uri.toString();
			}
		}
		return null;
	}

}
