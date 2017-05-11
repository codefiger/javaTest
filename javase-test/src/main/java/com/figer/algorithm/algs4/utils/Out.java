package com.figer.algorithm.algs4.utils;

import com.google.common.base.Preconditions;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by figer on 17/03/2017.
 */
public class Out {
  private String filename;
  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;

  public Out(String filename) {
    this.filename = filename;
    try {
      fileWriter = new FileWriter(filename, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    bufferedWriter = new BufferedWriter(fileWriter);
  }

  public boolean writeInt(int a){
    try {
      bufferedWriter.write(a + System.getProperty("line.separator"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  public void close(){
    closeInner(bufferedWriter, fileWriter);
  }

  public void closeInner(Closeable... a){
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

  public static void main(String[] args) {
    Out out = new Out("/Users/figer/Downloads/test/largeW.txt");

    int num = 1000000;
    int seed = ThreadLocalRandom.current().nextInt(10);
    for (int i = 0; i < num; i++) {
      out.writeInt(seed++);
    }
    out.close();
    System.out.println("/Users/figer/Downloads/test/largeW.txt finish");

    Out out2LargeT = new Out("/Users/figer/Downloads/test/largeT.txt");
    num = 10000000;

    for (int i = 0; i < num; i++) {
      out2LargeT.writeInt(ThreadLocalRandom.current().nextInt(100000000));
    }
    out2LargeT.close();
    System.out.println("/Users/figer/Downloads/test/largeT.txt finish");
  }
}
