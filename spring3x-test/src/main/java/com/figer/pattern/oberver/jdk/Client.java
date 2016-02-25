package com.figer.pattern.oberver.jdk;

public class Client {
	public static void main(String[] args) {
		Watched watched = new Watched();
		Watcher watcher = new Watcher(watched);
		
		watched.setData("111");
		watched.setData("222");
		watched.setData("333");
	}
}
