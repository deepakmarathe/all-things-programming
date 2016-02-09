package com.deepakm.designpattern.creational.abstractfactory.color;

import com.deepakm.designpattern.creational.abstractfactory.ABstractFactory;
import com.deepakm.designpattern.creational.abstractfactory.shape.Shape;

/**
 * Created by dmarathe on 2/9/16.
 */
public class ColorFactory extends ABstractFactory {
    public Color getColor(String colorType) {
        if (colorType.equalsIgnoreCase("red")) {
            return new Red();
        } else if (colorType.equalsIgnoreCase("green")) {
            return new Green();
        }
        return null;
    }

    public Shape getShape(String shapeType) {
        return null;
    }
}
