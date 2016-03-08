package com.figer.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketReadHandler implements Runnable {
	public static Logger logger = LoggerFactory.getLogger(SocketReadHandler.class);

	private Test test = new Test();

	final SocketChannel socket;
	final SelectionKey sk;

	static final int READING = 0, SENDING = 1;
	int state = READING;

	public SocketReadHandler(Selector sel, SocketChannel c) throws IOException {

		socket = c;

		socket.configureBlocking(false);
		sk = socket.register(sel, 0);

		// 将SelectionKey绑定为本Handler 下一步有事件触发时，将调用本类的run方法。
		// 参看dispatch(SelectionKey k)
		sk.attach(this);

		// 同时将SelectionKey标记为可读，以便读取。
		sk.interestOps(SelectionKey.OP_READ);
		sel.wakeup();
	}

	public void run() {
		try {
			// test.read(socket,input);
			readRequest();
		} catch (Exception ex) {
			logger.debug("readRequest error" + ex);
		}
	}

	/**
	 * 处理读取data
	 * 
	 * @param key
	 * @throws Exception
	 */
	private void readRequest() throws Exception {

		ByteBuffer input = ByteBuffer.allocate(1024);
		input.clear();
		try {

			int bytesRead = socket.read(input);

			// ......

			// 激活线程池 处理这些request
			// requestHandle(new Request(socket, btt));

			// .....

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}