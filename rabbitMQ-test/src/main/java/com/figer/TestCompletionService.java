package com.figer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestCompletionService {

  private static final ExecutorService executor = Executors.newFixedThreadPool(10);

  private static final Random r = new Random();	// 每个子任务随机等待一个时间，以模拟子任务的执行时间

  private static final int TASK_TIMEOUT = 5;	// 设定最长超时时间为5s

  /**
   * @param args
   */
  public static void main(String[] args) {

    final long startTime = System.currentTimeMillis();
    final long endTime = startTime + (TASK_TIMEOUT * 1000L);

    CompletionService<SubTaskResult> cs = new ExecutorCompletionService<SubTaskResult>(executor);
    List<Future<SubTaskResult>> futureList = new ArrayList<Future<SubTaskResult>>();
    for (int i = 0; i < 10; i++) {
      Future<SubTaskResult> f = cs.submit(new Callable<SubTaskResult>() {
        @Override
        public SubTaskResult call() throws Exception {
          try {
            // 子任务等待一个随机时间。如果这里不是+1而是+2，就可以模拟出现超时的情况
            long waitTime = (r.nextInt(TASK_TIMEOUT) + 1) * 1000L;
            Thread.sleep(waitTime);
            return new SubTaskResult(Thread.currentThread().getName() +
                ", sub thread sleepTime=" + waitTime + "ms");
          } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() +
                ", catch an interrupted exception, interrupted status=" + Thread.interrupted());
            throw e;
          }
        }
      });
      futureList.add(f);
    }

    try {
      for (int i = 0; i < 10; i++) {
        long timeLeft = endTime - System.currentTimeMillis();
        try {
          // timeLeft可能为负数，由于j.u.c中所有负数与0等同，所以不用单独对负数做判断
          Future<SubTaskResult> responseFuture = cs.poll(timeLeft, TimeUnit.MILLISECONDS);
          if (responseFuture == null) {
            throw new TimeoutException("waiting timeout");
          }
          SubTaskResult response = responseFuture.get();
          System.out.println(response.getResult() + ", main thread waitFor: " + timeLeft);
        } catch (InterruptedException e) {
          e.printStackTrace();
          Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
          e.printStackTrace();
        }
      }
    } catch (TimeoutException e) {
      // 如果超时则终止所有任务（注意cancel只是调用子线程的interrupt方法，至于能不能中断得看子线程是否支持）
      // 因为对于已经完成的任务调用Future.cancel不起效，所以不需要排除那些已经完成的任务
      for (Future<SubTaskResult> future : futureList) {
        future.cancel(true);
      }
      e.printStackTrace();
    } finally {
      executor.shutdown();
      System.out.println("used: " + (System.currentTimeMillis() - startTime));
    }
  }

}

class SubTaskResult {
  private final String result;
  public SubTaskResult(String result) {
    this.result = result;
  }

  public String getResult() {
    return result;
  }
}