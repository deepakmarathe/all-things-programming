package com.deepakm.designpattern.creational.abstractfactory;

import com.deepakm.designpattern.creational.abstractfactory.color.Color;
import com.deepakm.designpattern.creational.abstractfactory.shape.Shape;
import sun.security.provider.SHA;

/**
 * Created by dmarathe on 2/9/16.
 */
public abstract class ABstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
