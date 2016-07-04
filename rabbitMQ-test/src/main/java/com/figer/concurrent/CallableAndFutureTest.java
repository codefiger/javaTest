package com.figer.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by figer on 7/4/16.
 */
public class CallableAndFutureTest {
  public static void main(String[] args) {
    System.out.println("main thread staring ...");
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Task task = new Task();
    //FutureTask<Integer> futureTask = new FutureTask<Integer>(task);

      for (int i = 0; i < 10; i++) {
        System.out.println(i);
        Future<Integer> future = executorService.submit(task);
        try {
          future.get(1, TimeUnit.SECONDS);
        }catch (Exception e){
          //e.printStackTrace();
          future.cancel(true);
          System.out.println("error..");
        }

      }

      //Integer integer = future.get(2, TimeUnit.SECONDS);
      // System.out.println(integer);

    System.out.println("main thread stop");
  }

}

class Task implements Callable<Integer>{

  @Override
  public Integer call() throws Exception {
    int random = new Random().nextInt(10);
    Thread.sleep(random * 1000);
    System.out.println("call function starting...");
    return 1;
  }
}
