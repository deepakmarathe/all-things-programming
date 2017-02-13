package nonblocking;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dmarathe on 10/27/16.
 */
public class AtomicPseudoRandom {
    private AtomicInteger seed;

    public AtomicPseudoRandom(int seed) {
        this.seed = new AtomicInteger(seed);
    }

    public int getNext(int n) {
        while (true) {
            int s = seed.get();
            int nextSeed = new Random().nextInt(n);
            if (seed.compareAndSet(s, nextSeed)) {
                int reminder = s % n;
                return reminder > 0 ? reminder : reminder + n;
            }
        }
    }
}
