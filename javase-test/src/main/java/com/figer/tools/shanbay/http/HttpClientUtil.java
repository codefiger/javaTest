package com.figer.tools.shanbay.http;

/**
 * Created by figer on 20/11/2016.
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.figer.utils.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientUtil {
  public CookieInstance cookieInstance;
  //private static ObjectMapper mapper = new ObjectMapper();

  //private static String basicCookieStr = "language_code=zh-CN; locale=zh-cn; userid=31497922; __utmt=1; sessionid=7oarepz92viz1j9zlcm25migy4untoju; csrftoken=8LDpq3khYjs9z37jooendkIg8xgVH2mF; __utma=183787513.1426756200.1479433580.1479564004.1479613298.5; __utmb=183787513.12.9.1479615174279; __utmc=183787513; __utmz=183787513.1479433580.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)";
  private static String basicCookieStr = "__utmt=1; locale=zh-cn; userid=31497922; csrftoken=M6AliHp2DAnW0jPn4SQmL1fjjgaQujUc; auth_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImZpZ2VycGVuZyIsImRldmljZSI6MCwiaXNfc3RhZmYiOmZhbHNlLCJpZCI6MzE0OTc5MjIsImV4cCI6MTQ4MTc3ODkyMn0.kdiivGgxugYUM_CVBdkj8iAQfyvZDhhz3ylT4O6WSeQ; sessionid=d4wrjdl82w90hm1kqc26yq2u8tp1ttxm; userid=31497922; __utma=183787513.1426756200.1479433580.1480911537.1480914923.16; __utmb=183787513.9.9.1480914939922; __utmc=183787513; __utmz=183787513.1479433580.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)";
  private static Map<String, String> cookieElementMap = new HashMap<>();

  public HttpClientUtil(){
    cookieInstance = new CookieInstance(basicCookieStr);
  }

  public String doPost(String url,Map<String,String> map,String charset){

    HttpUtil.init();

    HttpClient httpClient = null;
    HttpPost httpPost = null;
    String result = null;
    ByteArrayOutputStream baos = null;
    try{
      httpClient = new SSLClient();
      httpPost = new HttpPost(url);
      httpPost.setHeader("Referer", "https://www.shanbay.com/accounts/login/");
      httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
      httpPost.setHeader("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4,zh-TW;q=0.2");
      httpPost.setHeader("Cache-Control", "max-age=0");
      httpPost.setHeader("Connection", "keep-alive");
      //httpPost.setHeader("Content-Length", "118");
      httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
      httpPost.setHeader("Cookie", cookieInstance.getCookieStr());
      httpPost.setHeader("Host", "www.shanbay.com");
      httpPost.setHeader("Origin", "https://www.shanbay.com");
      httpPost.setHeader("Upgrade-Insecure-Requests", "1");
      httpPost.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.98 Safari/537.36");
      httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");

      //设置参数
      List<NameValuePair> list = new ArrayList<NameValuePair>();
      Iterator iterator = map.entrySet().iterator();
      while(iterator.hasNext()){
        Entry<String,String> elem = (Entry<String, String>) iterator.next();
        list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
      }
      if(list.size() > 0){
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
        httpPost.setEntity(entity);
      }

      HttpResponse response = httpClient.execute(httpPost);
      //System.out.println("========================");
      //System.out.println("response:" + response);
      baos = new ByteArrayOutputStream();
      int   i=-1;
      while((i=response.getEntity().getContent().read())!=-1){
        baos.write(i);
      }
      //System.out.println("========================:baos" + baos.toString());
      result = baos.toString();
      //CreateWordListResp resp = JsonUtil.fromJson(baos.toString(), CreateWordListResp.class);

      cookieInstance.updateCookie(response.getAllHeaders());
      baos.close();
    }catch(Exception ex){
      try {
        if(baos != null){
          baos.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      ex.printStackTrace();
    }
    return result;
  }

  public String delete(String url, String charset){
    HttpClient httpClient;
    HttpDelete httpDelete = new HttpDelete(url);
    String result = null;
    try{
      httpClient = new SSLClient();

      httpDelete.setHeader("Referer", "https://www.shanbay.com/accounts/login/");
      httpDelete.setHeader("Accept-Encoding", "gzip, deflate, br");
      httpDelete.setHeader("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4,zh-TW;q=0.2");
      httpDelete.setHeader("Cache-Control", "max-age=0");
      httpDelete.setHeader("Connection", "keep-alive");
      //httpPost.setHeader("Content-Length", "118");
      httpDelete.setHeader("Content-Type", "application/x-www-form-urlencoded");
      httpDelete.setHeader("Cookie", cookieInstance.getCookieStr());
      httpDelete.setHeader("Host", "www.shanbay.com");
      httpDelete.setHeader("Origin", "https://www.shanbay.com");
      httpDelete.setHeader("Upgrade-Insecure-Requests", "1");
      httpDelete.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.98 Safari/537.36");
      httpDelete.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");

      HttpResponse response = httpClient.execute(httpDelete);
      cookieInstance.updateCookie(response.getAllHeaders());
      if(response != null){
        HttpEntity resEntity = response.getEntity();
        if(resEntity != null){
          result = EntityUtils.toString(resEntity,charset);
        }
      }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return result;
  }

  public String doGet(String url,Map<String,String> map,String charset){
    HttpClient httpClient;
    HttpGet httpGet = new HttpGet(url);
    String result = null;
    try{
      httpClient = new SSLClient();

      httpGet.setHeader("Referer", "https://www.shanbay.com/accounts/login/");
      httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
      httpGet.setHeader("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4,zh-TW;q=0.2");
      httpGet.setHeader("Cache-Control", "max-age=0");
      httpGet.setHeader("Connection", "keep-alive");
      //httpPost.setHeader("Content-Length", "118");
      httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
      httpGet.setHeader("Cookie", cookieInstance.getCookieStr());
      httpGet.setHeader("Host", "www.shanbay.com");
      httpGet.setHeader("Origin", "https://www.shanbay.com");
      httpGet.setHeader("Upgrade-Insecure-Requests", "1");
      httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.98 Safari/537.36");
      httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");

      HttpResponse response = httpClient.execute(httpGet);
      cookieInstance.updateCookie(response.getAllHeaders());
      System.out.println("========================");
      System.out.println("response:" + response);
      System.out.println("========================");
      if(response != null){
        HttpEntity resEntity = response.getEntity();
        if(resEntity != null){
          result = EntityUtils.toString(resEntity,charset);
        }
      }
    }catch(Exception ex){
      ex.printStackTrace();
    }
    return result;
  }

}
