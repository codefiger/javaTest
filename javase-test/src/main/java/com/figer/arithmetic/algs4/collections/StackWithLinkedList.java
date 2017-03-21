package com.figer.arithmetic.algs4.collections;

import com.figer.arithmetic.algs4.utils.StdIn;

import java.util.Iterator;

/**
 * Created by figer on 21/03/2017.
 */
public class StackWithLinkedList<T> implements Stackable<T>,Iterable<T>{
  private Node<T> first;
  private int elementCount;//default value is 0

  public void push(T element){
    elementCount ++;
    Node<T> oldFirst = first;
    first = new Node<>();
    first.value = element;
    first.next = oldFirst;
  }

  public T pop(){
    if(isEmpty()){
      throw new ArrayIndexOutOfBoundsException();
    }
    elementCount --;
    T value = first.value;
    first = first.next;
    return value;
  }


  public boolean isEmpty(){
    return first == null;
  }

  public int size(){
    return elementCount;
  }

  //@Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      @Override
      public boolean hasNext() {
        return !isEmpty();
      }

      @Override
      public T next() {
        return pop();
      }
    };
  }

  public static void main(String args[]){
    String inputStr;
    while (!(inputStr = StdIn.readLine()).equals("end")) {
      String inputList[] = inputStr.split(" ");
      StackWithLinkedList<Double> stack = new StackWithLinkedList();
      for (int i = 0; i < inputList.length; i++) {
        if(!inputList[i].equals("-")){
          stack.push(Double.parseDouble(inputList[i]));
        }else if(!stack.isEmpty()){
          System.out.print(stack.pop() + " ");
        }
      }
      System.out.println();
      System.out.println(stack.size() + " elements left in stack");
    }



    System.out.println("======test foreach=====");
    StackWithLinkedList<String> stack = new StackWithLinkedList<>();
    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.forEach(str -> System.out.println(str));//Java 1.8 only
  }
}
