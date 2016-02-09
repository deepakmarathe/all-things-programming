package com.deepakm.designpattern.creational.builder;

/**
 * Created by dmarathe on 2/9/16.
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "ver burger";
    }

    @Override
    public double price() {
        return 25;
    }
}
