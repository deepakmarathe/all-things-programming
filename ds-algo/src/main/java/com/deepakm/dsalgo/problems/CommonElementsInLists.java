package com.deepakm.dsalgo.problems;

/**
 * Created by dmarathe on 11/20/15.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Two lists given.. Find all common elements.
 * The method shud take any type of elements... And any type of list
 */
public class CommonElementsInLists {

    public static List<? extends Object> findCommon(List<? extends Object> first, List<?> second) {

        List commonElements = new ArrayList<>();

        if(first == null || second == null ){
            return commonElements;
        }

        Set<? extends Object> firstSet = new HashSet<>(first);
        for (Object o : second) {
            if (firstSet.contains(o)) {
                commonElements.add(o);
            }
        }
        return commonElements;
    }

}
