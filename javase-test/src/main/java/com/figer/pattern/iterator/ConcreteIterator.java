package com.figer.pattern.iterator;

import java.util.ConcurrentModificationException;

/**
 * Created by figer on 07/10/2016.
 */
public class ConcreteIterator<A> implements Iterator<A> {
  private AbstractList<A> list;
  private int cursor;
  private int size;

  public ConcreteIterator(AbstractList<A> list) {
    this.list = list;
    this.size = list.size();
  }

  @Override
  public A next() {
    if(size != list.size()){
      throw new ConcurrentModificationException("");
    }

    if(cursor < list.getRealList().size())
      return list.getRealList().get(cursor++);
    return null;
  }

  @Override
  public boolean hasNext() {
    return !list.getRealList().isEmpty() && cursor < list.getRealList().size();
  }
}
