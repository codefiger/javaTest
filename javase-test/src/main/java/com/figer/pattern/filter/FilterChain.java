package com.figer.pattern.filter;

import com.figer.pattern.filter.bean.Request;
import com.figer.pattern.filter.bean.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 03/11/2016.
 */
public class FilterChain {

  private List<Filter> filterList = new ArrayList<Filter>();
  private int index = 0;

  public FilterChain addFilter(Filter filter){
    this.filterList.add(filter);
    return this;
  }

  public void doFilter(Request req, Response resp) {
    if(index == filterList.size()){
      return;
    }

    Filter f = filterList.get(index++);
    f.doFilter(req, resp, this);
  }
}
