package com.deepakm.java.concurrency.locks;

/**
 * Created by dmarathe on 10/5/16.
 */
public class Counter {
    private long counter = 0;
    private long limit = 0L;
    private final Lock producerLock = new Lock();
    private final Lock consumerLock = new Lock();

    private volatile boolean isAvailable = false;

    public Counter(int limit) {
        this.limit = limit;

    }

    public void increment() throws InterruptedException {
        producerLock.lock();
        if (!isAvailable && counter < limit) {
            long newCount = ++counter;
            isAvailable = true;
            System.out.println("Produced " + counter);
        }
        consumerLock.unlock();
    }

    public void print() throws InterruptedException {
        consumerLock.lock();
        if (isAvailable && counter <= limit) {
            isAvailable = false;
            System.out.println("Consumed " + counter);
        }
        producerLock.unlock();
    }


}
