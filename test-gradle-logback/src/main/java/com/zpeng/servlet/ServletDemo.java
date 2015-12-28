package com.zpeng.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zpeng.common.Constants;
import com.zpeng.thrift.AdditionService;
import com.zpeng.thrift.MyServer;

/**
 * 好久没写过servelt,jsp，重温下
 * mapping url : testServelt
 * @author peng.zhang
 *
 */
public class ServletDemo extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(ServletDemo.class);
	private static final Logger performance_logger = LoggerFactory.getLogger(Constants.PERFORMANCE_LOGGER_NAME);

	private static final long serialVersionUID = 8637112013021873834L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("testServlet service.");
		performance_logger.info("开始：{}", new Date());
		long startTimesatmp = System.currentTimeMillis();
		
		try {  
			TTransport transport = new TSocket("localhost", MyServer.PORT);  
			transport.open();  
	   
			TProtocol protocol = new TBinaryProtocol(transport);  
			AdditionService.Client client = new AdditionService.Client(protocol);  
	   
			logger.info("101+200 result:{}",client.add(101, 200));  
	   
			transport.close();  
		} catch (TTransportException e) {  
			e.printStackTrace();  
		} catch (TException x) {  
			x.printStackTrace();  
		}  
		
		request.setAttribute("name", "figer");
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		performance_logger.info("结束：{}ms", System.currentTimeMillis() - startTimesatmp);
	}

	@Override
	public void destroy() {
		logger.debug("testServlet destroy.");
	}

	@Override
	public void init() throws ServletException {
		logger.debug("testServlet init.");
	}

}
