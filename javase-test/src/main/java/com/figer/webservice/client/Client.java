package com.figer.webservice.client;

public class Client {
	public static void main(String[] args) {
		BusinessService businessService = new BusinessService();
		Business business = businessService.getBusinessPort();
		business.echo("quit");
	}
}
