package com.figer.find;

import java.io.IOException;
import java.util.Arrays;

import com.itextpdf.awt.geom.Rectangle2D.Float;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class Demo
{
  // 定义关键字
  private static String KEY_WORD = "一本正经";
  // 定义返回值
  private static float[] resu = null;
  // 定义返回页码
  private static int i = 0;

  public static void main(String[] args) {
    float[] point = getKeyWords("/Users/figer/Downloads/pdfedit/worker/demo.pdf");
    System.out.println(Arrays.toString(point));
  }
  /*
   * 返回关键字所在的坐标和页数 float[0] >> X float[1] >> Y float[2] >> page
   */
  private static float[] getKeyWords(String filePath)
  {
    try
    {
      PdfReader pdfReader = new PdfReader(filePath);
      int pageNum = pdfReader.getNumberOfPages();
      PdfReaderContentParser pdfReaderContentParser = new PdfReaderContentParser(pdfReader);
      // 下标从1开始
      for (i = 1; i <= pageNum; i++)
      {
        pdfReaderContentParser.processContent(i, new RenderListener()
        {

          @Override
          public void renderText(TextRenderInfo textRenderInfo)
          {
            String text = textRenderInfo.getText();
            System.out.println(text);
           /* if (null != text && text.contains(KEY_WORD))
            {
              Float boundingRectange = textRenderInfo
                  .getBaseline().getBoundingRectange();
              resu = new float[3];
              System.out.println("======="+text);
              System.out.println("h:"+boundingRectange.getHeight());
              System.out.println("w:"+boundingRectange.width);
              System.out.println("centerX:"+boundingRectange.getCenterX());
              System.out.println("centerY:"+boundingRectange.getCenterY());
              System.out.println("x:"+boundingRectange.getX());
              System.out.println("y:"+boundingRectange.getY());
              System.out.println("maxX:"+boundingRectange.getMaxX());
              System.out.println("maxY:"+boundingRectange.getMaxY());
              System.out.println("minX:"+boundingRectange.getMinX());
              System.out.println("minY:"+boundingRectange.getMinY());
              resu[0] = boundingRectange.x;
              resu[1] = boundingRectange.y;
              resu[2] = i;
            }*/
          }

          @Override
          public void renderImage(ImageRenderInfo arg0)
          {
          }

          @Override
          public void endTextBlock()
          {

          }

          @Override
          public void beginTextBlock()
          {
          }
        });
      }
    } catch (IOException e)
    {
      e.printStackTrace();
    }
    return resu;
  }

}