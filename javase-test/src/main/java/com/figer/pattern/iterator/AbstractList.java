package com.figer.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 07/10/2016.
 */
public abstract class AbstractList<A> {
  protected List<A> list = new ArrayList<A>();

  public abstract List<A> getRealList();
  public abstract void add(A obj);
  public abstract void remove(int index);
  public abstract Iterator<A> createIterator();
}
