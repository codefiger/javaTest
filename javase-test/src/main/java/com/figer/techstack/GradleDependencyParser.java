package com.figer.techstack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by figer on 03/05/2017.
 */
public class GradleDependencyParser implements IDependencyParser {
  private String dependenciesFile;

  public GradleDependencyParser(String dependenciesFile) {
    this.dependenciesFile = dependenciesFile;
  }

  @Override
  public List<String> getDeclaringDependencies() {

    final File inputFile = new File(dependenciesFile);
    GradleDependencyUpdater updater = null;
    try {
      updater = new GradleDependencyUpdater(inputFile);
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<GradleDependency> allDependencies = updater.getAllDependencies();

    List<String> dependencies = new ArrayList<>(allDependencies.size());
    allDependencies.forEach(gradleDependency -> dependencies.add(gradleDependency.dependencyName()));
    return dependencies;
  }
}
