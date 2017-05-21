package com.figer.algorithm.algs4.utils;

import java.awt.*;

/**
 * Created by figer on 16/05/2017.
 */
public class CostDraw {
  private static final double X_BASE = 50;
  private static final double Y_BASE = 80;
  private static final double X_BASE_END = 625;
  private static final double Y_BASE_END = 800;

  public CostDraw() {
    StdDraw.setYscale(0, 2000);
    StdDraw.setXscale(0, 650);
    StdDraw.line(X_BASE, X_BASE,X_BASE_END,X_BASE);//x轴
    StdDraw.text(X_BASE_END, Y_BASE, X_BASE_END+"");
    StdDraw.line(X_BASE, X_BASE,X_BASE,Y_BASE_END);//y轴
    StdDraw.text(X_BASE, Y_BASE_END, Y_BASE_END + "");
    StdDraw.setPenColor(Color.red);
  }

  public void drawPoint(double x, double y){
    StdDraw.point((X_BASE_END-X_BASE)*x/X_BASE_END + X_BASE, (Y_BASE_END-Y_BASE)*y/Y_BASE_END + Y_BASE);
  }
}
