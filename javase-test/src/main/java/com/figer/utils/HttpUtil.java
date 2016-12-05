package com.figer.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

  private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

  private static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
  private static String DEFAULT_ENCODE;
  private static HttpClient client;
  private static HttpConnectionManager connectionManager;
  private static AtomicInteger requestIndex = new AtomicInteger(0);

  static {
    HttpConnectionManagerParams params = loadConfFromFile();
    connectionManager = new MultiThreadedHttpConnectionManager();
    connectionManager.setParams(params);

    client = new HttpClient(connectionManager);
}

private static HttpConnectionManagerParams loadConfFromFile() {
    Properties p = new Properties();
    try {
      p.load(HttpUtil.class.getClassLoader().getResourceAsStream("config/httputil.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    DEFAULT_ENCODE = p.getProperty("http.content.encoding");
    
    HttpConnectionManagerParams params = new HttpConnectionManagerParams();
    params.setConnectionTimeout(Integer.parseInt(p.getProperty("http.connection.timeout")));
    params.setSoTimeout(Integer.parseInt(p.getProperty("http.so.timeout")));
    params.setStaleCheckingEnabled(Boolean.parseBoolean(p.getProperty("http.stale.check.enabled")));
    params.setTcpNoDelay(Boolean.parseBoolean(p.getProperty("http.tcp.no.delay")));
    params.setDefaultMaxConnectionsPerHost(Integer.parseInt(p.getProperty("http.default.max.connections.per.host")));
    params.setMaxTotalConnections(Integer.parseInt(p.getProperty("http.max.total.connections")));
    params.setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
    return params;
}
  public static void init() {
    client.getHttpConnectionManager().getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
  }

  public static String post(String url, String encoding, String content, String contentType) {
    try {
      byte[] resp = post(url, content.getBytes(encoding), contentType);
      if (null == resp) {
        return null;
      }
      return new String(resp, encoding);
    } catch (UnsupportedEncodingException e) {
      return null;
    }
  }

  public static String post(String url, String content) {
    return post(url, DEFAULT_ENCODE, content, DEFAULT_CONTENT_TYPE);
  }

  public static byte[] post(String url, byte[] content) {
    return post(url, content, DEFAULT_CONTENT_TYPE);
  }

  public static byte[] post(String url, byte[] content, String contentType) {
    try {
      byte[] ret = post(url, new ByteArrayRequestEntity(content), contentType);
      return ret;
    } catch (Exception e) {
      throw new RuntimeException("Http post exception", e);
    }
  }

  public static byte[] post(String url, RequestEntity requestEntity) throws Exception {
    return post(url, requestEntity, DEFAULT_CONTENT_TYPE);
  }

  public static byte[] post(String url, RequestEntity requestEntity, String contentType) throws Exception {

    PostMethod method = new PostMethod(url);
    method.addRequestHeader("Connection", "Keep-Alive");
    method.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
    method.setRequestEntity(requestEntity);
    method.addRequestHeader("Content-Type", contentType);

    String requestId = System.currentTimeMillis() + "_" + requestIndex.incrementAndGet();
    byte[] result = null;
    boolean haveException = true;
    try {
      logger.debug("httpUtil post request start : [ id : {}] [ url : {} ] [ requestEntity : {} ]", requestId, url, requestEntity);
      int statusCode = client.executeMethod(method);
      if (statusCode != HttpStatus.SC_OK) {
        logger.warn("Http response status is not OK [ statusCode : {}] [id :{} ]", statusCode, requestId);
        return null;
      }
      result = method.getResponseBody();
      haveException = false;
      return result;

    } finally {
      method.releaseConnection();
      if (logger.isDebugEnabled()) {
        logger.debug("httpUtil post request end : [ id : {}] [ url : {} ] [ result : {} ] [ withError: {} ]", requestId, url, result != null ? new String(result) : null,
            haveException);
      }
    }
  }

  public static String getAsString(String url) {
    try {
      return new String(get(url), DEFAULT_ENCODE);
    } catch (Exception e) {
      logger.warn("Catch exception while get method to url[" + url + "]", e);
      // ignore
    }

    return null;
  }

  public static byte[] get(String url) {

    client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);

    // 创建GET方法的实例
    GetMethod method = new GetMethod(url);
    String requestId = System.currentTimeMillis() + "_" + requestIndex.decrementAndGet();
    byte[] result = null;
    boolean haveException = true;
    try {
      logger.debug("httpUtil post request start : [ id : {}] [ url : {} ]", requestId, url);
      int statusCode = client.executeMethod(method);
      if (statusCode != HttpStatus.SC_OK) {
        logger.warn("Http response status is not OK [" + statusCode + "]");
        return null;
      }
      result = method.getResponseBody();
      haveException = false;
      return result;
    } catch (Exception e) {
      logger.warn("Catch exception while get to url [" + url + "]", e);
      return null;
    } finally {
      method.releaseConnection();
      if (logger.isDebugEnabled()) {
        logger.debug("httpUtil post request end : [ id : {}] [ url : {} ] [ result : {} ] [ withError: {} ]", requestId, url, result != null ? new String(result) : null,
            haveException);
      }
    }
  }
  
  public static void main(String[] args) {
    System.out.println(getAsString("http://www.dianrong.com/api/v2/payment/fastpay/getBankNameByCard?cardBin=6259980005238181"));
  }

}
