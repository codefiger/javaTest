package com.figer.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by figer on 17/04/2017.
 */
public class MsgSendEvent extends ApplicationEvent {

  public MsgSendEvent(String msg) {
    super(msg);
  }
}
