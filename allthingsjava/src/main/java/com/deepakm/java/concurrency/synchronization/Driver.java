package com.deepakm.java.concurrency.synchronization;

/**
 * Created by dmarathe on 10/5/16.
 */
public class Driver {
    public static void main(String[] args) {

        Counter counter = new Counter();
        Thread t1 = new Thread(new CounterThread(counter), "t1");
        Thread t2 = new Thread(new CounterThread(counter), "t2");
        t1.start();
        t2.start();
    }
}
