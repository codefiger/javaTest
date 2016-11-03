package com.figer.pattern.filter;

import com.figer.pattern.filter.bean.Request;
import com.figer.pattern.filter.bean.Response;

/**
 * Created by figer on 03/11/2016.
 */
public class FilterClient {
  public static void main(String[] args) {
    FilterChain chain = new FilterChain();

    Request request = new Request();
    Response response = new Response();

    chain.addFilter(new HtmlFilter()).addFilter(new ScriptFilter()).addFilter(new IpFilter()).doFilter(request, response);
    System.out.println(request.requestStr);
    System.out.println(response.responseStr);
  }
}
