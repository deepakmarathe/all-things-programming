package volatilevariable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dmarathe on 10/3/16.
 */
public class Driver {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        Thread producer = new Thread(new Producer(exchanger));
        Thread consumer = new Thread(new Consumer(exchanger));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.shutdown();
    }
}
