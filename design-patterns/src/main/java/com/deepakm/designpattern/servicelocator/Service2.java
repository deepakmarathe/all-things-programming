package com.deepakm.designpattern.servicelocator;

/**
 * Created by dmarathe on 2/9/16.
 */
public class Service2 implements Service {
    @Override
    public String getName() {
        return "Service2";
    }

    @Override
    public void execute() {
        System.out.println("Executing service 2");
    }
}
