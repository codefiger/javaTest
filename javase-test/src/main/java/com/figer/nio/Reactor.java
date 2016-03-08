package com.figer.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Reactor设计模式和观察者模式非常相似，但是它比观察者模式复杂，Reactor设计模式使用一个Selector对象相当于观察模者式里面的观察者，每个
 * SocketServerChannal 实例和SocketChannal实例都相当于被观察者，当然它们需要在Selector对象里面注册，它们注册之后每个Channal实例都会分配一个 SelectionKey对象，
 * SelectionKey对象可以attach(附带)一个对象，当Selector里面注册的channal有事件发生 时，Selector就会产生一个遍历，
 * 这时候可以在遍历的时候用attachment()方法把每个SelectionKey里面attach的对象o 提出来，你可以在这个时候运行在o对象所属类O里面所定义的方法，
 * 在这个方法里面可以使用socket.read()方法进行读取网络数据，将数据读出 后，可以将这些数据处理线程做成一个线程池，这样，数据读出后，立即扔到线程池中，这样加速处理速度。
 * 注意在每次遍历提出SelectionKey，对注册的channal的读或写进行处理完毕之后，需要对channal进行重新注册，重新attach()对象。
 * @author figer
 *
 */
public class Reactor implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Reactor.class);
	final Selector selector;
	final ServerSocketChannel serverSocket;

	public Reactor(int port) throws IOException {
		selector = Selector.open();
		serverSocket = ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(),port);
		serverSocket.socket().bind(address);
	
		serverSocket.configureBlocking(false);
		//向selector注册该channel
		SelectionKey sk =serverSocket.register(selector,SelectionKey.OP_ACCEPT);
		
		logger.debug("-->Start serverSocket.register!");
		
		//利用sk的attache功能绑定Acceptor 如果有事情，触发Acceptor
		sk.attach(new Acceptor());
		logger.debug("-->attach(new Acceptor()!");

	
	}

	public void run() { // normally in a new Thread
		try {
			while (!Thread.interrupted()) {
				selector.select();
				Set selected = selector.selectedKeys();
				Iterator it = selected.iterator();
				// Selector如果发现channel有OP_ACCEPT或READ事件发生，下列遍历就会进行。
				while (it.hasNext()) {
					// 来一个事件 第一次触发一个accepter线程
					// 以后触发SocketReadHandler
					dispatch((SelectionKey) (it.next()));
					selected.clear();
				}
			}
		} catch (IOException ex) {
			logger.debug("reactor stop!" + ex);
		}
	}

	// 运行Acceptor或SocketReadHandler
	public void dispatch(SelectionKey k) {
		
		Runnable r = (Runnable)(k.attachment());
		if (r != null) {
			
		}
		
	}

	class Acceptor implements Runnable { // inner
		public void run(){
			try {
				logger.debug("-->ready for accept!");
				SocketChannel c = serverSocket.accept();
				if (c != null)
				//调用Handler来处理channel
				new SocketReadHandler(selector, c);
			}catch(IOException ex) {
				logger.debug("accept stop!"+ex);
			}
		}
	}
}