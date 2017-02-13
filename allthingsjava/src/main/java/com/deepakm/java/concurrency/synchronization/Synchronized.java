package com.deepakm.java.concurrency.synchronization;

/**
 * Created by dmarathe on 10/5/16.
 */
public class Synchronized {

    public static synchronized void log1(String message1, String message2) {
        System.out.println("log1");
        System.out.println(message1);
        System.out.println(message2);
    }

    public static void log2(String message1, String message2) {
        synchronized (Synchronized.class) {
            System.out.println("log2");
            System.out.println(message1);
            System.out.println(message2);
        }
    }

    public synchronized void log3(String message1, String message2){
        System.out.println("log3");
        System.out.println(message1);
        System.out.println(message2);
    }

    public void log4(String message1, String message2){
        synchronized (this){
            System.out.println("log4");
            System.out.println(message1);
            System.out.println(message2);
        }
    }

    public static void main(String[] args) {
        String message1 = "message1";
        String message2 = "message2";

        Synchronized.log1(message1, message2);
        Synchronized.log2(message1, message2);

        Synchronized aSynchronized = new Synchronized();
        aSynchronized.log3(message1, message2);
        aSynchronized.log4(message1, message2);

    }
}
