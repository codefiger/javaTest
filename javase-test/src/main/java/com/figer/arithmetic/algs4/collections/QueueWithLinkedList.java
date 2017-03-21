package com.figer.arithmetic.algs4.collections;

import com.figer.arithmetic.algs4.collections.api.IQueue;
import com.figer.arithmetic.algs4.utils.StdIn;

/**
 * Created by figer on 21/03/2017.
 */
public class QueueWithLinkedList<T> implements IQueue<T> {

  public static void main(String[] args) {
    String input;
    while(!(input = StdIn.readLine()).equals("end")){
      String inputList[] = input.split(" ");
      IQueue<String> queue = new QueueWithLinkedList<>();
      for (String str : inputList) {
        if(!"-".equals(str)){
          queue.enqueue(str);
        }else if(!queue.isEmpty()){
          System.out.println(queue.dequeue());
        }
      }
      System.out.println(queue.size() + " elements left in stack");
    }
  }

  private Node<T> first;
  private Node<T> last;
  private int elementCount;//default value is 0

  @Override
  public void enqueue(T t) {
    Node<T> oldLast = last;
    last = new Node<>();
    last.value = t;
    if(isEmpty()){
      first = last;
    }else{
      oldLast.next = last;
    }
    elementCount ++;
  }

  @Override
  public T dequeue() {
    if(isEmpty()){
      throw new ArrayIndexOutOfBoundsException();
    }
    Node<T> oldFirst = first;
    first = first.next;
    elementCount --;
    return oldFirst.value;
  }

  @Override
  public boolean isEmpty() {
    return elementCount == 0;
  }

  @Override
  public int size() {
    return elementCount;
  }
}
