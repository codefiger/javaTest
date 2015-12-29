package com.zpeng.thrift.test;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.zpeng.gen.thrift.service.Hello;



public class MyHelloThriftClient {
	public static void main(String[] args) {
		simpleClient();
	}
	
	private static void simpleClient(){
		TTransport transport = new TSocket("localhost",MyHelloThriftServer.PORT); 
		try {
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);  
			Hello.Client client = new Hello.Client(protocol); 
			client.helloVoid();
			System.out.println(client.helloInt(11));
			client.helloNull();
		} catch (TException e) {
			//处理服务返回值为 null
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT) { 
                System.out.println("The result of helloNull function is NULL"); 
            } else{
            	e.printStackTrace();
            }
		}
	}
	
	private static void nonblockingClient(){
		TTransport transport = new TSocket("localhost",MyHelloThriftServer.PORT);  
		transport = new TFramedTransport(transport); 
		try {
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);  
			Hello.Client client = new Hello.Client(protocol); 
			client.helloVoid();
			client.helloNull();
			System.out.println(client.helloInt(11));
		} catch (TException e) {
			e.printStackTrace();
		}
	}
	
}
