package com.figer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by figer on 9/7/16.
 */
public class FaxApp {
  public static final String DISTRIBUTOR_CODE = "020";
  public static final String PASSWORD = "c1f26021e1a56e9bea8e5f11fd741715";
  public static final String BASE_URL = "114.55.250.134:8080/show-tong-web/tong/service";

  public static final String REGISTER_MAPPING = "";

  public static void main(String[] args) {
    register();
  }

  private static void register(){
    //build content
    Map paramsMap = Maps.newHashMap();
    paramsMap.put("userPhone", "123455");
    paramsMap.put("userPsw", "123");
    String context = buildRequestContent(paramsMap);

    //http post
    String response = HttpUtil.post(BASE_URL + REGISTER_MAPPING, context);
    System.out.println(response);
  }

  private static String buildRequestContent(Map paramsMap) {
    //encrypt request params by AES
    String data = JSON.toJSONString(paramsMap, true);

    //generate sign by MD5
    String sign = MD5Util.md5(DISTRIBUTOR_CODE + data, "UTF-8");

    Map map = Maps.newHashMap();
    map.put("distributor", DISTRIBUTOR_CODE);
    map.put("data", data);
    map.put("sign", sign);
    return JSON.toJSONString(map);
  }
}
