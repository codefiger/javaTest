package com.figer.cxf;

import javax.jws.WebService;

@WebService(serviceName="BusinessService",endpointInterface="com.figer.cxf.Business")
public class BusinessImpl implements Business {

	@Override
	public String echo(String message) {
		if ("quit".equalsIgnoreCase(message)) {
			System.out.println("server will shutdown!");
			System.exit(0);
		}
		System.out.println("Message from client:" + message);
		return "Server response:" + message;
	}

}
