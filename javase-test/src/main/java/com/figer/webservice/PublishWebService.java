package com.figer.webservice;

import javax.xml.ws.Endpoint;
/**
 * 运行server（运行此类的main方法），然后在终端输入wsimport -keep http://localhost:9527/BusinessService\?wsdl生产客户端代码
 * @author figer
 *
 */
public class PublishWebService {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9527/BusinessService", new BusinessImpl());
		System.out.println("web service server has been started!");
	}
}
