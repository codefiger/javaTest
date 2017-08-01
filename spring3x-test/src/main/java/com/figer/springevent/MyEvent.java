package com.figer.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * Created by figer on 28/07/2017.
 */
public class MyEvent extends ApplicationEvent {
  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  public MyEvent(Object source) {
    super(source);
  }
}
