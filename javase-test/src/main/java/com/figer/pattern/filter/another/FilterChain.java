package com.figer.pattern.filter.another;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 03/11/2016.
 */
public class FilterChain implements Filter {
  private List<Filter> filterList = new ArrayList<Filter>();

  public FilterChain addFilter(Filter filter){
    filterList.add(filter);
    return this;
  }

  @Override
  public void doFilter() {
    for (Filter filter : filterList){
      filter.doFilter();
    }
  }
}
