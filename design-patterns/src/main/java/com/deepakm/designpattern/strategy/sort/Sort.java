package com.deepakm.designpattern.strategy.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Created by dmarathe on 11/17/15.
 */
public interface Sort<Entity> {
    public List<Entity> sort(List<Entity> collection);

    public List<? extends Entity> sort(List<? extends Entity> collection, Comparator sortComparator);
}
