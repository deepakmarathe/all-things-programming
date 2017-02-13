package blocking.locks;

/**
 * Created by dmarathe on 10/5/16.
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException {

//        final Counter counter = new Counter(10);
        final FlipCounter counter = new FlipCounter(10);

        Thread producer = new Thread(new ItemProducer(counter));
        producer.start();

        Thread consumer = new Thread(new ItemConsumer(counter));
        consumer.start();

        producer.join();
        consumer.join();
    }
}

