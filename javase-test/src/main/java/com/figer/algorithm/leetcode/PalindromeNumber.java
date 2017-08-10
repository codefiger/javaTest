package com.figer.algorithm.leetcode;

import com.google.common.base.Preconditions;

/**
 * Created by figer on 10/08/2017.
 */
public class PalindromeNumber {
  public static void main(String[] args) {
    int n = 1000110001;
    int m = 123321;
    Preconditions.checkArgument(new PalindromeNumber().isPalindrome2(n));
    Preconditions.checkArgument(!new PalindromeNumber().isPalindrome(n+1));
    Preconditions.checkArgument(new PalindromeNumber().isPalindrome(m));
  }

  /**
   *
   * 将输入整数转换成倒序的一个整数，再比较转换前后的两个数是否相等
   */
  public boolean isPalindrome(int x) {

    if(x < 0){
      return false;
    }

    int temp = x;
    double reverseNum = 0;
    int index = getNumLength(x) - 1;
    while(temp > 9){
      reverseNum += (temp%10)*Math.pow(10, index --);
      temp = temp/10;
    }
    reverseNum += temp;


    return (long)reverseNum == x;
  }

  /**
   * 每次提取头尾两个数，判断它们是否相等，判断后去掉头尾两个数。
   */
  public boolean isPalindrome2(int x) {

    //negative number
    if(x < 0)
      return false;

    int len = 1;
    while(x / len >= 10) {
      len *= 10;
    }

    while(x > 0)    {

      //get the head and tail number
      int left = x / len;
      int right = x % 10;

      if(left != right)
        return false;
      else    {
        //remove the head and tail number
        x = (x % len) / 10;
        len /= 100;
      }

      if(x < len ){//防止出现 1000221 去头去尾 00023 = 23
        int len2 = 1;
        while(x / len2 >= 10) {
          len2 *= 10;
        }

        int len3 = len/len2;//因为零而减少的位数
        if(x % len3 != 0){
          return false;
        }else {//1000110001
          x = x / len3;
          len = len2/len3;
        }
      }
    }

    return true;
  }



  private int getNumLength(int x){
    int length = 1;
    while(x > 9){
      length++;
      x /= 10;
    }
    return length;
  }
}
