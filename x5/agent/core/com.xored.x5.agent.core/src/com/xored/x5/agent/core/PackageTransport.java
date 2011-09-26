package com.xored.x5.agent.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.sherlock.status.Status;
import com.xored.sherlock.status.StatusUtil;
import com.xored.x5.common.CommonFactory;
import com.xored.x5.common.DataSourceEntry;
import com.xored.x5.common.PackageEntry;

public class PackageTransport implements Transport {

	public PackageTransport(Transport transport) {
		this.transport = transport;
		knownPackages.add(EcorePackage.eINSTANCE);
	}

	@Override
	public void initialize(ResourceSet resourceSet) throws Exception {
		transport.initialize(resourceSet);
	}

	@Override
	public EObject send(EObject request) throws Exception {
		Set<EPackage> packages = new HashSet<EPackage>();
		findAllPackages(request, packages);

		List<Status> fails = new ArrayList<Status>();

		for (EPackage ePackage : packages) {
			if (knownPackages.add(ePackage)) {
				PackageEntry entry = CommonFactory.eINSTANCE.createPackageEntry();
				entry.setContent(EcoreUtil.copy(ePackage));
				EObject response = transport.send(entry);
				Status status = asStatus(response);
				if (!StatusUtil.isOk(status)) {
					fails.add(status);
				}
			}
		}

		DataSourceEntry entry = CommonFactory.eINSTANCE.createDataSourceEntry();
		entry.setContent(request);
		Status status = asStatus(transport.send(entry));
		if (!StatusUtil.isOk(status)) {
			fails.add(status);
		}
		if (fails.size() > 0) {
			Status result = StatusUtil.newErrorStatus("com.xored.x5.agent.core", "Error while sending " + request);
			result.getChildren().addAll(fails);
			return result;
		}
		return StatusUtil.newOkStatus();
	}

	private Status asStatus(EObject response) {
		if (response instanceof Status) {
			return (Status) response;
		}
		return StatusUtil.newErrorStatus("com.xored.x5.agent.core", "Expect status response, but found: " + response);
	}

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

	private final Transport transport;
	private final Set<EPackage> knownPackages = new HashSet<EPackage>();

}
