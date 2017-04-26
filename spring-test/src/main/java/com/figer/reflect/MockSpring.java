package com.figer.reflect;

import com.figer.reflect.bean.IMyService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by figer on 25/04/2017.
 */
public class MockSpring {
  public static void main(String[] args) throws Exception {
    Map<String, String> beanDefinitionMap = new HashMap<>();//相当于Spring BeanDefinitionMap
    beanDefinitionMap.put("myServiceClass", "com.figer.reflect.bean.MyService");//Spring从xml或者annotation初始化来

    IMyService iMyService = (IMyService) Class.forName(beanDefinitionMap.get("myServiceClass")).getConstructors()[0].newInstance();
    iMyService.doSomething();
  }
}
