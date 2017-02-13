package com.deepakm.java.nonblockingconcurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dmarathe on 10/27/16.
 */
public class NonBlockingCounter {
    private AtomicInteger value;

    public NonBlockingCounter() {
        value = new AtomicInteger(0);
    }

    public int increment() {
        int v;
        int next;
        do {
            v = value.get();
            next = v + 1;
        } while (!value.compareAndSet(v, next));
        return next;
    }

    public int getValue() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        class Producer implements Runnable {
            private NonBlockingCounter counter;

            public Producer(NonBlockingCounter counter) {
                this.counter = counter;
            }

            @Override
            public void run() {
                while (true) {
                    int t = counter.increment();
                    System.out.println("incremented to : " + t);
                }
            }
        }

        class Consumer implements Runnable {
            private NonBlockingCounter counter;

            public Consumer(NonBlockingCounter counter) {
                this.counter = counter;
            }

            @Override
            public void run() {
                while (true)
                    System.out.println("consumed : " + counter.getValue());
            }
        }

        NonBlockingCounter counter = new NonBlockingCounter();
        Thread producer = new Thread(new Producer(counter));
        Thread consumer = new Thread(new Consumer(counter));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }

}
