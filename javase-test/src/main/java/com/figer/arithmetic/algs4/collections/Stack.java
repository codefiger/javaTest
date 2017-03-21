package com.figer.arithmetic.algs4.collections;

import java.util.Iterator;

/**
 * Created by figer on 21/03/2017.
 */
public class Stack<T> implements Stackable<T>,Iterable<T>{
  private T elements[];
  private int capacity;
  private int elementCount;//default value is 0

  public Stack(int capacity) {
    this.elements = (T[])new Object[capacity];
    this.capacity = capacity;
  }

  public void push(T element){
    if(elementCount == capacity){
      resize(capacity*2);
    }

    elements[elementCount++] = element;
  }

  public T pop(){
    if(isEmpty()){
      throw new ArrayIndexOutOfBoundsException();
    }

    if(elementCount == capacity/4){
      resize(capacity/2);
    }

    T temp = peek(--elementCount);
    elements[elementCount] = null;//to let gc do its work
    return temp;
  }

  private T peek(int index){
    return elements[index];
  }

  public boolean isEmpty(){
    return elementCount == 0;
  }

  public int size(){
    return elementCount;
  }

  private void resize(int capacity){
    System.out.println(String.format("(resize old %d , new %d)", this.size(), capacity));
    if(capacity < elementCount){
      throw new ArrayIndexOutOfBoundsException();
    }

    this.capacity = capacity;

    T newElements[] = (T[])new Object[capacity];
    for (int i = 0; i < elementCount; i ++){
      newElements[i] = elements[i];
    }
    elements = newElements;
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
    /*String inputStr;
    while (!(inputStr = StdIn.readLine()).equals("end")) {
      String inputList[] = inputStr.split(" ");
      Stack<Double> stack = new Stack(1);
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

    */


    System.out.println("======test foreach=====");
    Stack<String> stack = new Stack<>(10);
    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.forEach(str -> System.out.println(str));//Java 1.8 only
  }
}