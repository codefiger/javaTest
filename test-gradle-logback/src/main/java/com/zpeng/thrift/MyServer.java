package com.zpeng.thrift;

import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpeng.framework.thrift.protocol.ExtendedThriftProtocolFactory; 
   
/**
 * a simple server,start first
 * @author peng.zhang
 *
 */
public class MyServer { 
	private static final Logger logger = LoggerFactory.getLogger(MyServer.class);
	public static final int PORT = 9010;
	
	public static void StartsimpleServer(AdditionService.Processor<AdditionServiceHandler> processor) { 
		try { 
			TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(PORT); 
			
			//使用自定义thrift传输协议 带有traceId
			TThreadedSelectorServer.Args serverArgs = new TThreadedSelectorServer.Args(serverTransport)
							                    .inputTransportFactory(new TFramedTransport.Factory())
							                    .outputTransportFactory(new TFramedTransport.Factory())
							                    .inputProtocolFactory(new ExtendedThriftProtocolFactory(true, true, 64*1024))
							                    .outputProtocolFactory(new ExtendedThriftProtocolFactory(true, true, 64*1024))
							                    .processor(processor)
							                    .selectorThreads(2);
			
			TThreadedSelectorServer server = new TThreadedSelectorServer(serverArgs);
		   
		    // Use this for a multithreaded server 
		    // TServer server = new TThreadPoolServer(new 
		    // TThreadPoolServer.Args(serverTransport).processor(processor)); 
		   
		    logger.info("Starting the simple server..."); 
		    logger.info("Start successful!"); 
		    server.serve();
		    
	    } catch (Exception e) { 
		    e.printStackTrace(); 
	    } 
	 } 
    
	 public static void main(String[] args) { 
		 StartsimpleServer(new AdditionService.Processor<AdditionServiceHandler>(new AdditionServiceHandler())); 
	 } 
   
}