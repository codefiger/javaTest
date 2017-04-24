package com.figer.arithmetic.algs4.test;

import com.figer.arithmetic.algs4.utils.StdIn;

import java.util.Stack;

/**
 * Created by figer on 20/03/2017.
 */
public class Evaluator {
  private Stack<Double> vals = new Stack<>();
  private Stack<Operation> ops = new Stack<>();

  private enum Operation{
    ADD("+"),
    SUBTRACT("-"),
    DIVIDE("/"),
    MULTIPLY("*"),
    SQRT("sqrt"),
    ;
    private String opStr;

    public String getOpStr(){
      return this.opStr;
    }

    Operation(String opStr) {
      this.opStr = opStr;
    }

    public static Operation getOperation(String opStr){
      return Operation.values()[rank(opStr)];
    }

    public static boolean isOperation(String opStr){
      return rank(opStr) != -1;
    }

    private static int rank(String opStr){
      for (int i = 0; i < Operation.values().length; i++) {
        if(Operation.values()[i].getOpStr().equals(opStr)){
          return i;
        }
      }
      return -1;
    }
  }

  public double calcPostfix(String str){
    vals = new Stack<>();
    String values[] = str.split(" ");
    for (int i = 0; i < values.length; i++) {
      if(Operation.isOperation(values[i])){
        double leftVal = vals.pop();
        vals.push(getResult(Operation.getOperation(values[i]), leftVal));
      }else{
        vals.push(Double.parseDouble(values[i]));
      }
    }
    double value = vals.pop();

    return value;
  }

  //( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
  public void start(){
    String inputStr;
    while (!(inputStr = StdIn.readLine()).equals("end")){
      String inputList[] = inputStr.split(" ");
      String str;
      for (int i = 0; i < inputList.length; i++) {
        str = inputList[i];
        if("(".equals(str)){
          //do nothing
        }else if(Operation.isOperation(str)){
          ops.push(Operation.getOperation(str));
        }else if(")".equals(str)){
          Operation op = ops.pop();
          double leftVal = vals.pop();
          vals.push(getResult(op, leftVal));
        }else{
          vals.push(Double.parseDouble(str));
        }
      }
      System.out.println(vals.pop());
    }
  }

  private double getResult(Operation op, double leftVal){
    switch (op){
      case ADD:
        return vals.pop() + leftVal;
      case SUBTRACT:
        return vals.pop() - leftVal;
      case MULTIPLY:
        return vals.pop() * leftVal;
      case DIVIDE:
        return vals.pop() / leftVal;
      case SQRT:
        return  Math.sqrt(leftVal);
      default:
        throw new UnsupportedOperationException();
    }
  }

  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();
    //evaluator.start();
    String postfixStr = "1.0 2.0 3.0 4.0 + + + 5.0 6.0 * + ";
    System.out.println(evaluator.calcPostfix(postfixStr));
  }
}
