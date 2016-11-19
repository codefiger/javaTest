package com.figer.tools.counter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.net.MalformedURLException;
public class PdfReader {
  public void readPdf(String file) throws Exception {
    long starTime = System.currentTimeMillis();
    boolean sort = false;
    PDDocument document = null;
    WordCounter wordCounter = new WordCounter();
    try {
      try {
        document = PDDocument.load(new File(file));
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }

      PDFTextStripper stripper = new PDFTextStripper();
      stripper.setSortByPosition(sort);
      System.out.println("NumberOfPages:" + document.getNumberOfPages());
      for(int i = 1; i<= document.getNumberOfPages(); i++){
        stripper.setStartPage(i);
        stripper.setEndPage(i);
        String txtContent = stripper.getText(document);
        wordCounter.processEnglishContent(txtContent);
        //System.out.println(txtContent);
      }

    } finally {

      if (document != null) {
        document.close();
      }

      wordCounter.printAddShanbayJS();
      long endTime = System.currentTimeMillis();
      System.out.println("耗时：");
      System.out.println(endTime - starTime+"ms");
    }
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    PdfReader pdfReader = new PdfReader();
    try {
      pdfReader.readPdf("/Users/figer/Documents/books/computer_science/Effective_java_second_edition.pdf");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}