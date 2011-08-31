package com.xored.x5.internal.core;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EntityDataSource;
import com.xored.x5.internal.core.builders.EntityDataBuilder;

public class X5EntityDataSource implements EntityDataSource {

	public X5EntityDataSource(EntityDataSource source, EntityDataBuilder builder) {
		this.source = source;
		this.builder = builder;
	}

	@Override
	public EObject getData() {
		return builder.build(source.getData());
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	private EntityDataBuilder builder;
	private EntityDataSource source;

}
