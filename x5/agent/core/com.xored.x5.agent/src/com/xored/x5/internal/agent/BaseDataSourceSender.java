package com.xored.x5.internal.agent;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.x5.agent.Transport;
import com.xored.x5.common.CommonFactory;
import com.xored.x5.common.DataSourceEntry;
import com.xored.x5.common.PackageEntry;

abstract class BaseDataSourceSender<T extends DataSource> implements DataSourceSender {

	protected BaseDataSourceSender(DataSourceFactory factory, ExecutorService executor) {
		this.factory = factory;
		this.executor = executor;
		knownPackages.add(EcorePackage.eINSTANCE);
	}

	public void attachTo(Transport transport) {
		detach();
		this.transport = transport;
		attach();
	}

	public void detach() {
		if (source != null) {
			detachSource(source);
			source = null;
		}
		if (transport != null) {
			transport = null;
		}
	}

	abstract protected void attachSource(T source);

	abstract protected void detachSource(T source);

	protected void push(final EObject data) {
		executor.submit(new Runnable() {

			@Override
			public void run() {
				Set<EPackage> packages = new HashSet<EPackage>();
				findAllPackages(data, packages);

				for (EPackage ePackage : packages) {
					if (knownPackages.add(ePackage)) {
						PackageEntry entry = CommonFactory.eINSTANCE.createPackageEntry();
						entry.setSource(factory.getId());
						entry.setContent(EcoreUtil.copy(ePackage));
						transport.send(entry);
					}
				}

				DataSourceEntry entry = CommonFactory.eINSTANCE.createDataSourceEntry();
				entry.setSource(factory.getId());
				entry.setContent(data);
				transport.send(entry);
			}
		});
	}

	private Set<EPackage> knownPackages = new HashSet<EPackage>();

	private void findAllPackages(EObject data, Collection<EPackage> packages) {
		EClass eClass = data.eClass();
		findAllPackages(eClass, packages);
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			findAllPackages(attribute.getEAttributeType(), packages);
		}
		for (EObject content : data.eContents()) {
			findAllPackages(content, packages);
		}
	}

	private void findAllPackages(EClassifier type, Collection<EPackage> packages) {
		packages.add(type.getEPackage());
		if (type instanceof EClass) {
			EClass eClass = (EClass) type;
			for (EClass superType : eClass.getEAllSuperTypes()) {
				packages.add(superType.getEPackage());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void attach() {
		Map<String, String> options = Collections.emptyMap();
		source = (T) factory.create(options);
		attachSource(source);
	}

	private T source;
	private DataSourceFactory factory;
	private Transport transport;
	private ExecutorService executor;

}
