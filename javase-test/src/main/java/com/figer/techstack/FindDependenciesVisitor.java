package com.figer.techstack;

import org.codehaus.groovy.ast.CodeVisitorSupport;
import org.codehaus.groovy.ast.expr.ArgumentListExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.MethodCallExpression;

import java.util.ArrayList;
import java.util.List;

public class FindDependenciesVisitor extends CodeVisitorSupport {
  private List<GradleDependency> dependencies = new ArrayList<>();

  @Override
  public void visitMethodCallExpression(MethodCallExpression call){
    //parse dependencies & compile methods only
    if( call.getMethodAsString().equals( "compile" ) || call.getMethodAsString().equals("dependencies") )// others
    {
      super.visitMethodCallExpression( call );
    }
  }

  @Override
  public void visitArgumentlistExpression( ArgumentListExpression ale){
    List<Expression> expressions = ale.getExpressions();

    //System.out.println(expressions.get(0).getText());

    String argumentStr = expressions.get(0).getText();
    //TODO : only parse "compile jar dependency" arguments
    if( expressions.size() == 1 && expressions.get(0) instanceof ConstantExpression){
      String depStr = expressions.get( 0 ).getText();
      boolean compileProject = depStr.startsWith(":");
      if(!compileProject){
        String[] deps = depStr.split( ":" );
        if(deps.length > 1){
          dependencies.add( new GradleDependency( deps[0], deps[1], deps.length > 2 ? deps[2] : null) );
        }
      }
    }

    super.visitArgumentlistExpression( ale );
  }

  public List<GradleDependency> getDependencies()
  {
    return dependencies;
  }
}
