package com.deepakm.java.concurrency.volatilevariable;

/**
 * Created by dmarathe on 10/3/16.
 */
public class Producer implements Runnable {
    private final Exchanger exchanger;

    public Producer(Exchanger sharedResource){
        this.exchanger = sharedResource;
    }

    @Override
    public void run() {
        while(true){
            Object o = new Object();
            exchanger.put(o);
            System.out.println("Producing new object : " + o);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
