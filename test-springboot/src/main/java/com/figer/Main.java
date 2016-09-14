package com.figer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by figer on 9/11/16.
 */
@Controller
@EnableAutoConfiguration
public class Main {
  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Hello World!";
  }

  @RequestMapping("/index")
  @ResponseBody
  String index() {
    return "1 add your profile" +
        "2 introduce yourself to us" +
        "3 purchase a product" ;
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }
}
