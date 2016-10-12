package com.deepakm.java.concurrency.locks;

/**
 * Created by dmarathe on 10/5/16.
 */
public class ItemProducer implements Runnable {
    private final Counter counter;

    public ItemProducer(Counter sharedResource) {
        this.counter = sharedResource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                counter.increment();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
