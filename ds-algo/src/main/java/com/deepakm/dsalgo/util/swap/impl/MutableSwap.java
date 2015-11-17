package com.deepakm.dsalgo.util.swap.impl;

import com.deepakm.dsalgo.util.swap.Pair;
import com.deepakm.dsalgo.util.swap.Swap;

/**
 * Created by dmarathe on 11/17/15.
 */
public class MutableSwap<A> implements Swap<Pair<A>> {

    @Override
    public Pair<A> swap(Pair<A> input) {
        A first = input.getFirst();
        input.setFirst(input.getSecond());
        input.setSecond(first);
        return input;
    }
}
