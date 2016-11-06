package com.figer.tools.counter;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;

import java.io.BufferedReader;
import java.util.Map;

/**
 * Created by figer on 06/11/2016.
 */
@Deprecated
public class PdfHandler {
  public static void main(String[] args) throws Exception{
    testPdfReader("/Users/figer/Documents/books/computer_science/Effective_java_second_edition.pdf");
  }

  private static void testPdfReader(String fileName) throws Exception{
    com.itextpdf.text.pdf.PdfReader pdfReader = new com.itextpdf.text.pdf.PdfReader(fileName);
    int totalPages = pdfReader.getNumberOfPages();
    /*Map<String, String> pdfInfoMap = pdfReader.getInfo();
    for(String key : pdfInfoMap.keySet()){
      System.out.println(String.format("Info %s-%s", key, pdfInfoMap.get(key)));
    }*/


    System.out.println(totalPages);

    byte[] pageContent;
    String pageContentStr;
    for (int i = 1; i < 16; i++) {
      pageContent = pdfReader.getPageContent(i);
      pageContentStr = new String(pageContent, "UTF-8");
      System.out.println(pageContent.length);
    }

    pdfReader.close();
  }
}
