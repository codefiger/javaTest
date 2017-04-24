package com.figer.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by figer on 17/04/2017.
 */
@Component
public class MsgHandler {

  @EventListener //key point
  @Async
  public void handleMsgSendEvent(MsgSendEvent event) throws InterruptedException {
    System.out.println("start");
    System.out.println("Handler: message请发送到:" + event.getSource());
    System.out.println("end");
  }

 /* @EventListener //key point
  @Async
  public void handleMsgTestEvent(MsgSendEvent event) throws InterruptedException {
    System.out.println("Test Handler: message请发送到:" + event.getSource());
  }*/
}
