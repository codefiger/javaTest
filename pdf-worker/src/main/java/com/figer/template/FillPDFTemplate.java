package com.figer.template;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSmartCopy;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by figer on 27/05/2017.
 */
public class FillPDFTemplate {

  public static void main(String[] args) throws Exception{
    final String file1 = "/Users/figer/Downloads/pdfedit/worker/demo-form.pdf";
    final String file2 = "/Users/figer/Downloads/ContractTest/测试电子合同-会员.pdf";
    String result = "/Users/figer/Downloads/pdfedit/worker/merged.pdf";
    String files[] = {file1, file2};
    new FillPDFTemplate().mergeFiles(files, result, true);

    //new FillPDFTemplate().fillTemplate();
  }

  public void fillTemplate(){//利用模板生成pdf
    //模板路径
    String templatePath = "/Users/figer/Downloads/pdfedit/worker/demo-form.pdf";
    //生成的新文件路径
    String newPDFPath = "/Users/figer/Downloads/pdfedit/worker/hello-form-changed.pdf";
    PdfReader reader;
    PdfStamper stamper;
    try {
      reader = new PdfReader(templatePath);//读取pdf模板
      stamper = new PdfStamper(reader, new FileOutputStream(newPDFPath));
      AcroFields form = stamper.getAcroFields();

      BaseFont bf = BaseFont.createFont("simfang.ttf", BaseFont.IDENTITY_H,BaseFont.EMBEDDED);//支持中文（宋体），字体要单独到网上下载
      ArrayList<BaseFont> fontList = new ArrayList<>();
      fontList.add(bf);
      form.setSubstitutionFonts(fontList);

      Map fields = form.getFields();


      Map<String, String> fieldValue = new HashMap<>();
      fieldValue.put("1", "中文1");
      fieldValue.put("2", "中文2");
      fieldValue.put("name", "张飞");
      fieldValue.put("identity", "130222111133338888的所发生的发送到发送到发送到发送到发送到发送到发生大幅度发大幅度生死书得到的得到的");
      fieldValue.put("birth", "1994-00-00");
      fieldValue.put("gender", "男");
      fieldValue.forEach((key, value) -> {
        try {
          form.setField(key, value);//设置属性值
        } catch (Exception e) {
          e.printStackTrace();
        }
      });

      stamper.setFormFlattening(true);//如果为false那么生成的PDF文件还能编辑，一定要设为true
      stamper.close();
      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }

  public void fillTemplate2() {//利用模板生成pdf
    //模板路径
    String templatePath = "/Users/figer/Downloads/ContractTest/测试电子合同-会员.pdf";
    //生成的新文件路径
    String newPDFPath = "/Users/figer/Downloads/ContractTest/测试电子合同-会员-changed.pdf";
    PdfReader reader;
    PdfStamper stamper;
    try {
      reader = new PdfReader(templatePath);//读取pdf模板
      stamper = new PdfStamper(reader, new FileOutputStream(newPDFPath));
      AcroFields form = stamper.getAcroFields();

      BaseFont bf = BaseFont.createFont("simfang.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);//支持中文（宋体），字体要单独到网上下载
      ArrayList<BaseFont> fontList = new ArrayList<>();
      fontList.add(bf);
      form.setSubstitutionFonts(fontList);

      Map fields = form.getFields();


      Map<String, String> fieldValue = new HashMap<>();
      fieldValue.put("SignfieldName", "张飞");
      fieldValue.forEach((key, value) -> {
        try {
          form.setField(key, value);//设置属性值
        } catch (Exception e) {
          e.printStackTrace();
        }
      });

      stamper.setFormFlattening(true);//如果为false那么生成的PDF文件还能编辑，一定要设为true
      stamper.close();
      reader.close();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }

  public void mergeFiles(String[] files, String result, boolean smart) throws IOException, DocumentException {
    Document document = new Document();
    PdfCopy copy;
    if (smart)
      copy = new PdfSmartCopy(document, new FileOutputStream(result));
    else
      copy = new PdfCopy(document, new FileOutputStream(result));
    document.open();
    PdfReader[] reader = new PdfReader[3];
    for (int i = 0; i < files.length; i++) {
      reader[i] = new PdfReader(files[i]);
      copy.addDocument(reader[i]);
      copy.freeReader(reader[i]);
      reader[i].close();
    }
    document.close();
  }
}
