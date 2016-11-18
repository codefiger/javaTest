package com.figer.pattern.templatemethod;

/**
 * Created by figer on 18/11/2016.
 */
public class TemplateMethodClient {
  public static void main(String[] args) {
    OrderSubmitTemplate submitMethod = new MessageQueueOrderSubmit();
    submitMethod.submit();

    System.out.println("-------------------");
    submitMethod = new NullOrderSubmit();
    submitMethod.submit();
  }
}
