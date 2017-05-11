package com.figer.algorithm.algs4.utils;

import com.google.common.base.Preconditions;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by figer on 08/03/2017.
 */
public class In {
  private static final String line_separator = "/";

  private String filename;

  public In(String filename) {
    this.filename = filename;
  }

  public int[] readAllInts(){
    StringBuffer sb= new StringBuffer();
    FileReader reader = null;
    BufferedReader br = null;
    try {
      reader = new FileReader(filename);

      br = new BufferedReader(reader);
      String str;
      while((str = br.readLine()) != null){
        sb.append(str).append(line_separator);
      }
      String[] fields = sb.toString().split(line_separator);
      int[] vals = new int[fields.length];
      for (int i = 0; i < fields.length; i++)
        vals[i] = Integer.parseInt(fields[i]);
      return vals;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return new int[]{};
    } catch (IOException e) {
      e.printStackTrace();
      return new int[]{};
    } finally {
      close(reader, br);
    }
  }

  private void close(Closeable ... a){
    Preconditions.checkNotNull(a);
    for (int i = 0; i < a.length; i++) {
      if (a[i] != null) {
        try {
          a[i].close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
