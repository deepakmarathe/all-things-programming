package com.deepakm.dsalgo.util.swap;

/**
 * Created by dmarathe on 11/17/15.
 */
public class Pair<A> {
    private A first;
    private A second;

    public Pair() {

    }

    public Pair(A first, A second) {
        setFirst(first);
        setSecond(second);
    }

    public A getFirst() {
        return first;
    }

    public A getSecond() {
        return second;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public void setSecond(A second) {
        this.second = second;
    }
}
