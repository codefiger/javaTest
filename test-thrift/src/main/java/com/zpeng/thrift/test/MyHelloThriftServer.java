package com.zpeng.thrift.test;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.zpeng.gen.thrift.service.Hello;
import com.zpeng.thrift.service.impl.HelloHandler;

public class MyHelloThriftServer {
	public static final int PORT = 2499;
	public static final int SIMPLE_SERVER_PORT = 2500;
	public static final int TNONBLOCKING_SERVER_PORT = 2501;
	public static final int THSHA_SERVER_PORT = 2502;
	public static final int TTHREADED_SELECTOR_SERVER_PORT = 2503;
	public static final int MULTI_THREAD_SERVER_PORT = 2504;

	public static void main(String[] args) {
		Hello.Processor<Hello.Iface> myProcessor = new Hello.Processor<Hello.Iface>(new HelloHandler());
		TServer tServer = null;
		String str = "";
		try {
			System.out.println(args[0]);
			if (args[0].equals(SIMPLE_SERVER_PORT + "")) {
				tServer = simpleServer(myProcessor);
				str = "SIMPLE_SERVER_PORT";
			}else if (args[0].equals(TNONBLOCKING_SERVER_PORT + "")) {
				tServer = tNonblockingServer(myProcessor);
				str = "TNONBLOCKING_SERVER_PORT";
			}else if (args[0].equals(THSHA_SERVER_PORT + "")) {
				tServer = tHsHaServer(myProcessor);
				str = "THSHA_SERVER_PORT";
			}else if (args[0].equals(TTHREADED_SELECTOR_SERVER_PORT + "")) {
				tServer = tThreadedSelectorServer(myProcessor);
				str = "TTHREADED_SELECTOR_SERVER_PORT";
			}else if (args[0].equals(MULTI_THREAD_SERVER_PORT + "")) {
				tServer = tThreadPoolServer(myProcessor);
				str = "MULTI_THREAD_SERVER_PORT";
			}
		} catch (TTransportException e) {
			e.printStackTrace();
		}
		
		System.out.println(str + " start!");
		tServer.serve();
	}

	/**
	 * for a simple server
	 * @param processor
	 * @throws TTransportException
	 */
	private static TServer simpleServer(Hello.Processor<Hello.Iface> processor) throws TTransportException {
		TServerTransport serverTransport = new TServerSocket(PORT);
		return new TSimpleServer(new TSimpleServer.Args(serverTransport).processor(processor));
	}

	/**
	 * @param processor
	 * @throws TTransportException
	 */
	private static TServer tNonblockingServer(Hello.Processor<Hello.Iface> processor) throws TTransportException {
		//TNonblockingServerTransport需要用TFramedTransport数据传输方式
		TNonblockingServerTransport trans = new TNonblockingServerSocket(PORT);
		TNonblockingServer.Args args = new TNonblockingServer.Args(trans)
				.transportFactory(new TFramedTransport.Factory())
				.protocolFactory(new TBinaryProtocol.Factory())
				.processor(processor);
		return  new TNonblockingServer(args);
	}
	
	private static TServer tHsHaServer(Hello.Processor<Hello.Iface> processor) throws TTransportException{
		 TNonblockingServerTransport trans = new TNonblockingServerSocket(PORT);
		 THsHaServer.Args args = new THsHaServer.Args(trans)
				 .transportFactory(new TFramedTransport.Factory())
				 .inputProtocolFactory(new TBinaryProtocol.Factory())
				 .processor(processor);
		 return new THsHaServer(args);
	}
	
	/**
	 * TThreadedSelectorServer它维护了两个线程池，一个用来处理网络I/O，另一个用来进行请求的处理
	 * @param processor
	 * @return
	 * @throws TTransportException
	 */
	private static TServer tThreadedSelectorServer(Hello.Processor<Hello.Iface> processor) throws TTransportException{
		 TNonblockingServerTransport trans = new TNonblockingServerSocket(PORT);
		 TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(trans)
				 .transportFactory(new TFramedTransport.Factory())
				 .inputProtocolFactory(new TBinaryProtocol.Factory())
				 .processor(processor)
				 .selectorThreads(4)//用来处理网络I/O
				 .workerThreads(32);//用来进行请求的处理
		 return new TThreadedSelectorServer(args);
	}
	
	/**
	 *  for a multithreaded server
	 *  1 有一个专用的线程用来接受连接
	 *  2 一旦接受了一个连接，它就会被放入ThreadPoolExecutor中的一个worker线程里处理
	 *  3 如果客户端数量超过了线程池中的最大线程数，在有一个worker线程可用之前，请求将被一直阻塞在那里
	 * @param processor
	 * @throws TTransportException
	 */
	private static TServer tThreadPoolServer(Hello.Processor<Hello.Iface> processor) throws TTransportException {
		TServerTransport serverTransport = new TServerSocket(PORT);
		TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport)
				 .transportFactory(new TFramedTransport.Factory())
				 .inputProtocolFactory(new TBinaryProtocol.Factory())
				 .processor(processor);
		return new TThreadPoolServer(args);
	}
}
