package com.deepakm.java.concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by dmarathe on 10/3/16.
 */
public class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    @Override
    public void run() {
        System.out.println("Thread name = " + Thread.currentThread().getName() + " default formatter = " + formatter
                .get().toPattern());
        try{
            Thread.sleep(new Random().nextInt(1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread name= " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
    }


}
