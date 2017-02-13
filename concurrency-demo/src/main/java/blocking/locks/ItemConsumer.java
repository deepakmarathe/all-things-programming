package blocking.locks;

/**
 * Created by dmarathe on 10/5/16.
 */
public class ItemConsumer implements Runnable {
    private final CounterAPI counter;

    public ItemConsumer(final CounterAPI sharedResource) {
        this.counter = sharedResource;
    }

    @Override
    public void run() {

        while (true) {
            counter.print();
        }

    }
}
