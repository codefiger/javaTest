package com.figer;

import java.util.Arrays;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * Created by figer on 5/24/16.
 */
public class PostmanUtils {
  public static void main(String[] args) {
    String formdata = "instid:2\n" +
        "version:V2.0\n" +
        "hcid:5\n" +
        "fundcode:400001\n" +
        "melonmethod:1\n";
    formdataToScripts(formdata);
  }

  public static void formdataToScripts(String fromdata){
    String[] strs = fromdata.split("\n");

    printNewFormdata(strs);

    printPreScript(strs);
  }

  private static void printPreScript(String[] strs) {
    System.out.println();
    System.out.println("===============pre-script:");
    System.out.println("var password = \"201605\";");

    Map<String, String> map = Maps.newHashMap();
    for (int i = 0; i <strs.length; i++) {
      String[] entry = strs[i].split(":");
      map.put(entry[0], entry[1]);
    }

    for (String key: map.keySet()){
      System.out.println("postman.setEnvironmentVariable(\"" + key + "\", \"" + map.get(key) + "\");");
    }

    System.out.println();
    System.out.println("var str = password ");
    Object[] keys = map.keySet().toArray();
    //TODO:  sorting
    Arrays.sort(keys);
    for (Object key : keys){
      System.out.println("+ \"" + key + "\" +  environment." + key);
    }
    System.out.println("+ password; ");
    System.out.println("hash = CryptoJS.MD5(str).toString();");
    System.out.println("postman.setEnvironmentVariable('signmsg', hash.toUpperCase());");
  }

  private static void printNewFormdata(String[] strs) {
    System.out.println("===============formdata:");
    for (int i = 0; i <strs.length; i++) {
      String key = strs[i].split(":")[0];
      System.out.println(key + ":{{" + key + "}}");
    }
    System.out.println("signmsg:{{signmsg}}");
  }
}
