package com.deepakm.designpattern.creational.abstractfactory.shape;

import com.deepakm.designpattern.creational.abstractfactory.ABstractFactory;
import com.deepakm.designpattern.creational.abstractfactory.color.Color;

/**
 * Created by dmarathe on 2/9/16.
 */
public class ShapeFactory extends ABstractFactory {

    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }

    public Color getColor(String colorType) {
        return null;
    }
}
