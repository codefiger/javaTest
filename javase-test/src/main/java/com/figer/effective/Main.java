package com.figer.effective;

import com.figer.effective.builder.Phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 9/27/16.
 */
public class Main {
  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();
    List<Phone> phones = new ArrayList<Phone>();
    for (int i = 0;i < 10000000;i++){
      Phone phone = new Phone.Builder(i).build();
      phones.add(phone);
    }
    long secondTime = System.currentTimeMillis();
    System.out.println(secondTime - startTime);

    List<Phone> phones2 = new ArrayList<Phone>();
    Phone phone;
    for (int i = 0;i < 10000000;i++){
      phone = new Phone.Builder(i).build();
      phones2.add(phone);
    }
    long lastTime = System.currentTimeMillis();
    System.out.println(lastTime - secondTime);

  }

  private static void testAutoboxing(){
    long startTime = System.currentTimeMillis();
    autoboxing();
    long secondTime = System.currentTimeMillis();
    System.out.println(secondTime - startTime);
    nonAutoboxing();
    long lastTime = System.currentTimeMillis();
    System.out.println(lastTime - secondTime);
  }

  private static void autoboxing(){
    Long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }
    System.out.println(sum);
  }

  private static void nonAutoboxing(){
    long sum = 0L;
    for (long i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }
    System.out.println(sum);
  }
}
