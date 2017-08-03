package com.figer.algorithm.leetcode;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 02/08/2017.
 */
public class ZigzagConversion {
  public static void main(String[] args) {
    String inputStr = "PAYPALISHIRING";
    int numRows = 3;
    String zigzagStr = new ZigzagConversion().convert(inputStr, numRows);
    System.out.println(zigzagStr);
    Preconditions.checkArgument("PAHNAPLSIIGYIR".equals(zigzagStr));

    numRows = 4;
    zigzagStr = new ZigzagConversion().convert(inputStr, numRows);
    System.out.println(zigzagStr);
    Preconditions.checkArgument("PINALSIGYAHRPI".equals(zigzagStr));
  }

  private String convert(String inputStr, int numRows) {
    if(numRows <= 1){
      return inputStr;
    }

    List<char[]> list = new ArrayList<>();
    int index = 0;
    for (int i = 0; i < inputStr.length(); i++) {

      if(index == 0){
        char[] chars = new char[numRows];
        list.add(chars);
        while(index < numRows && i < inputStr.length()){

          char c = inputStr.charAt(i);
          System.out.println(c);
          chars[index++] = inputStr.charAt(i++);
        }

        i--;
        index = index - 2;
      }else{
        char c = inputStr.charAt(i);
        System.out.println(c);
        char[] chars = new char[numRows];
        chars[index%numRows] = inputStr.charAt(i);
        list.add(chars);
        index --;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      int finalI = i;
      list.forEach(chars ->  {
        if(chars[finalI] != 0){
          sb.append(chars[finalI]);
        }

      });
    }

    return sb.toString();
  }
}
