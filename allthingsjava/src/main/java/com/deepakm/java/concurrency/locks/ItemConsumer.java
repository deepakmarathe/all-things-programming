package com.deepakm.java.concurrency.locks;

/**
 * Created by dmarathe on 10/5/16.
 */
public class ItemConsumer implements Runnable {
    private final Counter counter ;
    public ItemConsumer(final Counter sharedResource){
        this.counter = sharedResource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                counter.print();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
