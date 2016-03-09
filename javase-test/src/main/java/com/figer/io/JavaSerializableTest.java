package com.figer.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class JavaSerializableTest {
	public static void main(String[] args) throws Exception{
		for (int i = 0; i < 10; i++) {
			AObject aObject = new AObject();
			
			long startTime = System.currentTimeMillis();
			ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
			ObjectOutputStream output = new ObjectOutputStream(byteOutput);
			output.writeObject(aObject);
			output.flush();
			output.close();
			byteOutput.close();
			byte[] bs = byteOutput.toByteArray();
			System.out.println("serialize use :" + (System.currentTimeMillis() - startTime) + "ms");
			System.out.println("serialized bytes size:" + bs.length);
			
			
			startTime = System.currentTimeMillis();
			ByteArrayInputStream byteInput = new ByteArrayInputStream(bs);
			ObjectInputStream input = new ObjectInputStream(byteInput);
			System.out.println(input.readObject().getClass());
			input.close();
			byteInput.close();
			System.out.println("unserialize use :" + (System.currentTimeMillis() - startTime) + "ms");
			System.out.println("-------------");
		}
	}
}

class BObject implements Serializable{}

class AObject implements Serializable{
	private String a = "com";
	private String b = "figer";
	private String c = "io";
	
	private int i = 100;
	private int j = 1000;
	private long l = 10L;
	
	private boolean isA = true;
	private boolean isB = false;
	
	private BObject bObject = new BObject();
	private BObject b2Object = new BObject();
	
}
