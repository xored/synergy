package com.xored.x5.agent.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
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
		List<Status> fails = new ArrayList<Status>();
		List<EPackage> packages = getUnknownPackages(request);
		for (EPackage ePackage : packages) {
			PackageEntry entry = CommonFactory.eINSTANCE.createPackageEntry();
			entry.setContent(EcoreUtil.copy(ePackage));
			EObject response = transport.send(entry);
			Status status = asStatus(response);
			if (!StatusUtil.isOk(status)) {
				fails.add(status);
			}
		}

		DataSourceEntry entry = CommonFactory.eINSTANCE.createDataSourceEntry();
		entry.setContent(request);
		Status status = asStatus(transport.send(entry));
		if (!StatusUtil.isOk(status)) {
			fails.add(status);
		}
		if (fails.size() > 0) {
			Status result = StatusUtil.newErrorStatus(TARGET, "Error while sending " + request);
			result.getChildren().addAll(fails);
			return result;
		}
		return StatusUtil.newOkStatus();
	}

	private Status asStatus(EObject response) {
		if (response instanceof Status) {
			return (Status) response;
		}
		return StatusUtil.newErrorStatus(TARGET, "Expect status response, but found: " + response);
	}

	private List<EPackage> getUnknownPackages(EObject eObject) {
		Set<EPackage> packages = new HashSet<EPackage>();
		findMentionedPackages(eObject, packages);
		List<EPackage> result = new ArrayList<EPackage>();
		for (EPackage ePackage : packages) {
			findUnknownPackages(ePackage, result);
		}
		return result;
	}

	private void findMentionedPackages(EObject data, Set<EPackage> mentions) {
		mentions.add(data.eClass().getEPackage());
		for (EObject content : data.eContents()) {
			findMentionedPackages(content, mentions);
		}
	}

	private void findUnknownPackages(EPackage ePackage, Collection<EPackage> packages) {
		if (knownPackages.add(ePackage)) {
			Collection<EPackage> references = getReferences(ePackage);
			for (EPackage reference : references) {
				findUnknownPackages(reference, packages);
			}
			packages.add(ePackage);
		}
	}

	private Collection<EPackage> getReferences(EPackage ePackage) {
		Set<EPackage> references = new HashSet<EPackage>();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EClass superType : eClass.getESuperTypes()) {
					references.add(superType.getEPackage());
				}
				for (EStructuralFeature feature : eClass.getEStructuralFeatures()) {
					references.add(feature.getEType().getEPackage());
				}
			}
		}
		return references;
	}

	private final Transport transport;
	private final Set<EPackage> knownPackages = new HashSet<EPackage>();

	private static final String TARGET = PackageTransport.class.getPackage().getName();

}
