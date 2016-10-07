package com.figer.pattern.iterator;

/**
 * Created by figer on 07/10/2016.
 */
public class IteratorClient {
  public static void main(String[] args) {
    AbstractList<String> productList = new ProductList<String>();
    productList.add("my ");
    productList.add("name ");
    productList.add("is ");
    productList.add("figer ");
    productList.add("peng!");

    Iterator<String> car = productList.createIterator();
    while (car.hasNext()){
      System.out.print(car.next());
    }
  }
}
