package com.figer.pattern.filter;

import com.figer.pattern.filter.bean.Request;
import com.figer.pattern.filter.bean.Response;

/**
 * Created by figer on 03/11/2016.
 */
public class IpFilter implements Filter {
  @Override
  public void doFilter(Request req, Response resp, FilterChain chain) {
    req.requestStr += "--IpFilter--";
    chain.doFilter(req, resp);
    resp.responseStr += "--IpFilter--";
  }
}
