package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 21/05/2017.
 */
public class SortTest {
  public static void main(String[] args) {
    SortTemplate sortTemplate = new SelectSort();
    String inputArray[] = {"z", "c", "h", "e", "b", "a"};
    System.out.println(sortTemplate.isSorted(inputArray));

    sortTemplate.sort(inputArray);

    System.out.println(sortTemplate.isSorted(inputArray));

    sortTemplate.show(inputArray);
  }
}
