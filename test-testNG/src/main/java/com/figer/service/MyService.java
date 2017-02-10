package com.figer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by figer on 07/02/2017.
 */
@Service
public class MyService {
  private static final Logger logger = LoggerFactory.getLogger("log");
  public void print(String logText){
    logger.info("{}", logText);
  }
}
