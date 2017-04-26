package com.figer.pattern.abstractFactory.springbeanfactory.extension;

import com.figer.pattern.abstractFactory.MailSender;
import com.figer.pattern.abstractFactory.Sender;
import com.figer.pattern.abstractFactory.springbeanfactory.BeanFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by figer on 18/04/2017.
 */
public class AnnotationBeanFactory implements BeanFactory {
  Map<String, String> beanDefinitionMap = new HashMap<>();//相当于Spring BeanDefinitionMap

  private Map<String,Object> container = new HashMap();//所有配置好的bean

  public AnnotationBeanFactory() {
    initContainer();
  }

  private void initContainer() {
    beanDefinitionMap.put("sender", "com.figer.pattern.abstractFactory.MailSender");//Spring从xml或者annotation初始化来

    //init bean
    beanDefinitionMap.forEach((beanName, beanClassName) -> {
      try {
        Object obj =  Class.forName(beanDefinitionMap.get(beanClassName)).getConstructors()[0].newInstance();
        container.put(beanName, obj);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }



  @Override
  public Object getBean(String id) {
    return container.get(id);
  }
}
