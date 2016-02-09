package com.deepakm.designpattern.servicelocator;

/**
 * Created by dmarathe on 2/9/16.
 */
public class Service1 implements Service{
    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Executing service 1");
    }
}
