package com.figer.tools.shanbay;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by figer on 21/11/2016.
 */
public class ShanbayController {

  public static void main(String[] args) {
    String userName = System.getProperty("userName");
    String password = System.getProperty("password");
    String wordBookId = System.getProperty("workBookId");

    if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(wordBookId)){
      throw new RuntimeException("please check userName, password, word book id!");
    }

    IShanbayService shanbayService = new ShanbayApi();
    long startTime = System.currentTimeMillis();
    shanbayService.createShanbayWordBook("/Users/figer/Downloads/The C Programming Language (Second Edition).pdf", wordBookId, userName, password);
    long endTime = System.currentTimeMillis();
    System.out.println("total use " + (endTime -startTime) + " ms" );
  }
}
