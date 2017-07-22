package com.figer.algorithm.leetcode;

/**
 * Created by figer on 21/07/2017.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTowNums {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    System.out.println("----" + l1);
    l1.next = new ListNode(4);
    System.out.println("--" + l1);
    l1.next.next = new ListNode(3);
    //l1.next.next.next = new ListNode(8);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    l2.next.next.next = new ListNode(3);
    ListNode l3 = new AddTowNums().addTwoNumbers(l1, l2);
    System.out.println(l3);

  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l3 = new ListNode(0);
    ListNode lastNode = l3;
    int carry = 0;
    int sum = 0;

    while(l1 != null || l2 != null){
      int val2 = 0;
      int val1 = 0;
      if(l2 != null){
        val2 = l2.val;
        l2 = l2.next;
      }
      if(l1 != null){
        val1 = l1.val;
        l1 = l1.next;
      }

      sum = val1 + val2 + carry;
      carry = sum / 10;
      lastNode.next = new ListNode(sum%10);
      lastNode = lastNode.next;
    }

    if(sum >= 10){
      lastNode.next = new ListNode(sum/10);
    }
    return l3.next;
  }


}