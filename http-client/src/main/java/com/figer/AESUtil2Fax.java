package com.figer;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by figer on 9/12/16.
 */
public class AESUtil2Fax {
  public static byte[] generateSecretKey(String password) throws NoSuchAlgorithmException {
    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
    kgen.init(128, secureRandom);
    secureRandom.setSeed(password.getBytes());
    SecretKey secretKey = kgen.generateKey();
    return secretKey.getEncoded();
  }

  public static String decrypt(String cipherText,String password) throws Exception {
    byte[] enCodeFormat = generateSecretKey(password);
    SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
    byte[] result = cipher.doFinal(Hex.decodeHex(cipherText.toCharArray()));
    return new String(result);
  }

  public static String encrypt(String plainText,String password) throws Exception {
    byte[] enCodeFormat = generateSecretKey(password);
    SecretKeySpec sKeySpec = new SecretKeySpec(enCodeFormat, "AES");
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
    byte[] result =cipher.doFinal(plainText.getBytes());
    return new String(result);
  }
}
