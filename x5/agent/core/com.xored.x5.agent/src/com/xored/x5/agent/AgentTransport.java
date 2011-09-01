package com.xored.x5.agent;

import org.eclipse.emf.ecore.EObject;

public interface AgentTransport {

	void connect();

	void close();

	EObject send(EObject data);

}
