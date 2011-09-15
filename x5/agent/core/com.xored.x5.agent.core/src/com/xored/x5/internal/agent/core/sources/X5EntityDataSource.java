package com.xored.x5.internal.agent.core.sources;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EntityDataSource;

public class X5EntityDataSource implements EntityDataSource, X5DataSource {

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

	@Override
	public void addDataListener(X5DataListener listener) {
		builder.addDataListener(listener);
	}

	@Override
	public void removeDataListener(X5DataListener listener) {
		builder.removeDataListener(listener);
	}

	private EntityDataBuilder builder;
	private EntityDataSource source;

}
