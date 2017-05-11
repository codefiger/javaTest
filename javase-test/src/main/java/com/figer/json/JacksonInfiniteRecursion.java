package com.figer.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by figer on 05/05/2017.
 */
public class JacksonInfiniteRecursion {
  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    // normal case
    SingleDog single = new SingleDog().setAge(30).setName("Ha");
    System.out.println(objectMapper.writeValueAsString(single));

    // infinite recursion case 1
    single.setPartner(single);
    System.out.println(objectMapper.writeValueAsString(single));

    // infinite recursion case 2
    //两个单身
    Boy boy = new Boy();
    Girl girl = new Girl();

    //然后他们成为男女朋友
    boy.setGirlFriend(girl).setAge(20).setName("梁山伯");
    girl.setBoyFriend(boy).setAge(19).setName("祝英台");

    //互相融化在对方
    System.out.println(objectMapper.writeValueAsString(boy));
  }
}
