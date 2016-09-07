package com.figer;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by figer on 9/7/16.
 */
public class AESUtil {
  private static final String KEY = "AES";

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

  /**解密
   * @param content  待解密内容
   * @param password 解密密钥
   * @return
   */
  public static byte[] decrypt(byte[] content, String password) {
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
  }
}
