package com.figer.arithmetic.algs4.collections;

import com.figer.arithmetic.algs4.utils.StdIn;

/**
 * Created by figer on 21/03/2017.
 */
public class FixedCapacityStackOfStrings {
  private String elements[];
  private int capacity;
  private int elementCount;//default value is zero

  public FixedCapacityStackOfStrings(int capacity) {
    this.elements = new String[capacity];
    this.capacity = capacity;
  }

  public void push(String element){
    if(elementCount == capacity){
      throw new ArrayIndexOutOfBoundsException();
    }
    elements[elementCount++] = element;
  }

  public String pop(){
    if(isEmpty()){
      throw new ArrayIndexOutOfBoundsException();
    }
    return elements[--elementCount];
  }

  public boolean isEmpty(){
    return elementCount == 0;
  }

  public int size(){
    return elementCount;
  }

  public static void main(String args[]){
    String inputStr;
    while (!(inputStr = StdIn.readLine()).equals("end")) {
      String inputList[] = inputStr.split(" ");
      FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
      for (int i = 0; i < inputList.length; i++) {
        if(!inputList[i].equals("-")){
          stack.push(inputList[i]);
        }else if(!stack.isEmpty()){
          System.out.print(stack.pop() + " ");
        }
      }
      System.out.println(stack.size() + " elements left in stack");
    }
  }
}
