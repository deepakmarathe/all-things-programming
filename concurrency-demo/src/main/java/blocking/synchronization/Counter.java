package blocking.synchronization;

/**
 * Created by dmarathe on 10/5/16.
 */
public class Counter {
    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
        System.out.println("Thread name : " + Thread.currentThread().getName() + ", added  : " + value + ", total : " + count);
    }
}
