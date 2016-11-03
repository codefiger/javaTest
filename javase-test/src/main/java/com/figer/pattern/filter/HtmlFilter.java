package com.figer.pattern.filter;

import com.figer.pattern.filter.bean.Request;
import com.figer.pattern.filter.bean.Response;

/**
 * Created by figer on 03/11/2016.
 */
public class HtmlFilter implements Filter {
  @Override
  public void doFilter(Request req, Response resp, FilterChain chain) {
    req.requestStr += "--HtmlFilter--";
    chain.doFilter(req, resp);
    resp.responseStr += "--HtmlFilter--";
  }
}
