package com.xored.x5.sample.monitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceRegistry;
import com.xored.sherlock.eclipse.core.SherlockCore;
import com.xored.x5.agent.X5DataSourceFactory;
import com.xored.x5.core.BaseDataSource;
import com.xored.x5.core.CompositeDataSource;
import com.xored.x5.core.DataSourceReference;

public class X5Locator {

	public void start() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {

			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				IResourceDelta delta = event.getDelta();
				if (delta != null) {
					try {
						delta.getResource();
						delta.accept(new IResourceDeltaVisitor() {
							@Override
							public boolean visit(IResourceDelta delta) throws CoreException {
								IResource res = delta.getResource();
								handle(res, delta.getKind());
								return true;
							}
						});
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	private void handle(IResource res, int kind) {
		IFile file = getAsFile(res);
		if (file != null) {
			List<DataSourceFactory> list = sources.get(file);
			if (list != null) {
				for (DataSourceFactory factory : list) {
					SherlockCore.getRegistry().removeFactory(factory);
				}
			}
			if (kind == IResourceDelta.CHANGED || kind == IResourceDelta.ADDED) {
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				Resource resource = resources.getResource(uri, false);
				if (resource != null) {
					resources.getResources().remove(resource);
				}
				resource = resources.getResource(uri, true);
				list = load(resource);
				sources.put(file, list);
			}
		}
	}

	private IFile getAsFile(IResource res) {
		if (res instanceof IFile) {
			IFile file = (IFile) res;
			if ("x5".equals(file.getFileExtension())) {
				return file;
			}
		}
		return null;
	}

	private List<DataSourceFactory> load(Resource resource) {
		final DataSourceRegistry registry = SherlockCore.getRegistry();
		List<DataSourceFactory> factories = new ArrayList<DataSourceFactory>();
		for (EObject object : resource.getContents()) {
			if (object instanceof CompositeDataSource) {
				CompositeDataSource source = (CompositeDataSource) object;
				String id = source.getId();
				if (id != null && !id.isEmpty()) {
					DataSourceFactory factory = build(source, registry);
					registry.addFactory(factory);
					factories.add(factory);
				}
			}
		}
		return factories;
	}

	private static DataSourceFactory build(BaseDataSource source, DataSourceRegistry registry) {
		if (source instanceof CompositeDataSource) {
			CompositeDataSource cds = (CompositeDataSource) source;
			DataSourceFactory base = build(cds.getBase(), registry);
			List<com.xored.x5.agent.DataSourceReference> references = new ArrayList<com.xored.x5.agent.DataSourceReference>();
			for (DataSourceReference reference : cds.getReferences()) {
				DataSourceFactory rg = build(reference.getSource(), registry);
				references.add(new com.xored.x5.agent.DataSourceReference(reference.getName(), rg));
			}
			return new X5DataSourceFactory(cds.getName(), base, references, cds.getName());
		} else {
			return registry.getFactory(source.getId());
		}
	}

	private ResourceSet resources = new ResourceSetImpl();

	private Map<IFile, List<DataSourceFactory>> sources = new HashMap<IFile, List<DataSourceFactory>>();

}
