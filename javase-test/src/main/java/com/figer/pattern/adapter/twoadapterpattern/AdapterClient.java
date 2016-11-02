package com.figer.pattern.adapter.twoadapterpattern;

/**
 * Created by figer on 02/11/2016.
 *我是三头插头使用者
 */
public class AdapterClient {
  public static void main(String[] args) {
    Target target = new ClassAdapter();
    target.play();
    target.sing();

    Target target2 = new ObjectAdapter(new PlayerAdaptee());
    target2.play();
    target2.sing();
  }
}
