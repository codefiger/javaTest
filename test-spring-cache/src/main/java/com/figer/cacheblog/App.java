package com.figer.cacheblog;

import static com.google.common.base.Preconditions.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by figer on 14/12/2016.
 */
public class App {
  public static void main(String[] args) throws Exception{
    AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(MyCacheConfig.class);
    final IOrderService orderService = annotationContext.getBean(IOrderService.class);
    final String orderId = "key";
    orderService.getOrder(orderId);
    checkArgument(orderService.getOrder(orderId).equals(orderService.getOrder(orderId)));
    checkArgument(orderService.getCallTimes() == 1);

    //test concurrent in Spring4.3.x
    List<Callable<String>> callableBucket = new ArrayList<>();
    for (int i = 0; i < 10 ; i++) {
      callableBucket.add(new Callable<String>() {
        @Override
        public String call() throws Exception {
          return orderService.getOrder(orderId);
        }
      });
    }

    final ExecutorService exec = Executors.newFixedThreadPool(10);
    try {
      exec.invokeAll(callableBucket);
      checkArgument(orderService.getCallTimes() == 1);
    }finally {
      if(!exec.isShutdown()){
        exec.shutdown();
      }
    }

  }
}
