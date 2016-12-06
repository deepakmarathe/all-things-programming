package com.deepakm.dsalgo.util.swap.impl;

/**
 * Created by dmarathe on 11/17/15.
 */
public class ImmutableSwap<A> implements Swap<Pair<? extends A>> {

    @Override
    public Pair<? extends A> swap(Pair<? extends A> input) {

        Pair<A> pair = new Pair<>();
        pair.setFirst(input.getSecond());
        pair.setSecond(input.getFirst());

        return pair;
    }
}

interface Swap<Pair> {
    public Pair swap(final Pair input);
}

class Pair<A> {
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
