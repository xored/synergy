package com.xored.x5.server.core;

public interface ServerTransport {

	Session accept() throws Exception;

	void close();

}
