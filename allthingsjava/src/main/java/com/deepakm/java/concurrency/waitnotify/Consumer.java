package com.deepakm.java.concurrency.waitnotify;


public class Consumer implements Runnable {
    private final Counter counter;

    public Consumer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        while (!counter.isComplete()) {
            counter.print();
        }
        counter.setCompleted();
        System.out.println("consumer done!");
    }

}
