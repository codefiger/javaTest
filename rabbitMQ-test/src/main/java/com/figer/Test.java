package com.figer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test{
  public static void main(String[] args) {
    System.out.println("111");

    BigDecimal bigDecimal = new BigDecimal(2.111);
    BigDecimal b = new BigDecimal(3.2);
    System.out.println(bigDecimal.multiply(b).setScale(2, RoundingMode.HALF_UP));

    System.out.println(new BigDecimal(0.0100).compareTo(new BigDecimal(0.01)) == -1);

  }
}