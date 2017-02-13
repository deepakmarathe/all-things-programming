package blocking.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dmarathe on 10/21/16.
 */
public class CountDownLatchExample {
    private static final Logger logger = Logger.getLogger(CountDownLatchExample.class.getName());

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread cacheService = new Thread(new Service("cache service", 1000, countDownLatch));
        Thread alertService = new Thread(new Service("alert service", 1000, countDownLatch));
        Thread validationService = new Thread(new Service("validation service", 1000, countDownLatch));

        cacheService.start();
        alertService.start();
        validationService.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        System.out.println("Main execution has started.");
    }
}
