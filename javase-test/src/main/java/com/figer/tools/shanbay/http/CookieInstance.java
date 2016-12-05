package com.figer.tools.shanbay.http;

import org.apache.http.Header;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by figer on 20/11/2016.
 */
public class CookieInstance {
  private Map<String, String> cookieElementMap = new HashMap<>();

  public CookieInstance(String cookieStr) {
    initCookieElementMap(cookieStr);
  }

  public void updateCookie(Header[] headers){
    for (Header header : headers){
      if("Set-Cookie".equals(header.getName())){
        cookieElementMap.put(header.getValue().split("=")[0], header.getValue().split("=")[1]);
      }
    }
  }

  public String getCookieStr(){
    StringBuilder stringBuffer = new StringBuilder();

    String [] cookieKeyArray = new String[cookieElementMap.keySet().size()];
    cookieElementMap.keySet().toArray(cookieKeyArray);
    for (int i = 0; i < cookieKeyArray.length ; i++) {
      if(i != 0){
        stringBuffer.append(";");
      }
      stringBuffer.append(cookieKeyArray[i] + "=" + cookieElementMap.get(cookieKeyArray[i]));
    }

    return stringBuffer.toString();
  }

  public void initCookieElementMap(String cookieStr){
    String[] cookieElements = cookieStr.split(";");
    for (int i = 0; i < cookieElements.length; i++) {
      cookieElementMap.put(cookieElements[i].split("=")[0], cookieElements[i].split("=")[1]);
    }
  }
}
