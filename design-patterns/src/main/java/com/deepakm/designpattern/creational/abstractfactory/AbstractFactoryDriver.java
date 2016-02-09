package com.deepakm.designpattern.creational.abstractfactory;

import com.deepakm.designpattern.creational.abstractfactory.color.Color;
import com.deepakm.designpattern.creational.abstractfactory.shape.Shape;

/**
 * Created by dmarathe on 2/9/16.
 */
public class AbstractFactoryDriver {
    public static void main(String[] args) {
        ABstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        ABstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color red = colorFactory.getColor("red");
        red.fill();
    }
}
