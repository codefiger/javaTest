package com.figer.algorithm.algs4.sorting;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by figer on 31/05/2017.
 */
public class SortCompare {
  public static void main(String[] args) {
    String alg0 = args[0];
    String alg1 = args[1];

    int arrayLength = Integer.parseInt(args[2]);
    int times = Integer.parseInt(args[3]);

    long t0 = multiTestTime(alg0, arrayLength, times);
    long t1 = multiTestTime(alg1, arrayLength, times);
    System.out.println(String.format("For %d random Doubles %s is %.3f times faster than %s", arrayLength, alg0, t1*1.0/t0, alg1));
  }

  private static long multiTestTime(String algName, int arrayLength, int times) {
    long total = 0;
    for (int i = 0; i < times; i++) {
      Double randomArray[] = new Double[arrayLength];
      for (int j = 0; j < arrayLength; j++) {
        randomArray[j] = ThreadLocalRandom.current().nextDouble();
      }

      total = total + time(algName, randomArray);
    }
    return total;
  }

  private static long time(String alg, Double[] a) {
    long startTime = System.nanoTime();
    if (alg.equals("Insertion")) new Insertion().sort(a);
    if (alg.equals("Selection")) new Selection().sort(a);
    if (alg.equals("Shell")) new Shell().sort(a);
    if (alg.equals("Merge")) new Merge().sort(a);
    /*if (alg.equals("Quick"))Quick.sort(a);
    if (alg.equals("Heap"))Heap.sort(a);*/
    return System.nanoTime() - startTime;
  }


}
