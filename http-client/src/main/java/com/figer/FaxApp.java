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
  public static final String BASE_URL = "http://114.55.250.134:8080/show-tong-web/tong/service";


  public static void main(String[] args) throws Exception {
    String response = HttpUtil.post("http://117.114.130.146:9988/api/trade/purchase", "121212");
    register();
    /*String AESStr = AESUtil2Fax.encrypt("{\n" +
        "\t\"userPhone\":\"123455\",\n" +
        "\t\"userPsw\":\"123\",\n" +
        "\t\"channel\":\"123\"\n" +
        "}", PASSWORD).toString();
    System.out.println(AESStr);*/
  }

  private static void register() throws Exception {
    LOGGER.info("register request to fax sys...");
    //build content
    Map paramsMap = Maps.newHashMap();
    paramsMap.put("channel", "UserRegisterAccountRequest");
    paramsMap.put("userPhone", "13800000000");
    paramsMap.put("userPsw", "123456");
    paramsMap.put("userPayPsw", "123456");
    paramsMap.put("userName", "figer");
    paramsMap.put("certType", "0");
    paramsMap.put("certificatesId", "310225201608283345");
    paramsMap.put("bankCode", "0002");
    //paramsMap.put("issueBankBranch", "123");
    paramsMap.put("bankCard", "6222111122223333");
    paramsMap.put("issueMobile", "13800000000");
    paramsMap.put("TransactionAccountID", "8801000001");

    String content = buildRequestContent(paramsMap);
    LOGGER.info("---buildRequestContent : {}", content);

    LOGGER.info("---------------------------------");
    //http post

    //HttpUtil.get(BASE_URL);
   //String response = HttpUtil.post(BASE_URL, content);
    //LOGGER.info("register response:{}", response);
  }

  private static String buildRequestContent(Map paramsMap) throws Exception {
    //encrypt request params by AES
    String data = JSON.toJSONString(paramsMap, true);
    System.out.println(data);

    //generate sign by MD5
    String sign = MD5Util.md5(DISTRIBUTOR_CODE + data, "UTF-8");

    Map map = Maps.newHashMap();
    map.put("distributor", DISTRIBUTOR_CODE);
    map.put("data", data);
    map.put("sign", sign);
    return AESUtil2Fax.encrypt(JSON.toJSONString(map), PASSWORD).toString();
  }

  private static void decryptResponse(String response) throws Exception {
    LOGGER.info(AESUtil2Fax.decrypt(response, PASSWORD));
  }
}
