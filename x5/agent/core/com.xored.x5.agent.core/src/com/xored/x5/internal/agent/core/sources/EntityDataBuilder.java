package com.xored.x5.internal.agent.core.sources;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EntityDataSource;

public class EntityDataBuilder extends DataBuilder {

	public EntityDataBuilder(EClass eClass, List<DataLink> links) {
		super(eClass, links);
	}

	public EObject build(EObject data) {
		EObject result = createAndCopy(data);
		firePrepare(result);
		for (DataLink link : links) {
			EntityDataSource source = (EntityDataSource) link.getSource();
			result.eSet(link.getEReference(), source.getData());
		}
		firePush(result);
		return result;
	}

}
