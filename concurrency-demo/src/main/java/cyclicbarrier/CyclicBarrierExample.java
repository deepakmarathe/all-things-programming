package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dmarathe on 10/21/16.
 */
public class CyclicBarrierExample {

    private static class Task implements Runnable {
        private final CyclicBarrier cyclicBarrier;
        private final static Logger log = Logger.getLogger(Task.class.getName());

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is waiting on barrier.");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                log.log(Level.SEVERE, e.getMessage(), e);
            } catch (BrokenBarrierException e) {
                log.log(Level.SEVERE, e.getMessage(), e);
            }
            System.out.println(Thread.currentThread().getName() + " has closed the barrier.");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All parties have arrived. Lets party!");
            }
        });
        Thread t1 = new Thread(new CyclicBarrierExample.Task(cyclicBarrier), "Thread 1");
        Thread t2 = new Thread(new CyclicBarrierExample.Task(cyclicBarrier), "Thread 2");
        Thread t3 = new Thread(new CyclicBarrierExample.Task(cyclicBarrier), "Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }

}
