package com.figer.json;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by figer on 05/05/2017.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name", scope = Boy.class)
public class Boy extends SingleDog{
  private Girl girlFriend;

  public Girl getGirlFriend() {
    return girlFriend;
  }

  public Boy setGirlFriend(Girl girlFriend) {
    this.girlFriend = girlFriend;
    return this;
  }
}
