package com.figer.pattern.abstractFactory.springbeanfactory;

import com.figer.pattern.abstractFactory.MailSender;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by figer on 18/04/2017.
 */
public class AnnotationBeanFactory implements BeanFactory {

  public AnnotationBeanFactory() {
    initContainer();
  }

  private void initContainer() {
    //TODO: implement
    container.put("sender", new MailSender());
  }

  //所有配置好的bean
  private Map<String,Object> container = new HashMap();

  @Override
  public Object getBean(String id) {
    return container.get(id);
  }
}
