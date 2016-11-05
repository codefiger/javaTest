package com.figer.pattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by figer on 05/11/2016.
 */
public class ShapeProvider {
  private Map<ShapeTp, IShape> shapeMap = new ConcurrentHashMap<ShapeTp, IShape>();

  public ShapeProvider(){
    shapeMap.put(ShapeTp.CIRCLE, new Circle());
    shapeMap.put(ShapeTp.RECTANGLE, new Rectangle());
  }

  public IShape getShape(ShapeTp shapeTp){
    return shapeMap.get(shapeTp);
  }

  public void listAllShape(){
    for(ShapeTp shapeTp : shapeMap.keySet()){
      System.out.println(shapeTp);
    }
  }
}
