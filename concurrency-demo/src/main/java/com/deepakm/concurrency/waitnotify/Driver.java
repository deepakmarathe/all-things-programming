package com.deepakm.concurrency.waitnotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

    public static void main(String[] args) throws InterruptedException {

        Counter sharedResource = new Counter().withLimit(10L);

        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.shutdown();

    }
}
