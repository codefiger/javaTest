package com.figer;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test{
  public static void main(String[] args) throws Exception{

    ExecutorService exec = Executors.newCachedThreadPool();
    CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(exec);
    int[] index = {1,2,3,4,5,6,7,8};
    for(final int i : index){
      try {
        completionService.submit(new Callable<Integer>() {
          @Override
          public Integer call() throws Exception {
            System.out.println("...." + i);
            Thread.sleep(1500);
            if(i == 4)
              throw new RuntimeException("111");
            return new Random().nextInt(10);
          }
        });
      }catch (Exception e){
        System.out.println("ex");
      }

    }
    int sum = 0;
    for(int i=0; i<index.length; i++){
      try {
        completionService.take().get(2, TimeUnit.SECONDS);
        sum ++;
      }catch (Exception e){
        System.out.println("ex" + i);
      }

    }
    System.out.println("总数为："+sum);
  }
}

class View{
  private boolean showErrorMsg;

  public boolean isShowErrorMsg() {
    return showErrorMsg;
  }

  public View setShowErrorMsg(boolean showErrorMsg) {
    this.showErrorMsg = showErrorMsg;
    return this;
  }
}