package com.figer.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {
	public static void main(String[] args) throws Exception{
		String fileName = "/Users/figer/myspace/test/nioChannel";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		
		FileChannel fileChannel = file.getChannel();
		//create buffer with capacity of 48 bytes
		ByteBuffer byteBuffer = ByteBuffer.allocate(48);
		
		int bytesRead = fileChannel.read(byteBuffer);
		System.out.println("read:" + bytesRead);
		
		byteBuffer.flip();//make buffer ready for read
		
		while(byteBuffer.hasRemaining()){
			System.out.print((char)byteBuffer.get());
		}
		
		byteBuffer.clear(); //make buffer ready for writing
		
		file.close();
	}
	
	
}
