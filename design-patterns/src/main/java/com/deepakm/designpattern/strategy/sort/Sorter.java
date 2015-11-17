package com.deepakm.designpattern.strategy.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Created by dmarathe on 11/17/15.
 */
public class Sorter implements Sort<Entity> {

    public static Sorter BUBBLESORT = new Sorter(new BubbleSort());

    private final Sort<Entity> sortImpl;

    public Sorter(Sort<Entity> sortImpl) {
        this.sortImpl = sortImpl;
    }

    @Override
    public List<Entity> sort(List<Entity> collection) {
        sortImpl.sort(collection);
        return collection;
    }

    @Override
    public List<? extends Entity> sort(List<? extends Entity> collection, Comparator sortComparator) {
        sortImpl.sort(collection, sortComparator);
        return collection;
    }
}
