package synchronization;

/**
 * Created by dmarathe on 10/5/16.
 */
public class CounterThread implements Runnable {

    private final Counter sharedResource;

    public CounterThread(final Counter sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.add(i);
        }
    }

}
