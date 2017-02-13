package locks;

/**
 * Created by dmarathe on 10/19/16.
 */
public class FlipCounter implements CounterAPI {
    private final FlipLock lock;
    private int counter = 0;
    private final int limit;

    public FlipCounter(int limit) {
        this.lock = new FlipLock();
        this.counter = 0;
        this.limit = limit;
    }

    @Override
    public void increment() {
        if (counter < limit) {
            try {
                lock.lock();
                counter++;
                System.out.println("Produced : " + counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }

        }
    }

    @Override
    public void print() {
        if (counter <= limit) {
            try {
                lock.unlock();
                System.out.println("Consumed : " + counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
