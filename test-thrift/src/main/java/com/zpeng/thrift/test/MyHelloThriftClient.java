package com.zpeng.thrift.test;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

public class MyHelloThriftClient {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int taskSize = 200;

		long starttime = System.currentTimeMillis();
		//启动多个client
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		for (int i = 0; i < taskSize; i++) {
			System.out.println(i);
			Callable helloStrClient = new HelloStrCallable("hello" + i); // 执行任务
																			// Future
			pool.submit(helloStrClient);
		}
		pool.shutdown();
		System.out.println( "time:" + (System.currentTimeMillis() - starttime));

		/*for (int i = 0; i < taskSize; i++) {
			long starttime = System.currentTimeMillis();
			System.out.println("starttime:" + starttime);
			nonblockingClient("hello " + i);
			System.out.println("time:" + (System.currentTimeMillis() - starttime));
		}*/
	}

	public static String simpleClient(String str) {
		TTransport transport = new TSocket("localhost", MyHelloThriftServer.PORT);
		try {
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			Hello.Client client = new Hello.Client(protocol);
			String callBackstr = client.helloString(str);
			transport.close();
			return callBackstr;
		} catch (TException e) {
			// 处理服务返回值为 null
			if (e instanceof TApplicationException
					&& ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT) {
				System.out.println("The result of helloNull function is NULL");
			} else {
				e.printStackTrace();
			}
		}
		return "error";
	}

	/**
	 *  using TFramedTransport on the client
	 * @param str
	 * @return
	 */
	public static String nonblockingClient(String str) {
		TTransport transport = new TSocket("localhost", MyHelloThriftServer.PORT);
		transport = new TFramedTransport(transport);
		try {
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			Hello.Client client = new Hello.Client(protocol);
			String backStr = client.helloString(str);
			transport.close();
			return backStr;
		} catch (TException e) {
			e.printStackTrace();
		}
		return "error";
	}

	public static void asynClient() {
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

class HelloStrCallable implements Callable<String> {
	private String helloStr;

	public HelloStrCallable() {

	}

	public HelloStrCallable(String helloStr) {
		this.helloStr = helloStr;
	}

	@Override
	public String call() throws Exception {
		MyHelloThriftClient.nonblockingClient(helloStr);
		return null;
	}

}
