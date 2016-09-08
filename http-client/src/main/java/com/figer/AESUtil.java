package com.figer;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by figer on 9/7/16.
 */
public class AESUtil {
  /*private static final String KEY = "AES";

  public static byte[] encrypt(String content, String password) {
    try {
      KeyGenerator kgen = KeyGenerator.getInstance(KEY);
      //防止*nux下 随机生成key
      SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
      secureRandom.setSeed(password.getBytes());
      kgen.init(128, secureRandom);
      SecretKey secretKey = kgen.generateKey();
      byte[] enCodeFormat = secretKey.getEncoded();
      SecretKeySpec key = new SecretKeySpec(enCodeFormat, KEY);
      Cipher cipher = Cipher.getInstance("AES");// 创建密码器
      byte[] byteContent = content.getBytes("utf-8");
      cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
      byte[] result = cipher.doFinal(byteContent);
      return result; // 加密
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  *//**解密
   * @param content  待解密内容
   * @param password 解密密钥
   * @return
   *//*
  public static byte[] decrypt(byte[] content, String password) {
    try {
      KeyGenerator kgen = KeyGenerator.getInstance(KEY);
      //防止*nux下 随机生成key
      SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
      secureRandom.setSeed(password.getBytes());
      kgen.init(128, secureRandom);
      SecretKey secretKey = kgen.generateKey();

      byte[] enCodeFormat = secretKey.getEncoded();
      SecretKeySpec key = new SecretKeySpec(enCodeFormat, KEY);
      Cipher cipher = Cipher.getInstance("AES");// 创建密码器
      cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
      byte[] result = cipher.doFinal(content);
      return result; // 加密
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    }
    return null;
  }*/

  private static final String AES = "AES";

  /**
   * 加密
   */
  public static byte[] encrypt(byte[] src, String key) throws Exception {
    Cipher cipher = Cipher.getInstance(AES);
    SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);
    cipher.init(Cipher.ENCRYPT_MODE, securekey);//设置密钥和加密形式
    return cipher.doFinal(src);
  }

  /**
   * 解密
   */
  public static byte[] decrypt(byte[] src, String key)  throws Exception  {
    Cipher cipher = Cipher.getInstance(AES);
    SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), AES);//设置加密Key
    cipher.init(Cipher.DECRYPT_MODE, securekey);//设置密钥和解密形式
    return cipher.doFinal(src);
  }

  /**
   * 二行制转十六进制字符串
   *
   * @param b
   * @return
   */
  public static String byte2hex(byte[] b) {
    String hs = "";
    String stmp = "";
    for (int n = 0; n < b.length; n++) {
      stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
      if (stmp.length() == 1)
        hs = hs + "0" + stmp;
      else
        hs = hs + stmp;
    }
    return hs.toUpperCase();
  }

  public static byte[] hex2byte(byte[] b) {
    if ((b.length % 2) != 0)
      throw new IllegalArgumentException("长度不是偶数");
    byte[] b2 = new byte[b.length / 2];
    for (int n = 0; n < b.length; n += 2) {
      String item = new String(b, n, 2);
      b2[n / 2] = (byte) Integer.parseInt(item, 16);
    }
    return b2;
  }

  /**
   * 解密
   *
   * @param data
   * @return
   * @throws Exception
   */
  public final static String decrypt(String data, String password) {
    try {
      return new String(decrypt(hex2byte(data.getBytes()), password));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 加密
   *
   * @param data
   * @return
   * @throws Exception
   */
  public final static String encrypt(String data, String password) {
    try {
      return byte2hex(encrypt(data.getBytes(), password));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
