package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 21/05/2017.
 */
public class SortTest {
  public static void main(String[] args) {
    SortTemplate sortTemplate = new Insertion();
    String inputArray[] = {"z", "c", "h", "e", "b", "a"};
    System.out.println("before sorted:");
    sortTemplate.show(inputArray);

    /*sortTemplate.sort(inputArray);

    Preconditions.checkArgument(sortTemplate.isSorted(inputArray));

    System.out.println("after sorted:");
    sortTemplate.show(inputArray);*/
  }
}
