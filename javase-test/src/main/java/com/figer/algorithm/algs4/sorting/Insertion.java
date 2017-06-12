package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 21/05/2017.
 */
public class Insertion extends SortTemplate {

  @Override
  public void sort(Comparable[] array, int low, int high) {
    for (int i = low + 1; i < high + 1; i++) {
      for (int j = i; j > low && less(array[j] , array[j - 1]); j--) {
        exch(array, j, j - 1);
      }
    }
  }
}
