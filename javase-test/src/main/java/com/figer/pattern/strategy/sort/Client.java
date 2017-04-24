package com.figer.pattern.strategy.sort;


import java.util.Arrays;

/**
 * Created by figer on 21/04/2017.
 */
public class Client {
  public static void main(String[] args) {
    Gif gifs[] = new Gif[]{
        new Gif(1,1),
        new Gif(3,3),
        new Gif(2,2)};

    System.out.println(Arrays.toString(gifs));

    Arrays.sort(gifs);//default order
    System.out.println(Arrays.toString(gifs));

    Arrays.sort(gifs, (o1, o2) -> {//length降序
      if(o1.length < o2.length){ return 1; }
      else if(o1.length > o2.length){ return -1; }
      return 0;
    });

    System.out.println(Arrays.toString(gifs));

    Arrays.sort(gifs, (o1, o2) -> {//width降序
      if(o1.width < o2.width){ return 1; }
      else if(o1.width > o2.width){ return -1; }
      return 0;
    });

    System.out.println(Arrays.toString(gifs));
  }
}
