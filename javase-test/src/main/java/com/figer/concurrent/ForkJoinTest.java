package com.figer.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/**
 * forkjoin框架把大任务分割成若干个小任务
 * 
 * 如下假设一个大任务1+..+100需要99*100ms,使用forkjoin分解任务并发执行将提高效率
 * @author figer
 *
 */
public class ForkJoinTest {
	public static void main(String[] args) {
		int num = 100;
		ForkJoinPool pool = new ForkJoinPool();
		long startTime = System.currentTimeMillis();
		Counter counter = new Counter(1, num);
		try {
			System.out.println(pool.submit(counter).get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("forkjoin use:" + (endTime - startTime));
		
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum += i;
		}
		System.out.println(sum);
		System.out.println("normal use:" + (System.currentTimeMillis() - endTime));
	}
}

class Counter extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;

	private static final int THRESHOLD = 2;

	int intStart;
	int intEnd;

	public Counter(int intStart, int intEnd) {
		this.intEnd = intEnd;
		this.intStart = intStart;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (intEnd - intStart) <= THRESHOLD;
		if (canCompute) {
			for (int i = intStart; i <= intEnd; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sum += i;
			}
		} else {
			int intMiddle = (intEnd + intStart) / 2;
			Counter counterLeft = new Counter(intStart, intMiddle);
			Counter counterRight = new Counter(intMiddle + 1, intEnd);
			counterLeft.fork();
			counterRight.fork();
			int leftResult = counterLeft.join();
			int rightResult = counterRight.join();
			sum = leftResult + rightResult;
		}
		return sum;
	}
}

