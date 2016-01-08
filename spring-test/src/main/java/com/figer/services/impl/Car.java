package com.figer.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.figer.services.Movable;

public class Car implements Movable {
	private static final Logger LOGGER = LoggerFactory.getLogger(Car.class);

	@Override
	public void move() {
		LOGGER.info("moving...");
	}

}
