package com.figer.algorithm.algs4;

/**
 * Created by figer on 10/02/2017.
 */
public class Simple {
  public static void main(String[] args) {
    System.out.println(gcd(4,10));
    System.out.println(4%10);
  }

  public static int gcd(int p, int q){
    System.out.println("p:" + p + ",q:" + q);
    if(q == 0){
      return p;
    }else{
      return gcd(q, p%q);
    }
  }
}
