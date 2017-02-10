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
    shanbayService.createShanbayWordBook("/Users/figer/Library/Containers/com.tencent.xinWeChat/Data/Library/Application Support/com.tencent.xinWeChat/2.0b4.0.9/2f572a9b4d3ccd15af6730a8aa281fc6/Message/MessageTemp/e09accae4177960ed90470b455d17e10/File/经济学人词频/The Economist.txt", wordBookId, userName, password);
    long endTime = System.currentTimeMillis();
    System.out.println("total use " + (endTime -startTime) + " ms" );
  }
}
