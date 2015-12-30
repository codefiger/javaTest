package com.zpeng.thrift.service.impl;
import java.util.List;

import org.apache.thrift.TException;

import com.zpeng.gen.thrift.pojo.Emotion;
import com.zpeng.gen.thrift.service.Hello;

public class HelloHandler implements Hello.Iface{

	@Override
	public String helloString(String str) throws TException {
		
		long starttime = System.currentTimeMillis();
		
		System.out.println("invoke helloString:" + str + ",starttime:" + starttime);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("invoke helloString:" + str + ",end time:" + System.currentTimeMillis());
		return str + starttime;
	}

	@Override
	public int helloInt(int para) throws TException {
		return para;
	}

	@Override
	public boolean helloBoolean(boolean para) throws TException {
		return para;
	}

	@Override
	public void helloVoid() throws TException {
		System.out.println("helloVoid()");
	}

	@Override
	public String helloNull() throws TException {
		System.out.println("helloNull()");
		return null;
	}

	@Override
	public List<String> helloList(List<String> helloStrList) throws TException {
		return helloStrList;
	}

	@Override
	public Emotion helloStruct(Emotion emotion) throws TException {
		return emotion;
	}

}
