package com.deepakm.designpattern.creational.builder;

/**
 * Created by dmarathe on 2/9/16.
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public double price() {
        return 13;
    }
}
