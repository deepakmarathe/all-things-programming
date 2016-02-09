package com.deepakm.designpattern.creational.factory;

/**
 * Created by dmarathe on 2/9/16.
 */
public class FactoryPatternDriver {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();
        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();
    }
}
