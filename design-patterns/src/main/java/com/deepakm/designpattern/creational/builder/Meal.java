package com.deepakm.designpattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmarathe on 2/9/16.
 */
public class Meal {
    private final List<Item> items;

    public Meal() {
        this.items = new ArrayList<>();
    }

    public Meal addItem(Item item) {
        this.items.add(item);
        return this;
    }

    public double getCost() {
        double cost = 0;
        for (Item item : this.items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : this.items) {
            System.out.println("name : " + item.name() + ", packing : " + item.packing().pack() + ", price : " + item.price());
        }
    }
}
