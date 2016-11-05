package com.figer.pattern.flyweight;

/**
 * Created by figer on 05/11/2016.
 */
public class FlyweightClient {
  public static void main(String[] args) {
    ShapeProvider provider = new ShapeProvider();
    provider.listAllShape();

    System.out.println("-------");

    provider.getShape(ShapeTp.CIRCLE).draw();

    //JDK example:
    Integer a = Integer.valueOf("1");
    System.out.println(a);
  }
}
