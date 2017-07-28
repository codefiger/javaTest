package com.figer.algorithm.leetcode;

/**
 * Created by figer on 25/07/2017.
 */
public class LongestPalindromicSubString2 {
  public static void main(String[] args) {
    String string = new LongestPalindromicSubString2().longestPalindrome("aba");
    System.out.println(string);
  }

  public String longestPalindrome(String s) {
    String temp = s.substring(0);
    char[] chars = s.toCharArray();
    for (int i = 1; i < s.length() - 1; i++) {
      for (int j = 1; j < i; j++) {
        if(2*j>temp.length() && chars[i-1] == chars[i+1]){

        }
      }
    }
    return temp;
  }
}
