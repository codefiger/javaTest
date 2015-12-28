package com.zpeng.framework.logger;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestIdentityHolder {
	private static Logger logger = LoggerFactory.getLogger(RequestIdentityHolder.class);
	private static ThreadLocal<CallInfo> holder = new ThreadLocal<>();
	private static Random random = new Random();
	
	public static void init(){
		CallInfo callInfo = new CallInfo();
		callInfo.setTraceId(getTraceId());
		callInfo.setTime(new Date().getTime());
		holder.set(callInfo);
		org.slf4j.MDC.put("rpid", String.format("[rpid=%s]", callInfo.getTraceId()));
	}
	
	public static CallInfo get() {
        return holder.get();
    }
	
	public static void remove() {
        holder.remove();
        org.slf4j.MDC.remove("rpid");
    }
	
	/**
     * 此处设置只有一种情况，就是一个thrift请求进来之后，自己又起了一个线程来处理请求，即没有使用thrift的线程池。
     * <p/>
     * 特别说明：
     * <p/>
     * 如没有特别需求，别修改CallInfo中的信息，否者调用链信息不准确
     *
     * @param callinfo
     */
    public static void set(CallInfo callinfo) {
        holder.set(callinfo);
        org.slf4j.MDC.put("rpid", String.format("[rpid=%s]", callinfo.getTraceId()));
    }
	
	private static String getTraceId() {
		return String.format("%08x", random.nextInt());
	}
}
