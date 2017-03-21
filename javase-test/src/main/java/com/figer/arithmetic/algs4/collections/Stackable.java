package com.figer.arithmetic.algs4.collections;

/**
 * Created by figer on 21/03/2017.
 */
public interface Stackable<T> {
  void push(T t);
  T pop();
  boolean isEmpty();
  int size();
}
