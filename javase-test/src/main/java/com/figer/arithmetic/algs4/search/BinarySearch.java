package com.figer.arithmetic.algs4.search;

/**
 * Created by figer on 06/03/2017.
 */
public class BinarySearch {
  public static int rank(int key, int[] a){
    //a must be sorted
    int lowIndex = 0;
    int highIndex = a.length - 1;
    if(key < a[lowIndex] || key > a[highIndex]){
      return -1;
    }

    int middle = -1;
    while (lowIndex <= highIndex){
      middle = lowIndex + (highIndex - lowIndex)/2;
      if(key > a[middle]){
        lowIndex = middle + 1;
      }else if(key < a[middle]){
        highIndex = middle - 1;
      }else{
        return middle;
      }
    }
    return middle;
  }

  public static void main(String args[]){
    int[] a = {1,3,5,7,9,10};
    System.out.println(rank(10, a));
  }
}
