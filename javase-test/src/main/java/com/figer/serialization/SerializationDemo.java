package com.figer.serialization;

import com.dr.coffee.common.util.JsonUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by figer on 10/04/2017.
 */
public class SerializationDemo {
  public static void main(String[] args) throws Exception {
    String filename = "/Users/figer/dev/test";

    // Object serialization
    /*FileOutputStream out = new FileOutputStream(filename);
    ObjectOutputStream objOut = new ObjectOutputStream(out);
    objOut.writeObject("figer"); //写入字符串对象;
    objOut.writeObject(new Person(18, "figer").setExtra("extra"));
    objOut.flush();*/

    // Object deserialization
    FileInputStream in = new FileInputStream(filename);
    ObjectInputStream objIn = new ObjectInputStream(in);
    String string = (String)objIn.readObject(); //恢复对象;
    Person figer = (Person) objIn.readObject();
    System.out.println(string);
    System.out.println(JsonUtil.toJsonString(figer));
  }
}
