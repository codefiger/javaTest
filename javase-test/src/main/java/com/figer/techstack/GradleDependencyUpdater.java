package com.figer.techstack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.GroovyCodeVisitor;
import org.codehaus.groovy.ast.builder.AstBuilder;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;

public class GradleDependencyUpdater {
  private List<ASTNode> nodes;
  private File file;
  private List<String> gradleFileContents;

  public GradleDependencyUpdater( File inputFile ) throws MultipleCompilationErrorsException, IOException
  {
    this( IOUtils.toString( new FileInputStream( inputFile ), "UTF-8" ) );
    this.file = inputFile;
  }

  public GradleDependencyUpdater( String scriptContents ) throws MultipleCompilationErrorsException
  {
    AstBuilder builder = new AstBuilder();
    nodes = builder.buildFromString( scriptContents );
  }

  public List<GradleDependency> getAllDependencies()
  {
    FindDependenciesVisitor visitor = new FindDependenciesVisitor();
    walkScript( visitor );

    return visitor.getDependencies();
  }

  public void walkScript( GroovyCodeVisitor visitor )
  {
    for( ASTNode node : nodes )
    {
      node.visit( visitor );
    }
  }
}
