package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 01/06/2017.
 */
public class Shell extends SortTemplate{

  @Override
  public void sort(Comparable[] array, int low, int high) {
    final int factor = 2;
    for (int gap = (high-low)/factor; gap > 0; gap /= factor) {
      for (int i = gap; i <= high; i++) {
        for (int j = i; j >= gap && less(array[j] , array[j - gap]); j -= gap) {
          exch(array, j, j - gap);
        }
      }
    }
  }
}
