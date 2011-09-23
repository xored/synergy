package com.xored.x5.server.core;

public interface ServerTransport {

	String getId();

	Session accept() throws Exception;

	void close();

}
