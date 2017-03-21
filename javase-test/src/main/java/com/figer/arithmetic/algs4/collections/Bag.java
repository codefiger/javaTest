package com.figer.arithmetic.algs4.collections;

import com.figer.arithmetic.algs4.collections.api.IBag;

import java.util.Iterator;

/**
 * Created by figer on 21/03/2017.
 */
public class Bag<T> implements IBag<T>,Iterable<T>{
  private Node<T> first;

  @Override
  public void add(T t) {
    Node<T> oldFirst = first;
    first = new Node<>();
    first.value = t;
    first.next = oldFirst;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  private T pop(){
    Node<T> oldFirst = first;
    first = first.next;
    return oldFirst.value;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      @Override
      public boolean hasNext() {
        //TODO
        return !isEmpty();
      }

      @Override
      public T next() {
        return pop();
      }
    };
  }
}
