package com.figer.algorithm.algs4.sorting;

import com.google.common.base.Preconditions;

/**
 * Created by figer on 21/05/2017.
 */
public class SortTest {
  public static void main(String[] args) {
    SortTemplate sortTemplate = new Selection();
    String inputArray[] = {"z", "c", "h", "e", "b", "a", "a", "z", "c"};
    System.out.println("before sorted:");
    sortTemplate.show(inputArray);

    sortTemplate.sort(inputArray);

    Preconditions.checkArgument(sortTemplate.isSorted(inputArray));

    System.out.println("after sorted:");
    sortTemplate.show(inputArray);
  }
}
