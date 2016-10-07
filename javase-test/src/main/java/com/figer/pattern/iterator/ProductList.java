package com.figer.pattern.iterator;

import java.util.List;

/**
 * Created by figer on 07/10/2016.
 */
public class ProductList<A> extends AbstractList<A> {
  @Override
  public List<A> getRealList() {
    return list;
  }

  @Override
  public void add(A obj) {
    list.add(obj);
  }

  @Override
  public void remove(int index) {
    list.remove(index);
  }

  @Override
  public Iterator<A> createIterator() {
    return new ConcreteIterator<A>(this);
  }
}
