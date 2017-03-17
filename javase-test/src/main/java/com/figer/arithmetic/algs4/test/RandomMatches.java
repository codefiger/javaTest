package com.figer.arithmetic.algs4.test;

import com.figer.arithmetic.algs4.search.BinarySearch;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by figer on 17/03/2017.
 */
public class RandomMatches {

  private int runTimes;
  private int a1[] = new int[1000];
  private int a2[] = new int[1000];
  private int aRecord[] = new int[]{1000, 0};

  private int b1[] = new int[10000];
  private int b2[] = new int[10000];
  private int bRecord[] = new int[]{10000, 0};

  private int c1[] = new int[100000];
  private int c2[] = new int[100000];
  private int cRecord[] = new int[]{100000, 0};

  private int d1[] = new int[1000000];
  private int d2[] = new int[1000000];
  private int dRecord[] = new int[]{1000000, 0};

  public RandomMatches(int runTimes) {
    this.runTimes = runTimes;
  }

  public void run(){
    initData(a1, a2, b1, b2, c1, c2, d1, d2);

    for (int i = 0; i < runTimes; i++) {
      countMatchInArrays(aRecord, a1, a2);
      countMatchInArrays(bRecord, b1, b2);
      countMatchInArrays(cRecord, c1, c2);
      countMatchInArrays(dRecord, d1, d2);
    }
    printResult();
  }

  public void printResult(){
    System.out.println(aRecord[0] + " : " + ((double)aRecord[1]/runTimes));
    System.out.println(bRecord[0] + " : " + ((double)bRecord[1]/runTimes));
    System.out.println(cRecord[0] + " : " + ((double)cRecord[1]/runTimes));
    System.out.println(dRecord[0] + " : " + ((double)dRecord[1]/runTimes));
  }

  private void initData(int[] ... arrays){
    for (int i = 0; i < arrays.length; i++) {
      for (int j = 0; j < arrays[i].length; j++) {
        arrays[i][j] = getRandomNum();
      }
    }
  }

  private void countMatchInArrays(int record[], int a[], int b[]){
    for (int i = 0; i < a.length; i++) {
      if(BinarySearch.rank(a[i], b) != -1){
        record[1] ++;
      }
    }
  }

  private int getRandomNum(){
    return ThreadLocalRandom.current().nextInt(100000, 999999);//randomly six-digit int
  }



  public static void main(String[] args) {
    RandomMatches randomMatches = new RandomMatches(10);
    randomMatches.run();

  }
}
