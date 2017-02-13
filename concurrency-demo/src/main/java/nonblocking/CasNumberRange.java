package nonblocking;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by dmarathe on 10/27/16.
 */
public class CasNumberRange {
    public static class IntPair {
        public int a, b;

        public IntPair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }


    }

    private AtomicReference<IntPair> intPairAtomicReference = new AtomicReference<>(new IntPair(0, 0));

    public void setLower(int a) {
        while (true) {
            IntPair oldValue = intPairAtomicReference.get();
            if (a > oldValue.b) {
                throw new IllegalArgumentException();
            }
            IntPair pair = new IntPair(a, oldValue.b);
            if (intPairAtomicReference.compareAndSet(oldValue, pair)) {
                return;
            }
        }
    }

    public void setHigher(int b) {
        while (true) {
            IntPair oldValue = intPairAtomicReference.get();
            if (b < oldValue.a) {
                throw new IllegalArgumentException();
            }
            IntPair pair = new IntPair(oldValue.a, b);
            if (intPairAtomicReference.compareAndSet(oldValue, pair)) return;
        }
    }

    public static void main(String[] args) throws Exception {
        class Producer implements Runnable {
            private CasNumberRange range;

            public Producer(CasNumberRange range) {
                this.range = range;
            }

            @Override
            public void run() {
                while (true) {
                    int t = new Random().nextInt(100);
                    range.setLower(t);
                    System.out.println("lower set to : " + t);
                }
            }
        }

        class Consumer implements Runnable {
            private CasNumberRange range;

            public Consumer(CasNumberRange range) {
                this.range = range;
            }

            @Override
            public void run() {
                while (true) {
                    int t = new Random().nextInt(100);
                    range.setHigher(t);
                    System.out.println("higher set to : " + t);
                }
            }
        }

        CasNumberRange range = new CasNumberRange();
        Thread producer = new Thread(new Producer(range));
        Thread consumer = new Thread(new Consumer(range));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
