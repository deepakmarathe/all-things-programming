package blocking.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dmarathe on 10/21/16.
 */
public class Service implements Runnable {
    private final String serviceName;
    private final int delayStartMillis;
    private final CountDownLatch countDownLatch;
    private final Logger logger = Logger.getLogger(Service.class.getName());

    public Service(final String name, final int delayStartMillis, CountDownLatch countDownLatch) {
        this.serviceName = name;
        this.delayStartMillis = delayStartMillis;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delayStartMillis);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        System.out.println(serviceName + " is up.");
    }
}
