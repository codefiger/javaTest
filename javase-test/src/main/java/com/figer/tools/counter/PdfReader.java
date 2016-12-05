package com.figer.tools.counter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;

public class PdfReader implements Iterator<String>{
  private int pageIndex = -1;
  private int totalPages = -1;
  private PDDocument document;
  private PDFTextStripper stripper;

  public PdfReader(String filePath) {
    initPdfFile(filePath);
  }

  private void initPdfFile(String file){
    try {
      document = PDDocument.load(new File(file));
      pageIndex = 0;
      totalPages = document.getNumberOfPages();
      stripper = new PDFTextStripper();
      stripper.setSortByPosition(false);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean hasNext() {
    return pageIndex < totalPages;
  }

  @Override
  public String next() {
    ++pageIndex;
    stripper.setStartPage(pageIndex);
    stripper.setEndPage(pageIndex);
    try {
      return stripper.getText(document);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}