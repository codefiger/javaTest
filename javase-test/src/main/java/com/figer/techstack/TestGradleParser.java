package com.figer.techstack;


import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by figer on 03/05/2017.
 */
public class TestGradleParser {
  public static void main(String[] args) throws IOException{
    final File inputFile = new File("/Users/figer/myspace/dianrong/coffee/api/build.gradle");

    GradleDependencyUpdater updater = new GradleDependencyUpdater(inputFile);

    List<GradleDependency> allDependencies = updater.getAllDependencies();

    System.out.println(allDependencies.size());

    allDependencies.forEach(dependency -> System.out.println(dependency));
  }
}
