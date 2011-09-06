package com.xored.x5.agent;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.DataSourceFactory;

public interface Transport {

	void send(String id, EObject data);

	void attach(DataSourceFactory factory);

	void detach(DataSourceFactory factory);

}
