package com.deepakm.java.concurrency.waitnotify;

public class Producer implements Runnable {

    private final Counter counter;
    private final Long LIMIT = 100L;

    public Producer(final Counter counter) {
        this.counter = counter;
    }

    public void run() {
        while (!counter.isComplete()) {
            counter.increment();
        }
        counter.setCompleted();
        System.out.println("producer done!");
    }
}
