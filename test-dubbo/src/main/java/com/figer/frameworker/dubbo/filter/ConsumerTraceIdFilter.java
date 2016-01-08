package com.figer.frameworker.dubbo.filter;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

public class ConsumerTraceIdFilter implements Filter{

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		
		invocation.getAttachment("traceId", "traceId111111");
		System.out.println("traceId--------------");
		Result result = invoker.invoke(invocation);
		return result;
	}

}
