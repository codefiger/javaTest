package com.figer.algorithm.leetcode;

/**
 * Created by figer on 25/07/2017.
 */
public class LongestPalindromicSubString2 {
  public static void main(String[] args) {
    String string = new LongestPalindromicSubString2().longestPalindrome("222223333abcdefghhgfedcba11122");
    System.out.println(string);
  }

  public String longestPalindrome(String s) {

    //p(left,right) true表示s(left,right)字符串是对称的(Palindrome）,false反之
    //s(left,right)字符串对称的冲要条件是： s.charAt(left) == s.charAt(right) && p(left+1,right-1) == true
    boolean[][] p = new boolean[s.length()][s.length()];

    //初始化：
    int left = 0;
    int right = 0;
    for (left = 0; left < s.length(); left++) {
      for (right = 0; right < s.length(); right++) {
        if(left >= right){
          p[left][right] = true;//单个子字符串以及不存在子字符串初始化为-对称
        }else {
          p[left][right] = false;////单个子字符串以及不存在子字符串初始化为-不对称
        }
      }
    }

    int longestLeft = 0;
    int longestRight = 0;
    int longestLength = 1;
    for (int length = 1; length < s.length(); length++) {
      for (left = 0; left + length < s.length(); left++) {
        right = left + length;
        if(s.charAt(left) != s.charAt(right)){
          p[left][right] = false;
        }else{//s.charAt(left) == s.charAt(right)
          p[left][right] = p[left + 1][right - 1];
          if(p[left][right] && length + 1 > longestLength){ //p(left+1,right-1) == true
            longestLeft = left;
            longestRight = right;
            longestLength = length + 1;
          }
        }
      }
    }

    return s.substring(longestLeft, longestRight + 1);
  }
}
