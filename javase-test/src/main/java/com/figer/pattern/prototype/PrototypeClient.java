package com.figer.pattern.prototype;

/**
 * Created by figer on 10/5/16.
 */
public class PrototypeClient {
  public static void main(String[] args) {
    PrototypeManager prototypeManager = new PrototypeManager();
    Prototype prototype = prototypeManager.getPrototype("default");
    Prototype shallowCopy = prototype.clone();
    Prototype deepCopy = prototype.deepClone();

    compareThem(prototype, shallowCopy);

    System.out.println("------");
    compareThem(prototype, deepCopy);


  }

  private static void compareThem(Prototype a, Prototype b){
    if(a instanceof ConcretePrototypeA){
      System.out.println(a == b);
      System.out.println(((ConcretePrototypeA) a).index == ((ConcretePrototypeA)b).index);
      System.out.println(((ConcretePrototypeA) a).name == ((ConcretePrototypeA)b).name);
      System.out.println(((ConcretePrototypeA) a).date == ((ConcretePrototypeA)b).date);
    }else{
      System.out.println(a == b);
      System.out.println(((ConcretePrototypeB) a).index == ((ConcretePrototypeB)b).index);
      System.out.println(((ConcretePrototypeB) a).name == ((ConcretePrototypeB)b).name);
      System.out.println(((ConcretePrototypeB) a).date == ((ConcretePrototypeB)b).date);
    }

  }
}
