package com.deepakm.designpattern.creational.builder;

/**
 * Created by dmarathe on 2/9/16.
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken burger";
    }

    @Override
    public double price() {
        return 40;
    }
}
