package com.figer.nio;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class NIOTest {
	@Test
	public void testScatter() throws Exception {
		String fileName = "/Users/figer/myspace/test/nioChannel";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");

		FileChannel fileChannel = file.getChannel();

		ByteBuffer header = ByteBuffer.allocate(48);
		ByteBuffer body = ByteBuffer.allocate(1024);
		ByteBuffer[] buffers = { header, body };

		// 当一个buffer被写满后，channel紧接着向另一个buffer中写。
		long bytesRead = fileChannel.read(buffers);
		header.flip();
		body.flip();
		System.out.println(bytesRead);
		printBuffer(header);
		System.out.println("-----");
		printBuffer(body);
		file.close();

	}

	@Test
	public void testGather() throws Exception {
		String fileName = "/Users/figer/myspace/test/nioChannel";
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");

		FileChannel fileChannel = file.getChannel();

		ByteBuffer header = ByteBuffer.allocate(48);
		ByteBuffer body = ByteBuffer.allocate(1024);
		ByteBuffer[] buffers = { header, body };
		header.clear();
		body.clear();

		header.put("Hello world".getBytes());
		body.put("   My name is figer".getBytes());

		long bytesWrite = fileChannel.write(buffers);
		System.out.println(bytesWrite);
		file.close();
	}

	@Test
	public void testChannel() throws Exception {
		String fromFileName = "/Users/figer/myspace/test/fromNioChannel";
		RandomAccessFile fromFile = new RandomAccessFile(fromFileName, "rw");
		FileChannel fromChannel = fromFile.getChannel();

		String toFileName = "/Users/figer/myspace/test/nioChannel";
		RandomAccessFile toFile = new RandomAccessFile(toFileName, "rw");
		FileChannel toChannel = toFile.getChannel();

		long position = 0;
		long count = fromChannel.size();
		// 从position开始，共count个 byte数据传输到toChannel
		toChannel.transferFrom(fromChannel, position, count);
		// 将数据从FileChannel传输到其他的channel中
		fromChannel.transferTo(position, count, toChannel);

	}

	@Test
	public void testSelector() throws Exception {
		SocketChannel channel = SocketChannel.open();
		Selector selector = Selector.open();
		channel.configureBlocking(false);
		SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0)
				continue;
			Set selectedKeys = selector.selectedKeys();
			Iterator keyIterator = selectedKeys.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey key2 = (SelectionKey) keyIterator.next();
				if (key2.isAcceptable()) {
					// a connection was accepted by a ServerSocketChannel.
					System.out.println("a connection was accepted by a ServerSocketChannel.");
				} else if (key2.isConnectable()) {
					// a connection was established with a remote server.
					System.out.println("a connection was established with a remote server.");
				} else if (key2.isReadable()) {
					// a channel is ready for reading
					System.out.println("a channel is ready for reading");
				} else if (key2.isWritable()) {
					// a channel is ready for writing
					System.out.println("a channel is ready for writing");
				}
				keyIterator.remove();
			}
		}
	}

	@Test
	public void testSocketChannel() throws Exception {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));

		ByteBuffer buf = ByteBuffer.allocate(1024);
		int bytesRead = socketChannel.read(buf);
		buf.flip();
		System.out.println(bytesRead);
		printBuffer(buf);
		socketChannel.close();

	}

	@Test
	public void testServerSocketChannel() throws Exception{
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		serverSocketChannel.socket().bind(new InetSocketAddress(9999));
		
		ByteBuffer buffer = ByteBuffer.allocate(48);
		buffer.put("10000".getBytes());

		while(true){
			
			SocketChannel socketChannel = serverSocketChannel.accept();
			if (socketChannel != null) {
				socketChannel.write(buffer);
				socketChannel = null;
			}
		}
	}

	private void printBuffer(ByteBuffer buffer) {
		while (buffer.hasRemaining()) {
			System.out.print((char)buffer.get());
		}
	}
}
