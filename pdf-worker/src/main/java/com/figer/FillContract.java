package com.figer;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 26/05/2017.
 */
public class FillContract {
  public static void main(String[] args) throws Exception{
    List<ContractAddInfo> addInfos = new ArrayList<>();
    addInfos.add(new ContractAddInfo().setName("投资者姓名").setContent("张飞").setPageIndex(19).setX(0.34f).setY(0.505f));
    addInfos.add(new ContractAddInfo().setName("投资者身份证").setContent("512501197203035172").setPageIndex(19).setX(0.5f).setY(0.567f));
    addInfos.add(new ContractAddInfo().setName("投资者电话").setContent("15205167819").setPageIndex(19).setX(0.4f).setY(0.592f));
    addInfos.add(new ContractAddInfo().setName("投资额度").setContent("10000").setPageIndex(20).setX(0.4f).setY(0.585f));
    addInfos.add(new ContractAddInfo().setName("投资者姓名").setContent("张飞").setPageIndex(26).setX(0.23f).setY(0.52f));
    addInfos.add(new ContractAddInfo().setName("签署日期").setContent("2017.5.20").setPageIndex(26).setX(0.26f).setY(0.54f));

    String src = "/CMS.pdf";
    String des = "/Users/figer/Downloads/pdfedit/worker/purchase-contract-changed.pdf";
    new FillContract().manipulatePdf(src, des, addInfos);
  }


  /**
   *
   * @param src
   * @param dest
   *
   * -------------->
   * |
   * |
   * |
   * |
   * |
   * ∨
   * 直接坐标系，x,y表示要添加内容的顶点坐标，域大小均在（0,1） ； 比如 x = 0.5, y = 0.5 处于page中间
   */
  public void manipulatePdf(String src, String dest, List<ContractAddInfo> addInfos) throws Exception{
    final PdfReader reader = new PdfReader(src);
    final PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));

    addInfos.forEach(contractAddInfo -> {
      try {
        editContractInfo(reader, stamper, contractAddInfo);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    stamper.close();
    reader.close();
  }

  private void editContractInfo(PdfReader reader, PdfStamper stamper, ContractAddInfo editInfo) throws Exception{
    Rectangle pageSizeInfo = reader.getPageSize(editInfo.getPageIndex());
    float leftX = pageSizeInfo.getLeft();
    float rightX = pageSizeInfo.getRight();
    float topY = pageSizeInfo.getTop();
    float bottomY = pageSizeInfo.getBottom();

    float width = rightX - leftX;
    float height = topY - bottomY;

    //中文字体(宋体)
    BaseFont bfChinese = BaseFont.createFont("simfang.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    //Font font = new Font(bfChinese, 14, Font.NORMAL);

    PdfContentByte over = stamper.getOverContent(editInfo.getPageIndex());
    over.beginText();
    over.setFontAndSize(bfChinese, 14f);
    over.showTextAligned(PdfContentByte.ALIGN_LEFT, editInfo.getContent(), editInfo.getX()*width, (1f-editInfo.getY())*height, 0);
    over.endText();
  }
}
