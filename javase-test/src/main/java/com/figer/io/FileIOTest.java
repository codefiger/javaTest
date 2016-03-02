package com.figer.io;

import java.io.RandomAccessFile;

public class FileIOTest {
	public static void main(String[] args) throws Exception {
		String filePath = "/Users/figer/myspace/test/randomAccess";
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		
		file.seek(100);
		System.out.println(file.getFilePointer());
		
		file.write("Hello world".getBytes());
		
		file.close();
	}
}
