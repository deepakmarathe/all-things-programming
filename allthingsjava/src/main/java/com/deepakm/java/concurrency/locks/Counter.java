package com.deepakm.java.concurrency.locks;

/**
 * Created by dmarathe on 10/5/16.
 */
public class Counter implements CounterAPI {
    private long counter = 0;
    private long limit = 0L;
    private final Lock producerLock = new Lock();
    private final Lock consumerLock = new Lock();

    private volatile boolean isAvailable = false;

    public Counter(int limit) {
        this.limit = limit;

    }

    public void increment() {
        try {
            producerLock.lock();
            if (!isAvailable && counter < limit) {
                long newCount = ++counter;
                isAvailable = true;
                System.out.println("Produced " + counter);
            }
            consumerLock.unlock();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void print() {
        try {
            consumerLock.lock();
            if (isAvailable && counter <= limit) {
                isAvailable = false;
                System.out.println("Consumed " + counter);
            }
            producerLock.unlock();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
