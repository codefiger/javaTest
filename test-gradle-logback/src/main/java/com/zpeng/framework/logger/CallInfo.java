package com.zpeng.framework.logger;

import java.util.ArrayList;

public class CallInfo {
	private String traceId;//request unique id
	private ArrayList<Long> times = new ArrayList<>();//call time

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public ArrayList<Long> getTimes() {
		return times;
	}

	public void setTime(long times) {
		this.times.add(times);
	}
}
