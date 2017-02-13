package blocking.locks;

/**
 * Created by dmarathe on 10/19/16.
 */
public class FlipLock {
    private volatile int lockCount = 0;

    public synchronized void lock() throws InterruptedException {
        while (lockCount == 1) {
            wait();
        }
        lockCount = 1;
        notifyAll();
    }

    public synchronized void unlock() throws InterruptedException {
        while (lockCount == 0) {
            wait();
        }
        lockCount = 0;
        notifyAll();
    }

}
