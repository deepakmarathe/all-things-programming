package com.deepakm.designpattern.strategy.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dmarathe on 11/17/15.
 */
public class SortDriver {
    public static void main(String[] args) {

        List<Entity> collection = new ArrayList<>();
        collection.add(new Employee.Builder().withId(0).withName("bob").withAge(30).withSalary(100000).build());
        collection.add(new Employee.Builder().withId(1).withName("arnold").withAge(31).withSalary(110000).build());
        collection.add(new Employee.Builder().withId(2).withName("foo").withAge(28).withSalary(140000).build());

        Sorter sorter = Sorter.BUBBLESORT;

        sorter.sort(collection);
        System.out.println("After sorting : ");
        printCollection(collection);

        sorter.sort(collection, Employee.NameComparator);
        System.out.println("After sorting by name : ");
        printCollection(collection);

        sorter.sort(collection, Employee.AgeComparator);
        System.out.println("After sorting by age : ");
        printCollection(collection);

        sorter.sort(collection, Employee.SalaryComparator);
        System.out.println("After sorting by salary : ");
        printCollection(collection);
    }

    private static void printCollection(Collection c){
        for (Object e : c) {
            System.out.println(e);
        }
    }
}
