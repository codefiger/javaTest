package com.figer.algorithm.algs4.collections.api;

/**
 * Created by figer on 21/03/2017.
 */
public interface IQueue<T> {
  void enqueue(T t);
  T dequeue();
  boolean isEmpty();
  int size();
}
