package com.figer.pattern.filter.another;

/**
 * Created by figer on 03/11/2016.
 */
public class AnotherFilterClient {
  public static void main(String[] args) {
    FilterChain filterChain = new FilterChain();
    Filter htmlFilter = new HtmlFilter();
    Filter scriptFilter = new ScriptFilter();
    filterChain.addFilter(htmlFilter).addFilter(scriptFilter);

    FilterChain anotherChain = new FilterChain();
    anotherChain.addFilter(htmlFilter).addFilter(filterChain).doFilter();
  }
}
