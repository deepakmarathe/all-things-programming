package com.deepakm.designpattern.creational.abstractfactory.color;

/**
 * Created by dmarathe on 2/9/16.
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("filling red");
    }
}
