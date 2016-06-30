package com.figer.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by figer on 5/6/16.
 */
public class SeamphoreTest {
  public static void main(String[] args) {
    final Semaphore semaphore = new Semaphore(5);
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i <20 ; i++) {
      Runnable runTask = new Runnable() {
        @Override
        public void run() {
          try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + ":Access ");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      };
    }

  }
}
