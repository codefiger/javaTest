package com.thrift.tutorial;

import java.util.Random;

import org.apache.thrift.TException;

import shared.SharedStruct;
import tutorial.Calculator;
import tutorial.InvalidOperation;
import tutorial.Work;
import tutorial.Calculator.Iface;

public class CalculatorHandler implements Calculator.Iface {

	@Override
	public SharedStruct getStruct(int key) throws TException {
		SharedStruct shareStruct = new SharedStruct(key, new Random().nextInt() + "");
		return shareStruct;
	}

	@Override
	public void ping() throws TException {
		System.out.println("ping");

	}

	@Override
	public int add(int num1, int num2) throws TException {
		return num1 + num2;
	}

	@Override
	public int calculate(int logid, Work w) throws InvalidOperation, TException {
		System.out.println("logid:" + logid);
		return w.getNum1() + w.getNum2();
	}

	@Override
	public void zip() throws TException {
		System.out.println("zip");
	}

}
