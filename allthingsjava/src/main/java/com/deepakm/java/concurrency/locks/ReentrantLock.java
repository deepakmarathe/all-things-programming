package com.deepakm.java.concurrency.locks;

/**
 * Created by dmarathe on 10/5/16.
 */
public class ReentrantLock {

    private boolean isLocked = false;
    private Thread lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        while(isLocked && lockedBy != Thread.currentThread()){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = Thread.currentThread();
    }

    public synchronized void unlock(){
        if(Thread.currentThread() == lockedBy) {
         lockedCount--;
        }
        if(lockedCount == 0){
            isLocked = false;
            notify();
        }
    }
}
