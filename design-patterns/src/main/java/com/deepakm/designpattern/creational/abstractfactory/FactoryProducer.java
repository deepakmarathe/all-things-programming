package com.deepakm.designpattern.creational.abstractfactory;

import com.deepakm.designpattern.creational.abstractfactory.color.ColorFactory;
import com.deepakm.designpattern.creational.abstractfactory.shape.ShapeFactory;

/**
 * Created by dmarathe on 2/9/16.
 */
public class FactoryProducer {
    public static ABstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }
        return null;
    }
}
