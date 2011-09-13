package com.xored.x5.agent.eclipse.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class PackageBox {

	public static EPackage box(EPackage ePackage, URI uri) throws IOException {
		ePackage = EcoreUtil.copy(ePackage);
		List<Reference> references = getReferences(ePackage);
		ResourceSet resourceSet = new ResourceSetImpl();
		replace(resourceSet, references);
		save(resourceSet, uri, ePackage);
		return ePackage;
	}

	public static List<EPackage> getCrossPackages(EPackage ePackage) {
		Set<EPackage> packages = new HashSet<EPackage>();
		List<Reference> references = getReferences(ePackage);
		for (Reference reference : references) {
			packages.add(reference.getClassifier().getEPackage());
		}
		return new ArrayList<EPackage>(packages);
	}

	private static List<Reference> getReferences(EPackage ePackage) {
		Set<Reference> references = new HashSet<Reference>();
		Set<EPackage> ignore = new HashSet<EPackage>();
		ignore.add(ePackage);
		ignore.add(EcorePackage.eINSTANCE);
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EClass superType : eClass.getESuperTypes()) {
					if (!ignore.contains(superType.getEPackage()))
						references.add(new SuperTypeReference(eClass, superType));
				}
				for (EStructuralFeature feature : eClass.getEStructuralFeatures()) {
					EClassifier classifier = feature.getEType();
					if (!ignore.contains(classifier.getEPackage()))
						references.add(new FeatureReference(feature));
				}
			}
		}
		return new ArrayList<Reference>(references);
	}

	private static void replace(ResourceSet resourceSet, List<Reference> references) {
		resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
		Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		Map<EPackage, EPackage> cache = new HashMap<EPackage, EPackage>();
		for (Reference reference : references) {
			EClassifier eClassifier = reference.getClassifier();
			EPackage referencePackage = eClassifier.getEPackage();
			EPackage rightRef = cache.get(referencePackage);
			if (rightRef == null) {
				URI location = ePackageNsURItoGenModelLocationMap.get(referencePackage.getNsURI());
				Resource resource = resourceSet.getResource(location, true);
				EcoreUtil.resolveAll(resource);
				rightRef = findReplacement(resourceSet, referencePackage);
				cache.put(referencePackage, rightRef);
			}
			reference.replace(rightRef.getEClassifier(eClassifier.getName()));
		}
	}

	private static void save(ResourceSet resourceSet, URI uri, EPackage ePackage) throws IOException {
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(ePackage);
		resource.save(null);
	}

	private static EPackage findReplacement(ResourceSet resourceSet, EPackage ePackage) {
		for (Resource resource : resourceSet.getResources()) {
			for (EObject content : resource.getContents()) {
				if (content instanceof EPackage) {
					EPackage replacement = (EPackage) content;
					if (ePackage.getNsURI().equals(replacement.getNsURI())) {
						return replacement;
					}
				}
			}
		}
		return null;
	}

	static interface Reference {

		EClassifier getClassifier();

		void replace(EClassifier newClassifier);

	}

	static class SuperTypeReference implements Reference {

		public SuperTypeReference(EClass eClass, EClass superType) {
			this.eClass = eClass;
			this.superType = superType;
		}

		@Override
		public EClassifier getClassifier() {
			return superType;
		}

		@Override
		public void replace(EClassifier newClassifier) {
			int index = eClass.getESuperTypes().indexOf(superType);
			eClass.getESuperTypes().set(index, (EClass) newClassifier);
		}

		private EClass eClass;
		private EClass superType;

	}

	static class FeatureReference implements Reference {

		public FeatureReference(EStructuralFeature feature) {
			this.feature = feature;
		}

		@Override
		public EClassifier getClassifier() {
			return feature.getEType();
		}

		@Override
		public void replace(EClassifier newClassifier) {
			feature.setEType(newClassifier);
		}

		private EStructuralFeature feature;
	}

}
