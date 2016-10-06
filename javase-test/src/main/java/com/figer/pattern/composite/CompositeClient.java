package com.figer.pattern.composite;

/**
 * Created by figer on 10/6/16.
 */
public class CompositeClient {
  public static void main(String[] args) {
    Component leaf = new Leaf();
    leaf.handle();

    System.out.println("------");
    Component composite = new Composite();
    composite.add(new Leaf());
    composite.add(new Leaf());
    composite.add(new Leaf());

    Component childComposite = new Composite();
    childComposite.add(new Leaf());
    childComposite.add(new Leaf());
    composite.add(childComposite);

    composite.handle();

  }
}
