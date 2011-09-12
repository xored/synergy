package com.xored.x5.agent.eclipse.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.importer.ecore.EcoreImporter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.x5.agent.eclipse.X5Core;
import com.xored.x5.agent.sources.X5DataSourceFactory;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		X5DataSourceFactory factory = getFactory();
		if (factory == null) {
			throw new IllegalArgumentException("No one X5 factory registered");
		}
		try {
			IFile model = createModel(factory);
			createGenModel(model);
		} catch (Exception e) {
			throw new ExecutionException(e.getMessage(), e);
		}

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(window.getShell(), "Test", "Hello, Eclipse world");
		return null;
	}

	private IFile createModel(X5DataSourceFactory factory) throws CoreException, IOException {
		IFile file = getFile(factory);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		byte[] content = getContent(factory, uri);
		ByteArrayInputStream source = new ByteArrayInputStream(content);
		if (!file.exists()) {
			file.create(source, true, null);
		} else {
			file.setContents(source, true, true, null);
		}
		return file;
	}

	private void createGenModel(IFile model) throws Exception {
		EcoreImporter importer = new EcoreImporter();
		importer.setModelFile(model);
		importer.setGenModelContainerPath(model.getParent().getFullPath());
		importer.setGenModelFileName("model.genmodel");
		importer.prepareGenModelAndEPackages(null);
		importer.saveGenModelAndEPackages(null);
	}

	private IFile getFile(X5DataSourceFactory factory) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(factory.getId());
		if (!project.exists()) {
			project.create(null);
		}
		if (!project.isOpen()) {
			project.open(null);
		}
		IFolder folder = project.getFolder("model");
		if (!folder.exists()) {
			folder.create(true, true, null);
		}
		return folder.getFile("model.ecore");
	}

	private byte[] getContent(X5DataSourceFactory factory, URI uri) throws IOException {
		EPackage ePackage = factory.getEPackage();
		Resource resource = new XMIResourceImpl(uri);
		resource.getContents().add(ePackage);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		resource.save(stream, null);
		return stream.toByteArray();
	}

	private X5DataSourceFactory getFactory() {
		Collection<DataSourceFactory> factories = X5Core.getRegistry().getFactories();
		for (DataSourceFactory factory : factories) {
			if (factory instanceof X5DataSourceFactory) {
				return (X5DataSourceFactory) factory;
			}
		}
		return null;
	}
}
