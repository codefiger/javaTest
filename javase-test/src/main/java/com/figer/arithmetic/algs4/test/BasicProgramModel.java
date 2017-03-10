package com.figer.arithmetic.algs4.test;

import com.figer.arithmetic.algs4.utils.StdIn;
import com.figer.arithmetic.algs4.utils.StdOut;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by figer on 09/03/2017.
 */
public class BasicProgramModel {
  @Test
  public void primitiveValue(){
    System.out.println("e:" + (1e-1));// e = 10
    System.out.println(2.0e-6*100000000.1);// 2*10^(-6)*100000000.1
    System.out.println(true && false || true && true);
  }

  @Test
  public void systemIn(){
    int a[] = new int[3];
    for (int i = 0; i < a.length; i++) {
      System.out.println("please input " + i + " num:");
      a[i] = StdIn.readInt();
    }

    StdOut.println(a[0] == a[1] && a[0] == a[2]);
  }

  @Test
  public void parse2BinaryStr(){
    int num = 4;
    StringBuffer sb = new StringBuffer();
    while(num > 0){
      sb.append(num % 2);
      num = num / 2;
    }
    StdOut.println(sb.reverse());
  }

  @Test
  public void printArray(){
    int m = 4;
    int n = 5;
    boolean a[][] = new boolean[m][n];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j <a[i].length ; j++) {
        a[i][j] = ThreadLocalRandom.current().nextBoolean();
        StdOut.print(a[i][j] ? "A" : "B");
        //StdOut.print(""+i+j + " ");
      }
      StdOut.println();
    }
  }
}
