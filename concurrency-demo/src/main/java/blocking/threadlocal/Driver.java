package blocking.threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dmarathe on 10/3/16.
 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample example = new ThreadLocalExample();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(example, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }
}
