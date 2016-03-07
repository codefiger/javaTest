package com.figer.webservice;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name="Business",serviceName="BusinessService",targetNamespace="http://com.figer.webService/client")
@SOAPBinding(style=SOAPBinding.Style.RPC)
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
