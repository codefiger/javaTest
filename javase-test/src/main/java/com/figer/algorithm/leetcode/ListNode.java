package com.figer.algorithm.leetcode;

/**
 * Created by figer on 21/07/2017.
 */
public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append(val);
    ListNode temp = next;
    while(temp != null){
      sb.append("," + temp.val);
      temp = temp.next;
    }
    return sb.toString();
  }
}
