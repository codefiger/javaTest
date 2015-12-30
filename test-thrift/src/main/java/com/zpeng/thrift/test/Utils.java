package com.zpeng.thrift.test;

public class Utils {
	public static void main(String[] args) {
		System.out.println(caculate(1451447077347L, 1451447081359L));
	}

	public static String caculate(long num1,long num2){
		return "" + (num2 - num1);
	}
}
