package com.figer.annotation;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by figer on 30/06/2017.
 */
public class Client {
  public static void main(String[] args) throws Exception{
    Actor actor = new Actor();
    actor.setAge(11);
    actor.setAmount(BigDecimal.ONE);
    actor.setName("figer");
    List<Method> list = Arrays.asList(actor.getClass().getMethods());
    list.forEach(method -> {
      if(method.isAnnotationPresent(BindField.class)){
        BindField bindField = method.getAnnotation(BindField.class);
        System.out.println("--bindField--" + bindField.value());
        if(bindField.value().equals("amount")){
          try {
            System.out.println("key:" + bindField.value() + ", value:" + method.invoke(actor));
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          } catch (InvocationTargetException e) {
            e.printStackTrace();
          }
        }
      }

    });
  }
}
