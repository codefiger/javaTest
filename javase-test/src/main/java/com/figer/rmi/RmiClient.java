package com.figer.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {
	public static void main(String[] args) throws Exception{
		Registry registry = LocateRegistry.getRegistry("localhost");
		String name = "BusinessDemo";
		Business business = (Business) registry.lookup(name);
		business.echo("quit");
	}
}
