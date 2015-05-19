package com.deepakm.concurrency.waitnotify;

public class Counter {
    private volatile Long counter;
    private Long LIMIT;

    public Counter() {
        this.counter = 0L;
        withLimit(0L);
    }

    public Counter withLimit(Long limit) {
        this.LIMIT = limit;
        return this;
    }

    public synchronized void increment() {
        counter = counter + 1;
        if (counter <= LIMIT) {
            System.out.println("Incremented to : " + counter);
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                //retry logic
                System.out.println("Retrying to wait");
            }
        }
    }

    public synchronized void print() {
        System.out.println("printing : " + counter);
        if (counter <= LIMIT) {
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("retrying logic");
            }
        }
    }

    public synchronized boolean isComplete() {
        return !(counter <= LIMIT);
    }

    public synchronized void setCompleted() {
        counter = LIMIT + 1;
        notify();
    }
}
