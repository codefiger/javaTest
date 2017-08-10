package com.figer.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import fr.opensagres.xdocreport.itext.extension.font.AbstractFontRegistry;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import fr.opensagres.xdocreport.itext.extension.font.ITextFontRegistry;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocxToPdf {

  public static void convertPdf(String docxFilePath,String pdfFilePath) throws Exception{
    File docxFile=new File(docxFilePath);
    File pdfFile=new File(pdfFilePath);

//转换pdf文件
    if(docxFile.exists()){
      if(!pdfFile.exists()){
        InputStream inStream=new  FileInputStream(docxFilePath);
        XWPFDocument document = new XWPFDocument(inStream);
        //HWPFDocument document = new HWPFDocument(inStream);
        OutputStream out = new FileOutputStream(pdfFilePath);
        PdfOptions options = PdfOptions.create();
        IFontProvider fontProvider= new ITextFontRegistry().getRegistry();
        options.fontProvider(fontProvider);
        PdfConverter.getInstance().convert(document, out, options);
      }else{
        System.out.println("PDF文件已存在，无需再次转换");
      }
    }else{
      System.out.println("no file");
    }
  }

  public static void main(String[] args) throws Exception {
    String filePath = "/Users/figer/Downloads/pdfedit/modify.docx";
    String to = "/Users/figer/Downloads/pdfedit/modify.pdf";
    convertPdf(filePath, to);
  }

}