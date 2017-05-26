package com.figer;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReplaceStream {
  public static final String SRC = "/Users/figer/Downloads/pdfedit/worker/hello.pdf";
  public static final String DEST = "/Users/figer/Downloads/pdfedit/worker/hello-changed.pdf";

  public static void main(String[] args) throws IOException, DocumentException {
    File file = new File(DEST);
    file.getParentFile().mkdirs();
    new ReplaceStream().manipulatePdf(SRC, DEST, 1,0.5f, 0.5f);
  }

  /**
   *
   * @param src
   * @param dest
   * @param x
   * @param y
   *
   * 直接坐标系，x,y表示要添加内容的顶点坐标，域大小均在（0,1） ； 比如 x = 0.5, y = 0.5 处于page中间
   */
  public void manipulatePdf(String src, String dest, int pageIndex, float x, float y) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    Rectangle pageSizeInfo = reader.getPageSize(pageIndex);

    float leftX = pageSizeInfo.getLeft();
    float rightX = pageSizeInfo.getRight();
    float topY = pageSizeInfo.getTop();
    float bottomY = pageSizeInfo.getBottom();

    float width = rightX - leftX;
    float height = topY - bottomY;


    //中文字体(宋体)
    BaseFont bfChinese = BaseFont.createFont("simfang.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    //Font font = new Font(bfChinese, 14, Font.NORMAL);

    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    PdfContentByte over = stamper.getOverContent(pageIndex);
    over.beginText();
    over.setFontAndSize(bfChinese, 16f);
    over.showTextAligned(PdfContentByte.ALIGN_LEFT, "中文", x*width, y*height, 0);
    over.endText();

    stamper.close();
    reader.close();
  }

  public static void editPDF(String oldString, String newsString, String chars) {
    try {
      // 获取pdf文档
      PdfReader reader = new PdfReader(oldString);
      // 一个输入流吧应该，把上面获取的文档写到新的pdf中
      PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(newsString));
      // 创建字体（生成水印用到的字体）参数一：字体名称（可以写入中文字体），参数二：字体编码，参数三：是否嵌入
      BaseFont bFont = BaseFont.createFont("simfang.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
      // 循环pdf页数
      for (int i = 1; i < reader.getNumberOfPages() + 1; i++) {
        // 水印工具
        PdfContentByte over = stamper.getOverContent(i);
        //开始
        over.beginText();
        //设置字体大小，可以在开始前设置
        over.setFontAndSize(bFont, 8.1f);
        //水印位置 参数一：对齐（左中右都行） 参数二：水印内容 参数三四：水印开始坐标 参数五：水印旋转角度
        over.showTextAligned(PdfContentByte.ALIGN_LEFT, chars, 555, 3, 0);
        //结束
        over.endText();
      }
      stamper.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }
}