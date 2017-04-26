package com.figer.reflect;

import com.figer.reflect.bean.IMyService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by figer on 25/04/2017.
 */
public class ReflectFunctionTest {
  public static void main(String[] args) throws Exception{
    Class myClass = Class.forName("com.figer.reflect.bean.MyService");
    System.out.println(myClass);

    IMyService myService = (IMyService) myClass.newInstance();
    myService.doSomething();

    //class.newInstance 内部调用的还是构造器的newInstance
    Constructor<IMyService> constructors[] = myClass.getConstructors();
    Arrays.asList(constructors).forEach(iMyServiceConstructor -> System.out.println(iMyServiceConstructor));

    myService = constructors[0].newInstance();
    myService.doSomething();

    Field fields[] = myClass.getFields();
    Arrays.asList(fields).forEach(field -> System.out.println(field));

    //includes private fields
    Field declaredFields[] = myClass.getDeclaredFields();
    Arrays.asList(declaredFields).forEach(field -> System.out.println(field));

    //类所有公共的方法
    Method methods[] = myClass.getMethods();
    Arrays.asList(methods).forEach(method -> System.out.println(method));
  }
}
