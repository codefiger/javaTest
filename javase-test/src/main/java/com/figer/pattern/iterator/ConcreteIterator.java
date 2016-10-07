package com.figer.pattern.iterator;

/**
 * Created by figer on 07/10/2016.
 */
public class ConcreteIterator<A> implements Iterator<A> {
  private AbstractList<A> list;
  private int cursor;

  public ConcreteIterator(AbstractList<A> list) {
    this.list = list;
  }

  @Override
  public A next() {
    if(cursor < list.getRealList().size())
      return list.getRealList().get(cursor++);
    return null;
  }

  @Override
  public boolean hasNext() {
    return !list.getRealList().isEmpty() && cursor < list.getRealList().size();
  }
}
