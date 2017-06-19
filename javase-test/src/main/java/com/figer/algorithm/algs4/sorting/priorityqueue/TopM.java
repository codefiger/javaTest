package com.figer.algorithm.algs4.sorting.priorityqueue;

import java.util.Stack;

/**
 * Created by figer on 12/06/2017.
 */
public class TopM {
  public static void main(String[] args) {
    int max = 5;
    MaxPQ<Transaction> maxPQ = new SortedArrayMaxPQ<>(max);

    for (Transaction transaction : getRandomTransArray()) {
      maxPQ.insert(transaction);
      if(maxPQ.size() > max){
        maxPQ.delMax();
      }
    }

    Stack<Transaction> stack = new Stack<>();
    while (!maxPQ.isEmpty()){
      stack.push(maxPQ.delMax());
    }

    stack.forEach(transaction -> System.out.println(transaction));
  }

  private static Transaction[] getRandomTransArray(){
    Transaction transactions[] = new Transaction[]{
        new Transaction(0),
        new Transaction(5),
        new Transaction(8),
        new Transaction(1),
        new Transaction(11),
        new Transaction(3),
        new Transaction(1000),
        new Transaction(2)};

    return transactions;
  }

  public static class Transaction implements Comparable {
    private long id;
    private int amount;
    private String fromUser;
    private String toUser;

    public Transaction(int amount) {
      this.amount = amount;
    }

    public long getId() {
      return id;
    }

    public Transaction setId(long id) {
      this.id = id;
      return this;
    }

    public int getAmount() {
      return amount;
    }

    public Transaction setAmount(int amount) {
      this.amount = amount;
      return this;
    }

    public String getFromUser() {
      return fromUser;
    }

    public Transaction setFromUser(String fromUser) {
      this.fromUser = fromUser;
      return this;
    }

    public String getToUser() {
      return toUser;
    }

    public Transaction setToUser(String toUser) {
      this.toUser = toUser;
      return this;
    }

    @Override
    public int compareTo(Object o) {
      return this.amount - ((Transaction)o).amount;
    }

    @Override
    public String toString() {
      return "Transaction{" +
          "amount=" + amount +
          '}';
    }
  }
}


