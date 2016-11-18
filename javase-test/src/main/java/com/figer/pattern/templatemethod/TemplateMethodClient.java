package com.figer.pattern.templatemethod;

/**
 * Created by figer on 18/11/2016.
 */
public class TemplateMethodClient {
  public static void main(String[] args) {
    SubmitAbsTemplate submitMethod = new MessageQueueSubmit();
    submitMethod.submit();

    System.out.println("-------------------");
    submitMethod = new NullSubmit();
    submitMethod.submit();
  }
}
