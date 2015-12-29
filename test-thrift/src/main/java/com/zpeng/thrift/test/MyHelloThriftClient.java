package com.zpeng.thrift.test;

import java.io.IOException;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.zpeng.gen.thrift.service.Hello;
import com.zpeng.gen.thrift.service.Hello.AsyncClient.helloString_call;
import com.zpeng.thrift.service.impl.HelloMethodCallback;

public class MyHelloThriftClient {
	public static void main(String[] args) {
		asynClient();
	}

	private static void simpleClient() {
		TTransport transport = new TSocket("localhost", MyHelloThriftServer.PORT);
		try {
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			Hello.Client client = new Hello.Client(protocol);
			client.helloVoid();
			System.out.println(client.helloInt(11));
			client.helloNull();
		} catch (TException e) {
			// 处理服务返回值为 null
			if (e instanceof TApplicationException
					&& ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT) {
				System.out.println("The result of helloNull function is NULL");
			} else {
				e.printStackTrace();
			}
		}
	}

	private static void nonblockingClient() {
		TTransport transport = new TSocket("localhost", MyHelloThriftServer.PORT);
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

	private static void asynClient() {
		try {
			TAsyncClientManager clientManager = new TAsyncClientManager();
			TNonblockingTransport transport = new TNonblockingSocket("localhost", MyHelloThriftServer.PORT);
			TProtocolFactory protocol = new TBinaryProtocol.Factory();
			Hello.AsyncClient asyncClient = new Hello.AsyncClient(protocol, clientManager, transport);
			System.out.println("Client calls .....");

			asyncClient.helloString("Hello World 111", new AsyncMethodCallback<Hello.AsyncClient.helloString_call>() {

				@Override
				public void onError(Exception exception) {
					System.out.println("...");
					System.out.println(exception);
				}

				@Override
				public void onComplete(helloString_call response) {
					System.out.println("onComplete");
					try {
						System.out.println(response.getResult());
					} catch (TException e) {
						e.printStackTrace();
					}
				}
			});
			
			Thread.sleep(1000);
		

		} catch (IOException | TException | InterruptedException e) {
			e.printStackTrace();
		} 
	}

}
