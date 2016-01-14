package com.figer.threadlocal;

import java.util.Random;

/**
 * 可见性：一个线程修改共享变量保证所有线程能看到这个修改（个人理解就是及时将共享值修改从工作内存同步到主内存）
 * 
 * 验证volatile保证多线程可见性
 * 运行程序可以发现线程可能无法读取a的修改，但volatile修饰的b总是能及时让所有线程读到它的修改
 * 
 * ps：被volatile修饰的变量都不拷贝副本到工作内存，任何修改直接写在主内存，所以对变量的修改可以立马让所有线程读到。
 * @author peng.zhang
 *
 */

public class VolatileTest {
	private int a;
	private volatile int b;
	
	public void setA(int a){
		this.a = a;
	}
	
	public void setB(int b){
		this.b = b;
	}
	
	public void addA(int num){
		a = a + num;
	}
	
	public void addB(int num){
		b = b + num;
	}
	
	public int getA(){
		return a;
	}
	
	public int getB(){
		return b;
	}
	
	static class ModifyA implements Runnable{
		private VolatileTest volatileTest;
		private int modifyNum;
		
		public ModifyA(VolatileTest volatileTest, int modifyNum) {
			this.volatileTest = volatileTest;
			this.modifyNum = modifyNum;
		}
		
		public void run(){
			for(int i=modifyNum;i<modifyNum + 10;i++){
				volatileTest.setA(i);
				System.out.println(Thread.currentThread() + "modify a: " + volatileTest.getA());
			}
		}
	}
	
	static class ModifyB implements Runnable{
		private VolatileTest volatileTest;
		private int modifyNum;
		
		public ModifyB(VolatileTest volatileTest, int modifyNum) {
			this.volatileTest = volatileTest;
			this.modifyNum = modifyNum;
		}
		
		public void run(){
			for(int i=modifyNum;i<modifyNum+10;i++){
				volatileTest.setB(i);
				try {
					Thread.sleep(new Random().nextInt(1000));//验证volatile修饰的变量不会拷贝到工作内存，每次直接操作主内存中的值
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread() + " modify b: " + volatileTest.getB());
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		VolatileTest volatileTest = new VolatileTest();
		Thread threadA1 = new Thread(new ModifyA(volatileTest, 10), "A1");
		Thread threadA2 = new Thread(new ModifyA(volatileTest, 1000), "A2");
		threadA1.start();
		threadA2.start();
		threadA1.join();//Waits for this thread to die.即等待A1运行完主线程才继续运行
		threadA2.join();
		
		System.out.println("----------------------------------");
		Thread threadB1 = new Thread(new ModifyB(volatileTest, 10), "B1");
		Thread threadB2 = new Thread(new ModifyB(volatileTest, 1000), "B2");
		threadB1.start();
		threadB2.start();
		threadB1.join();
		threadB2.join();
	}
}
