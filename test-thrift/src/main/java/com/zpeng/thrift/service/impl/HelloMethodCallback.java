package com.zpeng.thrift.service.impl;

import org.apache.thrift.async.AsyncMethodCallback;

import com.zpeng.gen.thrift.service.Hello;
import com.zpeng.gen.thrift.service.Hello.AsyncClient.helloString_call;

public class HelloMethodCallback implements AsyncMethodCallback<Hello.AsyncClient.helloString_call>{
	private helloString_call response;
	
	public helloString_call getResponse(){
		return this.response;
	}

	@Override
	public void onComplete(helloString_call response) {
		this.response = response;
	}

	@Override
	public void onError(Exception exception) {
		System.out.println(exception);
	}
}
