package com.figer.arithmetic.algs4.collections.api;

/**
 * Created by figer on 21/03/2017.
 */
public interface IStack<T> {
  void push(T t);
  T pop();
  boolean isEmpty();
  int size();
}
