package com.figer.threadlocal;

/**
 * CalculatePrimes -- calculate as many primes as we can in ten seconds 
 */ 

public class CalculatePrimes extends Thread {

    public static final int MAX_PRIMES = 100000;
    public static final int TEN_SECONDS = 2000;

    private volatile boolean finished = false;//共享变量
    
    public void setFinished(boolean finished) {
		this.finished = finished;
	}

    public void run() {
        int[] primes = new int[MAX_PRIMES];
        int count = 0;

        for (int i=2; count<MAX_PRIMES; i++) {

            // Check to see if the timer has expired
            if (finished) {
                break;
            }

            boolean prime = true;
            for (int j=0; j<count; j++) {
                if (i % primes[j] == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                primes[count++] = i;
                System.out.println("Found prime: " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CalculatePrimes calculator = new CalculatePrimes();
        calculator.start();
        
        new Thread(new SetThread(calculator)).start();
        
    }
    
    static class SetThread implements Runnable{
    	private CalculatePrimes calculator;
    	
    	public SetThread(CalculatePrimes calculator) {
			this.calculator = calculator;
		}
    	
		@Override
		public void run() {
			calculator.setFinished(true);
		}
    	
    }
}