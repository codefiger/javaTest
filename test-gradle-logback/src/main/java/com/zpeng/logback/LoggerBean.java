package com.zpeng.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class LoggerBean {
	public static final Logger logger = LoggerFactory.getLogger(LoggerBean.class);
	
	public LoggerBean(){
		logger.trace("trace log content   ---");
		logger.debug("debug log content   ---");
		logger.info("info log content   ---");
		logger.warn("warn log content   ---");
		logger.error("error log content   ---");
		logger.info(MarkerFactory.getMarker("p2"), "value:{}", 1);
		logger.info(MarkerFactory.getMarker("marker has niao yong?"), "value:{}", 2);
		throw new RuntimeException();
	}
	
}
