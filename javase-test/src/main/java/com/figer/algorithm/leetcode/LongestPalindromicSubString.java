package com.figer.algorithm.leetcode;

/**
 * Created by figer on 25/07/2017.
 */
public class LongestPalindromicSubString {
  public static void main(String[] args) {
    String string = new LongestPalindromicSubString().longestPalindrome("aba");
    System.out.println(string);
  }

  public String longestPalindrome(String s) {
    String temp = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = s.length(); j > i + temp.length(); j--) {
        String subString = s.substring(i, j);
        if(isPalindromicString(subString)){
          temp = subString;
        }
      }
    }
    return temp;
  }

  private boolean isPalindromicString(String string){
    int m = string.length();
    if(m == 1){
      return true;
    }
    if(m % 2 == 0){
      for (int i = 0; i < m/2; i++) {

      }

      return isPalindromicChars(string.substring(0, m/2).toCharArray(), string.substring(m/2, m).toCharArray());
    }else{
      return isPalindromicChars(string.substring(0, m/2 + 1).toCharArray(), string.substring(m/2, m).toCharArray());
    }
  }

  private boolean isPalindromicChars(char[] c1, char[] c2){
    for (int i = 0; i < c1.length; i++) {
      if(c1[i] != c2[c1.length - i - 1]){
        return false;
      }
    }
    return true;
  }
}
