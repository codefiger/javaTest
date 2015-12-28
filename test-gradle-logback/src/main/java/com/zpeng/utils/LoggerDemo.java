package com.zpeng.utils;

import java.util.Random;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

import com.zpeng.framework.logger.RequestIdentityHolder;
import com.zpeng.framework.thrift.protocol.ExtendedThriftProtocol;
import com.zpeng.logback.LoggerBean;
import com.zpeng.thrift.AdditionService;
import com.zpeng.thrift.MyServer;

public class LoggerDemo {
	/**
	 * logger logger1拿到的是同一 Logger实例
	 */
	public static final Logger logger = LoggerFactory.getLogger(LoggerDemo.class);
	public static final Logger logger1 = LoggerFactory.getLogger(LoggerDemo.class);
	
	public static void main(String[] args){
		RequestIdentityHolder.init();
		logger.trace("trace log content");
		logger.debug("debug log content");
		logger.info("info log content");
		logger.warn("warn log content");
		logger.error("error log content");
		logger.info("{},it's OK.","Hi");//参数化
		logger.info(MarkerFactory.getMarker("p2"), "value:{}", 1111);
		logger.info(MarkerFactory.getMarker("marker has niao yong?"), "value:{}", 22222);
		try {
			LoggerBean loggerBean = new LoggerBean();
		} catch (Exception e) {
			logger.warn("异常", e);
		}
		
		
		Random random = new Random();
		int randomNum = random.nextInt();
		System.out.println(randomNum);
		System.out.println(String.format("%08x", randomNum));
		
		
		try {  
			RequestIdentityHolder.get();
			
			TTransport transport = new TSocket("localhost", MyServer.PORT, 30 * 1000);
			transport.open();  
			
			//使用扩展的thrift协议 带traceId
			TProtocol protocol = new ExtendedThriftProtocol(new TFramedTransport(transport), true, true);
			AdditionService.Client client = new AdditionService.Client(protocol);  
	   
			logger.info("101+200 result:{}",client.add(101, 200));  
	   
			transport.close();  
		} catch (TTransportException e) {  
			logger.info("TTransportException", e);   
		} catch (TException x) {  
			logger.info("TTransportException", x);   
		}  
	}
}
