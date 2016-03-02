package com.figer.io;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class SystemIOTest {
	public static void main(String[] args) throws Exception {
		OutputStream output = new FileOutputStream("/Users/figer/myspace/test/syso.txt");
		PrintStream printStream = new PrintStream(output);
		System.setOut(printStream);
		System.out.println("hello world");
		
		output.flush();
		output.close();
	}
}
