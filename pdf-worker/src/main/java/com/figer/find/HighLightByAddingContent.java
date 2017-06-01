package com.figer.find;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class HighLightByAddingContent {
  public static final String SRC = "/Users/figer/Downloads/pdfedit/worker/find-changed.pdf";
  public static final String DEST = "/Users/figer/Downloads/pdfedit/worker/find-changed1.pdf";
  public static void main(String[] args) throws IOException, DocumentException {
    new HighLightByAddingContent().manipulatePdf(SRC, DEST);
  }

  public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    PdfContentByte canvas = stamper.getOverContent(1);
    float height=595;
    System.out.println(canvas.getHorizontalScaling());
    float x,y;
    x= 216;
    y = height -49.09F;
    canvas.saveState();
    canvas.setColorFill(BaseColor.YELLOW);
    canvas.rectangle(x, y-5, 43, 15);

    canvas.fill();
    canvas.restoreState();
    //开始写入文本
    canvas.beginText();
    //BaseFont bf = BaseFont.createFont(URLDecoder.decode(CutAndPaste.class.getResource("/AdobeSongStd-Light.otf").getFile()), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    BaseFont bf = BaseFont.createFont("simfang.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    Font font = new Font(bf,10,Font.BOLD);
    //设置字体和大小
    canvas.setFontAndSize(font.getBaseFont(), 10);
    //设置字体的输出位置
    canvas.setTextMatrix(x, y);
    //要输出的text
    canvas.showText("中文" );

    //设置字体的输出位置
    canvas.setFontAndSize(font.getBaseFont(), 20);
    canvas.setTextMatrix(x, y-90);
    //要输出的text
    canvas.showText("中文" );

    canvas.endText();
    stamper.close();
    reader.close();
    System.out.println("complete");
  }
}
