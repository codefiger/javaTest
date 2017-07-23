package com.figer.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by figer on 22/07/2017.
 */
public class LengthOfLongestSubstring {

  public static void main(String[] args) {
    int longestLength = new LengthOfLongestSubstring().lengthOfLongestSubstring2("qrsvbspk");
    System.out.println("longestLength :" + longestLength);
  }

  public int lengthOfLongestSubstring(String s) {
    int longestLength = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++){
      Set set = new HashSet();
      for (int j = i; j < chars.length && !set.contains(chars[j]); j++){
        set.add(chars[j]);
        if(set.size() > longestLength){
          longestLength++;
          //System.out.println(Arrays.toString(set.toArray()));
        }
      }
    }
    return longestLength;
  }

  public int lengthOfLongestSubstring2(String s) {
    int longestLength = 0;
    char[] chars = s.toCharArray();
    Set set = new HashSet();
    for (int i = 0, j = 0; i < chars.length;){
      if(!set.contains(chars[i])){
        set.add(chars[i++]);
        longestLength = Math.max(longestLength, i - j);
      }else{
        set.remove(chars[j++]);
        //set.add(chars[i]);
      }
    }
    return longestLength;
  }
}
