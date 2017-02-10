package com.figer.tools.counter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class TxtReader implements Iterator<String>{
  private BufferedReader reader;
  private String line;

  public TxtReader(String filePath) {
    initTxtFile(filePath);
  }

  private void initTxtFile(String file){
    try {
      reader = new BufferedReader(new FileReader(file));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean hasNext() {
    try {
      return (line = reader.readLine()) != null;
    } catch (IOException e) {
      System.out.println("read line occurred exception!");
      line = null;
      return false;
    }
  }

  @Override
  public String next() {
    return line;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}