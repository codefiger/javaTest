package com.figer.concurrent;

import java.util.ArrayList;
import java.util.List;
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
    //FutureTask<Integer> futureTask = new FutureTask<Integer>(task);

    List<Future> list = new ArrayList();
      for (int i = 0; i < 10; i++) {
        System.out.println(i);
        Future<Integer> future = executorService.submit(new Task(i));
        try {
          //future.get(3, TimeUnit.SECONDS);
          list.add(future);
          System.out.println("1111");
        }catch (Exception e){
          System.out.println("error..");
        }
        System.out.println("----" + i);

      }

    for (int i = 0; i <list.size() ; i++) {
      System.out.println("========");
      Future future = list.get(i);
      try {

        System.out.println("get" + future.get(1, TimeUnit.SECONDS));
      }catch (Exception e){
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
  private int index;

  public Task(int index){
    this.index = index;
  }

  @Override
  public Integer call() throws Exception {
    System.out.println("call function starting..." + index);
    int random = new Random().nextInt(10);
    Thread.sleep(random * 1000);
    System.out.println("call function stop...");
    return index;
  }
}
