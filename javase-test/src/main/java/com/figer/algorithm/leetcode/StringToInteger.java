package com.figer.algorithm.leetcode;

import com.google.common.base.Preconditions;

/**
 * Created by figer on 09/08/2017.
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class StringToInteger {
  public static void main(String[] args) {
    //more test case
    String str = "+1234";
    Preconditions.checkArgument(Integer.parseInt(str) == new StringToInteger().myAtoi(str));
  }

  public int myAtoi(String str) {
    // 1. null or empty string
    if (str == null || str.length() == 0) return 0;

    // 2. whitespaces
    str = str.trim();

    // 3. plus/minus sign
    boolean positive = true;
    int i = 0;
    if (str.charAt(0) == '+') {
      i++;
    } else if (str.charAt(0) == '-') {
      positive = false;
      i++;
    }

    // 4. calculate real value
    long tmp = 0;
    for ( ; i < str.length(); i++) {
      int digit = str.charAt(i) - '0';

      if (digit < 0 || digit > 9) break;//invalid integral number

      // 5. handle min & max
      if (positive) {
        tmp = 10*tmp + digit;
        if (tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
      } else {
        tmp = 10*tmp - digit;
        if (tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
      }
    }

    return (int)tmp;
  }
}
