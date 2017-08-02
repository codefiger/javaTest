package com.figer.algorithm.leetcode;

import com.google.common.base.Preconditions;

import java.util.Stack;

/**
 * Created by figer on 01/08/2017.
 */
public class ReverseInteger {
  public static void main(String[] args) {
    int num = 12;
    System.out.println();
    System.out.println((num * 52429) >>> 19);

    int num1 = 1234, num1Reversed = 4321;
    int num2 = -1234, num2Reversed = -4321;
    int num3 = 0, num3Reversed = 0;
    int num4 = 1147483647, num4Reversed = 0;

    Preconditions.checkArgument(num1Reversed == new ReverseInteger().reverse(num1));
    Preconditions.checkArgument(num2Reversed == new ReverseInteger().reverse(num2));
    Preconditions.checkArgument(num3Reversed == new ReverseInteger().reverse(num3));
    Preconditions.checkArgument(num4Reversed == new ReverseInteger().reverse(num4));
  }

  private int reverse1(int num) {
    boolean flag = true;
    if(num < 0){

      if(num == -Math.pow(2, 32)){
        return 0;
      }

      flag = false;
      num = 0 - num;
    }else if (num == 0){
      return 0;
    }else if(num > Math.pow(2, 32) - 1){
      return 0;
    }

    Stack<Integer> stack = new Stack<>();
    int n;
    while(num > 0){
      n = num % 10;
      num = num/10;
      stack.push(n);
    }

    System.out.println("num length: " + stack.size());

    int reversedNum = 0;
    int length = stack.size();
    for (int i = 0; i < length; i++) {
      reversedNum = reversedNum + (int)(stack.pop() * Math.pow(10, i));
    }

    reversedNum = flag ? reversedNum : 0 - reversedNum;
    if(flag && reversedNum < 0){
      return 0;
    }else if(!flag && reversedNum > 0){
      return 0;
    }else {
      return reversedNum;
    }
  }

  public int reverse(int num) {
    boolean isNegative = false;
    long temp = num;
    if(temp < 0){
      isNegative = true;
      temp = -temp;
    }


    long reversedNum = 0;
    while(temp != 0){
      reversedNum = reversedNum*10 + temp%10;
      if(reversedNum > Integer.MAX_VALUE){
        return 0;
      }
      temp = temp / 10;
    }

    return (int)(isNegative ? -reversedNum : reversedNum);
  }

  public int reverse2(int i){//位操作
    boolean isNegative = false;
    if (i < 0) {
      isNegative = true;
      i = -i;
    }
    int r;
    int q;
    int result = 0;
    while (true) {
      q = (i * 52429) >>> 19;//去尾1位，2<<(16+3)＝524288 52429/524288约为0.1
      r = i - ((q << 3) + (q << 1));//r=i-q*10,截出最后一位
      result = (result<<3)+(result<<1)+r;
      i=q;
      if(q==0)break;
    }
    if(isNegative) result = -result;

    System.out.println("result:" + result);
    return result;
  }
}
