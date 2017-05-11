package com.figer.techstack;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by figer on 03/05/2017.
 */
public class TechStackValidator {
  public static void main(String[] args) throws FileNotFoundException {
    final HashSet<String> techStackWhiteList = new HashSet<>();

    String inputWhiteListFileName = System.getProperty("whiteList", "");
    if(inputWhiteListFileName.isEmpty()){
      inputWhiteListFileName = "/com/figer/techstack/whiteList";
      System.out.println("[INFO] Use default whiteList");
    }

    //load white list
    Iterator<String> iterator = new TxtReader(inputWhiteListFileName);
    iterator.forEachRemaining(line -> {
      String lineTrim = line.trim();
      if(!lineTrim.isEmpty()){
        techStackWhiteList.add(lineTrim);
      }
    });

    Arrays.asList(args).forEach(dependenciesFile -> filterFile(dependenciesFile, techStackWhiteList));
  }

  private static void filterFile(String dependenciesFile, HashSet<String> techStackWhiteList){
    //1 parse file
    List<String> declaringDependencies;
    if(FileType.parseType(dependenciesFile) == FileType.gradle){
      declaringDependencies = new GradleDependencyParser(dependenciesFile).getDeclaringDependencies();
    }else {
      throw new UnsupportedOperationException(String.format("Unsupported file type: %s", dependenciesFile));
    }

    System.out.println("------------------------------------------------");
    System.out.println(dependenciesFile + ": ");
    declaringDependencies.forEach(dependency -> {
      if(!techStackWhiteList.contains(dependency)){
        System.out.println(dependency);
      }
    });
    System.out.println("------------------------------------------------");
  }

  private enum FileType{
    gradle,
    ;

    public static FileType parseType(String fileName){

      String fileInfo[] = fileName.split("\\.");
      FileType fileType = FileType.valueOf(fileInfo[1]);
      return fileType;
    }
  }
}
