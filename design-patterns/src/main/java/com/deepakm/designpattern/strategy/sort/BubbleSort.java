package com.deepakm.designpattern.strategy.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dmarathe on 11/17/15.
 */
public class BubbleSort implements Sort<Entity> {

    @Override
    public List<Entity> sort(List<Entity> collection) {
        boolean sorted = true;
        for (; ; ) {
            sorted = true;
            for (int i = 0; i < collection.size() - 1; i++) {
                if (collection.get(i).getId() > collection.get(i + 1).getId()) {
                    Collections.swap(collection, i, i + 1);
                }
            }
            if (sorted) break;
        }
        return collection;
    }

    @Override
    public List<? extends Entity> sort(List<? extends Entity> collection, Comparator sortComparator) {
        boolean sorted = true;
        for (; ; ) {
            sorted = true;
            for (int i = 0; i < collection.size() - 1; i++) {
                if (sortComparator.compare( collection.get(i), collection.get(i + 1)) > 0) {
                    Collections.swap(collection, i, i + 1);
                }
            }
            if (sorted) break;
        }
        return collection;

    }
}
