package com.figer.threadlocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.figer.entity.User;

public class MyThread implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyThread.class);
	
	private User user;
	
	public MyThread(User user) {
		this.user = user;
	}

	@Override
	public void run() {
		int i = 0;
		while(i++ <= 10){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				LOGGER.error("", e);
			}
			LOGGER.info("user.id:{}", user.getId());
			//System.out.println("user.id:" + user.getId());
		}
	}

}
