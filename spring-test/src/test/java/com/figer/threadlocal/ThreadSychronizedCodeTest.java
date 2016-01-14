package com.figer.threadlocal;
/**
 * 验证synchronized 
 * @author peng.zhang
 *
 */
public class ThreadSychronizedCodeTest {
	 public static void main(String[] args) {
		 Example example = new Example();
		 Example example2 = new Example();

	     Thread t1 = new Thread1(example);
	     Thread t2 = new Thread2(example);
	     Thread t3 = new Thread2(example2);// 加这句验证了只对同一对象synchronized块起执行有序性
	     t1.start();
	     t2.start();
	     t3.start();
	     
	 }
}

class Example{
    private Object object = new Object();
    
    public void execute(){
    	for(int i=0;i<200;i++){
    		System.out.println(Thread.currentThread() + "synchronized外");//t1 + t2 加这句验证了只对synchronized块内部代码起执行有序性
    	}
		synchronized (object){
            for (int i = 0; i < 20; ++i){
                try{
                    Thread.sleep((long) Math.random() * 1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " Hello: " + i);
            }
        }

    }

    public void execute2(){
    	
        synchronized (object){
        	for(int i=0;i<200;i++){
        		System.out.println(Thread.currentThread() + "synchronized外");
        	}
            for (int i = 0; i < 200; ++i){
                try{
                    Thread.sleep((long) Math.random() * 1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "World: " + i);
            }

        }

    }

}

class Thread1 extends Thread{
    private Example example;

    public Thread1(Example example){
        this.example = example;
    }

    @Override
    public void run(){
        example.execute();
    }

}

class Thread2 extends Thread{
    private Example example;

    public Thread2(Example example){
        this.example = example;
    }

    @Override
    public void run(){
        example.execute2();
    }

}
