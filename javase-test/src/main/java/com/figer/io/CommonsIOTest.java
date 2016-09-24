package com.figer.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 9/23/16.
 */
public class CommonsIOTest {
  public static void main(String[] args) {
    File file = new File("/Users/figer/Documents/dianrong/starWin/fax/test/lines.txt");
    try {
      readFile(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private static void readFile(File file) throws Exception{
    LineIterator it = FileUtils.lineIterator(file, "UTF-8");
    try {
      while (it.hasNext()) {
        String line = it.nextLine();
        System.out.println(line);
        /// do something with line
      }
    } finally {
      LineIterator.closeQuietly(it);
    }
  }

  private static void writeFile(File file) throws Exception{
    List<String> lines = new ArrayList<String>();

    lines.add("line A1...");
    lines.add("line 中文...");
    lines.add("line #￥%&,,,,.....");
    lines.add("line 12345678...");
    lines.add("line Stringadafsdfasd123123...");

    try {
      FileUtils.writeLines(file, lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
