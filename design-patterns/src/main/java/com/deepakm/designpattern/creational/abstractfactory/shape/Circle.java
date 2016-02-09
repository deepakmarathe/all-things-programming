package com.deepakm.designpattern.creational.abstractfactory.shape;

/**
 * Created by dmarathe on 2/9/16.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing circle.");
    }
}
