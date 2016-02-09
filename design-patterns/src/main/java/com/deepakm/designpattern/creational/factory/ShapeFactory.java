package com.deepakm.designpattern.creational.factory;

/**
 * Created by dmarathe on 2/9/16.
 */
public class ShapeFactory {

    public Shape getShape(String shapeType){
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}
