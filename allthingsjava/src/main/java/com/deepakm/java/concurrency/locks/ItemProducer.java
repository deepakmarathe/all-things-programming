package com.deepakm.java.concurrency.locks;

/**
 * Created by dmarathe on 10/5/16.
 */
public class ItemProducer implements Runnable {
    private final CounterAPI counter;

    public ItemProducer(CounterAPI sharedResource) {
        this.counter = sharedResource;
    }

    @Override
    public void run() {

        while (true) {
            counter.increment();
        }

    }
}
