package com.zpeng.thrift.test;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.zpeng.gen.thrift.service.Hello;

public class MyHelloThriftServer {
	public static final int simple_server_port = 2500;
	public static final int multi_thread_server_port = 2501;

	public static void main(String[] args) {

	}

	/**
	 * for a simple server
	 * @param processor
	 * @throws TTransportException
	 */
	private void simpleServer(Hello.Processor<Hello.Iface> processor) throws TTransportException {
		TServerTransport serverTransport = new TServerSocket(simple_server_port);
		TServer server = new TSimpleServer(new TSimpleServer.Args(serverTransport).processor(processor));

		System.out.println("Starting the simple server on " + simple_server_port);
		server.serve();
	}

	/**
	 *  for a multithreaded server
	 * 
	 * @param processor
	 * @throws TTransportException
	 */
	private void multithreadedServer(Hello.Processor<Hello.Iface> processor) throws TTransportException {
		TServerTransport serverTransport = new TServerSocket(multi_thread_server_port);
		TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

		System.out.println("Starting the multithreaded server on " + multi_thread_server_port);
		server.serve();
	}
}
