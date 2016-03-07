package com.figer.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BusinessServer implements Business{

	@Override
	public String echo(String message) throws RemoteException {
		if ("quit".equalsIgnoreCase(message)) {
			System.out.println("server will shutdown!");
			System.exit(0);
		}
		System.out.println("Message from client:" + message);
		return "Server response:" + message;
	}
	
	public static void main(String[] args) throws Exception{
		int port = 9527;
		String name = "BusinessDemo";
		
		Business business = new BusinessServer();
		
		UnicastRemoteObject.exportObject(business, port);
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind(name, business);
	}

}
