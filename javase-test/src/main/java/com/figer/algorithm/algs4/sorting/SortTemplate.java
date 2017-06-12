package com.figer.algorithm.algs4.sorting;

/**
 * Created by figer on 21/05/2017.
 */
public abstract class SortTemplate {
  protected Comparable copy[];

  public SortTemplate() {}

  public void sort(Comparable array[]){
    sort(array, 0, array.length - 1);
  }

  public abstract void sort(Comparable array[], int low, int high);

  public boolean less(Comparable a, Comparable b){
    return a.compareTo(b) < 0;
  }

  public void exch(Comparable array[], int i, int j){
    Comparable temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  private static final double X_BASE = 10;
  private static final double Y_BASE = 10;
  private static final double X_BASE_END = 90;
  private static final double Y_BASE_END = 90;
  public void show(Comparable array[]){
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();

    /*StdDraw.setYscale(0, 100);
    StdDraw.setXscale(0, 100);
    StdDraw.line(X_BASE, X_BASE,X_BASE_END,X_BASE);//x轴
    StdDraw.text(X_BASE_END, Y_BASE, X_BASE_END+"");
    StdDraw.line(X_BASE, X_BASE,X_BASE,Y_BASE_END);//y轴
    StdDraw.text(X_BASE, Y_BASE_END, Y_BASE_END + "");
    StdDraw.setPenColor(Color.red);

    for (int i = 0; i < array.length; i++) {
      double halfWidth = i/2;
      double halfHeight = i/2;
      StdDraw.rectangle(X_BASE + 4*i + halfWidth, Y_BASE + halfHeight, halfWidth, halfHeight);
      StdDraw.text(X_BASE + 4*i + halfWidth , Y_BASE, i + "");
      System.out.print(array[i] + " ");
    }*/
  }
  
  public boolean isSorted(Comparable array[]){
    for (int i = 1; i < array.length; i++) {
      if(less(array[i], array[i-1])){
        return false;
      }
    }
    return true;
  }

  public void merge(int low, int mid, int high, Comparable array[]){
    int leftIndex = low;
    int rightIndex = mid + 1;

    if(array[mid].compareTo(array[mid + 1]) <= 0){//右半边都小于左半边就不用merge了
      return;
    }

    for (int i = low; i <= high; i++) {
      copy[i] = array[i];
    }

    for (int i = low; i <= high; i++) {
      if(leftIndex > mid){
        array[i] = copy[rightIndex++];
      }else if(rightIndex > high){
        array[i] = copy[leftIndex++];
      }else if(less(copy[rightIndex], copy[leftIndex])){
        array[i] = copy[rightIndex++];
      }else{
        array[i] = copy[leftIndex++];
      }
    }
  }

  /**
   *
   * @param low
   * @param high
   * @param array
   * @return the partition index
   */
  public int partition(int low, int high, Comparable array[]){
    int left = low;
    int right = high + 1;
    Comparable partition = array[low];
    while (true){
      while (left < right - 1 && less(array[++left], partition));
      while (right > left - 1 && less(partition, array[--right]));

      if(left >= right){
        exch(array, low, right);
        break;
      }else{
        exch(array, left, right);
      }
    }
    return right;
  }
}
