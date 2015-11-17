package com.deepakm.dsalgo.util.swap.impl;

import com.intuit.idea.dsalgo.util.swap.Pair;
import com.intuit.idea.dsalgo.util.swap.Swap;

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
