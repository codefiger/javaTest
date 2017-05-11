package com.figer.json;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by figer on 05/05/2017.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name", scope = Girl.class)
public class Girl extends SingleDog{
  private Boy boyFriend;

  public Boy getBoyFriend() {
    return boyFriend;
  }

  public Girl setBoyFriend(Boy boyFriend) {
    this.boyFriend = boyFriend;
    return this;
  }
}
