package com.deepakm.designpattern.creational.builder;

/**
 * Created by dmarathe on 2/9/16.
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return  new Wrapper();
    }
}
