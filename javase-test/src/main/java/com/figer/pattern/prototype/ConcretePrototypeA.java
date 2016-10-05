package com.figer.pattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Created by figer on 10/5/16.
 */
public class ConcretePrototypeA implements Prototype {
  String name;
  int index;
  Date date;

  @Override
  public Prototype clone() {
    try {
      return (Prototype)super.clone();
    }catch (Exception e){
      //do nothing
    }
    return null;
  }

  @Override
  public Prototype deepClone() {
    try {
      ByteArrayOutputStream bao = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(bao);
      oos.writeObject(this);

      //将对象从流中取出
      ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
      ObjectInputStream ois = new ObjectInputStream(bis);
      return  (ConcretePrototypeA)ois.readObject();
    }catch (Exception e){
      //do nothing
    }
    return null;
  }

  @Override
  public String toString() {
    return "name:" + name + ";    index:" + index + ";    date:" + date;
  }
}
