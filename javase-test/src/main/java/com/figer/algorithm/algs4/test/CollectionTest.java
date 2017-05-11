package com.figer.algorithm.algs4.test;


import com.figer.algorithm.algs4.collections.Bag;
import org.junit.Test;

/**
 * Created by figer on 21/03/2017.
 */
public class CollectionTest {
  @Test
  public void bagTest(){
    Bag<String> nums = new Bag<>();
    String inputStr = "1 2 3 4 5 6";
    String inputList[] = inputStr.split(" ");
    for (int i = 0; i < inputList.length; i++) {
      nums.add(inputList[i]);
    }

    print(nums);
  }

  private void print(Iterable iterable){
    iterable.forEach(obj -> System.out.println(obj));
  }
}
