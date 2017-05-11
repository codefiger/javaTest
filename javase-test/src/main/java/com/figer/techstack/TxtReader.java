package com.figer.techstack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class TxtReader implements Iterator<String>{
  private BufferedReader reader;
  private String line;

  public TxtReader(String filePath) throws FileNotFoundException {
    initTxtFile(filePath);
  }

  private void initTxtFile(String file) throws FileNotFoundException {
      InputStream inputStream = TxtReader.class.getResourceAsStream(file);
      if(inputStream == null){
        inputStream = new FileInputStream(file);
      }
      reader = new BufferedReader(new InputStreamReader(inputStream));
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