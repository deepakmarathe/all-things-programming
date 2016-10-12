package com.deepakm.java.concurrency.locks;

/**
 * Created by dmarathe on 10/5/16.
 */
public class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
