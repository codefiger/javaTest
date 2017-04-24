package com.figer.pattern.observer.jdk;

public class Client {
	public static void main(String[] args) {
		Watched watched = new Watched();
		new Watcher(watched, "小明");
    new Watcher(watched, "小王");
    new Watcher(watched, ":)");

		watched.setData("111");
		watched.setData("222");
		watched.setData("333");
	}
}
