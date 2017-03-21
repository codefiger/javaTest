package com.figer.arithmetic.algs4.collections;

/**
 * Created by figer on 21/03/2017.
 */
public interface Queue<T> {
  void enqueue(T t);
  T dequeue();
  boolean isEmpty();
  int size();
}
