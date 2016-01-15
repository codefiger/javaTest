package com.figer.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequenceNumber {
	private static final Logger LOGGER = LoggerFactory.getLogger(SequenceNumber.class);
	
	//通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
	private ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		@Override
		public Integer initialValue(){
			return 0;
		}
	};
	
	public Integer getNextNum(){
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
	
	static class GetSequeceThread implements Runnable{
		private SequenceNumber seqGenetor ;
		
		public GetSequeceThread(SequenceNumber seqGenetor) {
			this.seqGenetor = seqGenetor;
		}
		
		@Override
		public void run() {
			for(int i = 0;i<10;i++){
				LOGGER.info("seqId:{}", seqGenetor.getNextNum());
			}
		}
	}
	
	public static void main(String[] args) {
		SequenceNumber sequenceNumber = new SequenceNumber();
		Thread getSequeceThread1 = new Thread(new GetSequeceThread(sequenceNumber));
		Thread getSequeceThread2 = new Thread(new GetSequeceThread(sequenceNumber));
		Thread getSequeceThread3 = new Thread(new GetSequeceThread(sequenceNumber));
		
		getSequeceThread1.start();
		getSequeceThread2.start();
		getSequeceThread3.start();
		
	}
}
