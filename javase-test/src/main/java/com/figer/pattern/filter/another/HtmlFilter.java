package com.figer.pattern.filter.another;

/**
 * Created by figer on 03/11/2016.
 */
public class HtmlFilter implements Filter {
  @Override
  public void doFilter() {
    System.out.println("htmlFilter");
  }
}
