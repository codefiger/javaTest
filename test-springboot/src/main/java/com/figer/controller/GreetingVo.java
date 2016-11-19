package com.figer.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by figer on 17/10/2016.
 */
public class GreetingVo {
  private final long id;
  private final String content;

  public GreetingVo(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  @JsonProperty(required = true)
  @ApiModelProperty(notes = "The name of the user", required = true)
  public String getContent() {
    return content;
  }
}
