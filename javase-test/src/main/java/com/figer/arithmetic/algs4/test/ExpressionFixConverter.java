package com.figer.arithmetic.algs4.test;

import com.figer.arithmetic.algs4.collections.LinkedListQueue;
import com.figer.arithmetic.algs4.collections.LinkedListStack;


/**
 * Created by figer on 22/03/2017.
 */
public final class ExpressionFixConverter {
  public static void main(String[] args) {
    ExpressionFixConverter converter = new ExpressionFixConverter();

    Evaluator evaluator = new Evaluator();
    String postfixStr = converter.infix2Postfix("1 + 2 + 3 + 4 + 5 * 6 - 5 / 5");
    System.out.println(postfixStr);
    double value = evaluator.calcPostfix(postfixStr);
    System.out.println(value);
  }

  private enum Operation{
    ADD("+", 0),
    SUBTRACT("-", 0),
    DIVIDE("/", 1),
    MULTIPLY("*", 1),
    ;
    private String opStr;
    private int priority;

    public String getOpStr(){
      return this.opStr;
    }

    Operation(String opStr, int priority) {
      this.opStr = opStr;
      this.priority = priority;
    }

    public boolean higher(Operation b){
      return this.priority > b.priority;
    }

    public boolean equalsPriority(Operation b){
      return this.priority == b.priority;
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

  LinkedListStack<Double> vals = new LinkedListStack<>();
  LinkedListStack<Operation> ops = new LinkedListStack<>();

  public String infix2Postfix(String infix){
    StringBuffer postfixStr = new StringBuffer();
    String values[] = infix.split(" ");
    for (String value : values) {
      if(Operation.isOperation(value)){
        Operation op = Operation.getOperation(value);
        if(ops.isEmpty()){
          ops.push(op);
        }else{
          Operation lastOp = ops.pop();
          if(op.higher(lastOp)){
            ops.push(op);
            ops.push(lastOp);
          }else{
            ops.push(lastOp);
            ops.push(op);
          }
        }
      }else{
        vals.push(Double.parseDouble(value));
      }
    }

    LinkedListQueue<Operation> tempOps = new LinkedListQueue<>();
    LinkedListQueue<Double> tempVals = new LinkedListQueue<>();
    for(Operation operation : ops){
      tempOps.enqueue(operation);
    }
    for(Double value : vals){
      tempVals.enqueue(value);
    }

    for(Operation operation : tempOps){
      ops.push(operation);
    }
    for(Double value : tempVals){
      vals.push(value);
    }

    Operation first = ops.pop();
    tempOps.enqueue(first);
    for(Operation operation : ops) {
      if(!operation.equalsPriority(first)){
        for (int i = 0; i <= tempOps.size() && !vals.isEmpty(); i++) {
          postfixStr.append(vals.pop() + " ");
          //System.out.print(vals.pop() + " ");
        }
        for(Operation op : tempOps){
          postfixStr.append(op.getOpStr() + " ");
          //System.out.print(op.getOpStr() + " ");
        }

        first = operation;
      }
      tempOps.enqueue(operation);
    }

    //print
    for (Double num : vals) {
      postfixStr.append(num + " ");
      //System.out.print(num + " ");
    }
    for(Operation op : tempOps){
      postfixStr.append(op.getOpStr() + " ");
      //System.out.print(op.getOpStr() + " ");
    }
    return postfixStr.toString();
  }
}
