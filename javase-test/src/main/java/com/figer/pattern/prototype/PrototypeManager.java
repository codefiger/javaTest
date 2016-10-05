package com.figer.pattern.prototype;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by figer on 10/5/16.
 */
public class PrototypeManager {
  private Map<String, Prototype> prototypeMap;

  public PrototypeManager() {
    prototypeMap = new HashMap<String, Prototype>();
    ConcretePrototypeA a = new ConcretePrototypeA();
    a.index = 1;
    a.date = new Date();
    a.name = "a";
    prototypeMap.put("default", a);
  }

  public void addPrototype(String key, Prototype prototype){
    prototypeMap.put(key, prototype);
  }

  public Prototype getPrototype(String key){
    return prototypeMap.get(key);
  }
}
