package com.figer.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by figer on 17/04/2017.
 */
public class MsgTestEvent extends ApplicationEvent {

  public MsgTestEvent(String msg) {
    super(msg);
  }
}
