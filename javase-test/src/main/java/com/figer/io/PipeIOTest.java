package com.figer.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * java IO中的管道为运行在同一个JVM中的两个线程提供了通信的能力
 * 
 * @author figer
 *
 */
public class PipeIOTest {
	public static void main(String[] args) throws IOException {
		final PipedOutputStream output = new PipedOutputStream();
		final PipedInputStream input = new PipedInputStream(output);

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					output.write("Hello world".getBytes());
				} catch (IOException e) {
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					int data = input.read();
					while(data != -1){
						System.out.print((char)data);
						data = input.read();
					}
				} catch (Exception e) {
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}
}
