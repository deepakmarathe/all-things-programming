package com.deepakm.designpattern.creational.builder;

/**
 * Created by dmarathe on 2/9/16.
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public double price() {
        return 10;
    }
}
