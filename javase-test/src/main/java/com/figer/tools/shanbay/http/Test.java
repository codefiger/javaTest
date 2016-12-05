package com.figer.tools.shanbay.http;


/**
 * Created by figer on 20/11/2016.
 */
public class Test {
  private String baseUrl = "https://www.shanbay.com";
  private String charset = "utf-8";
  private HttpClientUtil httpClientUtil = null;

  public Test(){
    httpClientUtil = new HttpClientUtil();
  }

  public void test(){

  }

  public static void main(String[] args){
    Test main = new Test();
    main.test();
  }
}
