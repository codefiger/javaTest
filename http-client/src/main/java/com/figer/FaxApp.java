package com.figer;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by figer on 9/7/16.
 */
public class FaxApp {
  private static final Logger LOGGER = LoggerFactory.getLogger(FaxApp.class);

  public static final String DISTRIBUTOR_CODE = "020";
  public static final String PASSWORD = "c1f26021e1a56e9bea8e5f11fd741715";
  public static final String BASE_URL = "114.55.250.134:8080/show-tong-web/tong/service";

  public static final String REGISTER_MAPPING = "";

  public static void main(String[] args) {
    //register();
    String str = "3283faad358bfa57aa6472325df37ce510a270a248201ebebf9d62aa7ec9cb75da99bf58caeb379ec9419d99b1acfe20c9861b83c6792cad7c3c119d62a4e76f4d46ec904258183fa3ad9df8e0ce228fd17e4d361a444a8a88ef918ca612c0ab9f0bbb8fa686f589581aaec3d351d0ed4c34b726f42244582c0cee679d35c574894463c522e40760340621f138f1362bed98b0b3269e68e5e984da8855c9f94f71093e27a930b4ca3ab724eef40643792290a9e34dfbf9f3f03688f949b595ed47ff90f55b61a3912bc0c57aa67162ff561eaba539979ab7923bb0e6345d4d8407296afbcf5dd7e892f9583c0999917d9e35eda06e1a80dcafbd4af85a77e119";
    decryptResponse(str);
  }

  private static void register(){
    LOGGER.info("register request to fax sys...");
    //build content
    Map paramsMap = Maps.newHashMap();
    paramsMap.put("channel", "123");
    paramsMap.put("userPhone", "123455");
    paramsMap.put("userPsw", "123");
    paramsMap.put("userPsw", "123");
    paramsMap.put("userPsw", "123");
    paramsMap.put("userPsw", "123");
    paramsMap.put("userPsw", "123");
    paramsMap.put("userPsw", "123");
    paramsMap.put("userPsw", "123");
    paramsMap.put("userPsw", "123");
    paramsMap.put("userPsw", "123");

    String content = buildRequestContent(paramsMap);
    LOGGER.info("---buildRequestContent:{}", content);

    //http post
    String response = HttpUtil.post(BASE_URL + REGISTER_MAPPING, content);
    LOGGER.info("register response:{}", response);
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
    return AESUtil.encrypt(JSON.toJSONString(map), PASSWORD).toString();
  }

  private static void decryptResponse(String response){
    LOGGER.info(AESUtil.decrypt(response, PASSWORD).toString());
  }
}
