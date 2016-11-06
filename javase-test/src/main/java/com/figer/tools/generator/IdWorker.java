package com.figer.tools.generator;


import java.util.UUID;

/**
 * Created by figer on 25/10/2016.
 */
public class IdWorker {
  private final long workerId;
  private final static long twepoch = 1288834974657L;
  private long sequence = 0L;
  private final static long workerIdBits = 4L;
  public final static long maxWorkerId = -1L ^ -1L << workerIdBits;
  private final static long sequenceBits = 10L;

  //机器id偏移
  private final static long workerIdShift = sequenceBits;
  //时间戳偏移
  private final static long timestampLeftShift = sequenceBits + workerIdBits;
  public final static long sequenceMask = -1L ^ -1L << sequenceBits;

  private long lastTimestamp = -1L;

  public IdWorker(final long workerId) {
    super();
    if (workerId > this.maxWorkerId || workerId < 0) {
      throw new IllegalArgumentException(String.format(
          "worker Id can't be greater than %d or less than 0",
          this.maxWorkerId));
    }
    this.workerId = workerId;
  }

  public synchronized long nextId() {
    long timestamp = this.timeGen();
    if (this.lastTimestamp == timestamp) {
      this.sequence = (this.sequence + 1) & this.sequenceMask;
      if (this.sequence == 0) {
        System.out.println("###########" + sequenceMask);
        timestamp = this.tilNextMillis(this.lastTimestamp);
      }
    } else {
      this.sequence = 0;
    }
    if (timestamp < this.lastTimestamp) {
      try {
        throw new Exception(
            String.format(
                "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                this.lastTimestamp - timestamp));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    this.lastTimestamp = timestamp;
    long nextId = ((timestamp - twepoch << timestampLeftShift))
        | (this.workerId << this.workerIdShift) | (this.sequence);
    System.out.println("timestamp:" + timestamp + ",timestampLeftShift:"
        + timestampLeftShift + ",nextId:" + nextId + ",workerId:"
        + workerId + ",sequence:" + sequence);
    return nextId;
  }

  private long tilNextMillis(final long lastTimestamp) {
    long timestamp = this.timeGen();
    while (timestamp <= lastTimestamp) {
      timestamp = this.timeGen();
    }
    return timestamp;
  }

  private long timeGen() {
    return System.currentTimeMillis();
  }


  public static void main(String[] args){
    System.out.println(Long.MAX_VALUE);
    System.out.println((Long.MAX_VALUE + "").length());
    System.out.println(("" + System.currentTimeMillis()).length());
    System.out.println(maxWorkerId);
    IdWorker worker2 = new IdWorker(2);
      //System.out.println(Long.toBinaryString(worker2.nextId()));
    for (int i = 0; i <10 ; i++) {
      System.out.println((worker2.nextId() + "").length());
    }


    System.out.println("-------");

    System.out.println(UUID.randomUUID());
    System.out.println(UUID.randomUUID().hashCode());
    System.out.println(-1L ^ (-1L << 5L));
    System.out.println(Long.toBinaryString(System.currentTimeMillis()));
    //System.out.println(twepoch<<14);
    System.out.println("----");
    System.out.println(System.currentTimeMillis());
    System.out.println(twepoch);
    System.out.println(Long.toBinaryString(System.currentTimeMillis() - twepoch).length());
    System.out.println(System.currentTimeMillis() - twepoch << 14);
    System.out.println(System.currentTimeMillis() << 14);

  }

}