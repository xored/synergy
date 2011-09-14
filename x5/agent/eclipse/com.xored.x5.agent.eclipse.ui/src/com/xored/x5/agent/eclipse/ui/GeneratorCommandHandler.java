package com.xored.x5.agent.eclipse.ui;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.importer.ModelImporter.EPackageImportInfo;
import org.eclipse.emf.importer.ecore.EcoreImporter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.x5.agent.X5DataSourceFactory;
import com.xored.x5.agent.eclipse.X5Core;

public class GeneratorCommandHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		X5DataSourceFactory factory = getFactory();
		if (factory == null) {
			throw new IllegalArgumentException("No one X5 factory registered");
		}
		try {
			IFile model = getFile(factory);
			EPackage ePackage = createModel(model, factory);
			GenModel genModel = createGenModel(model, ePackage);
			generateSources(genModel);
		} catch (Exception e) {
			throw new ExecutionException(e.getMessage(), e);
		}

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(window.getShell(), "Test", "Hello, Eclipse world");
		return null;
	}

	private EPackage createModel(IFile file, X5DataSourceFactory factory) throws CoreException, IOException {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		if (file.exists()) {
			file.delete(true, null);
		}
		return PackageBox.box(factory.getEPackage(), uri);
	}

	private GenModel createGenModel(IFile model, EPackage ePackage) throws Exception {
		EcoreImporter importer = new EcoreImporter();

		String name = ePackage.getName();

		importer.setModelFile(model);
		importer.setGenModelContainerPath(model.getParent().getFullPath());
		importer.setGenModelFileName(name + ".genmodel");

		importer.getEPackages().add(ePackage);
		importer.getEPackageImportInfo(ePackage).setConvert(true);
		importer.getEPackageImportInfo(ePackage).setEcoreFileName(name + ".ecore");

		ResourceSet resourceSet = ePackage.eResource().getResourceSet();
		List<EPackage> ePackages = PackageBox.getCrossPackages(ePackage);
		Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		for (EPackage crossPackage : ePackages) {
			URI uri = ePackageNsURItoGenModelLocationMap.get(crossPackage.getNsURI());
			Resource resource = resourceSet.getResource(uri, false);
			GenModel genModel = (GenModel) resource.getContents().get(0);

			importer.getEPackages().add(crossPackage);
			EPackageImportInfo info = importer.getEPackageImportInfo(crossPackage);
			info.setConvert(false);
			String ePackagePath = crossPackage.eResource().getURI().lastSegment();
			info.setEcoreFileName(URI.decode(ePackagePath));

			importer.getExternalGenModels().add(genModel);
			importer.getReferencedGenPackages().add(genModel.findGenPackage(crossPackage));
		}

		importer.prepareGenModelAndEPackages(null);
		GenPackage genPackage = importer.getGenModel().findGenPackage(ePackage);
		genPackage.setBasePackage(getBasePackage(ePackage.getNsPrefix()));
		importer.saveGenModelAndEPackages(null);

		return importer.getGenModel();
	}

	private void generateSources(GenModel model) {
		model.reconcile();
		model.setCanGenerate(true);

		Generator generator = GenModelUtil.createGenerator(model);
		generator.generate(model, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor());
	}

	private String getBasePackage(String id) {
		int index = id.lastIndexOf('.');
		if (index < 0 || index >= id.length() - 1) {
			return id;
		}
		return id.substring(0, index);
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
		return folder.getFile(factory.getEPackage().getName() + ".ecore");
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
