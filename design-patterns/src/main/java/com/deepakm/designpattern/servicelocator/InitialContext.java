package com.deepakm.designpattern.servicelocator;

/**
 * Created by dmarathe on 2/9/16.
 */
public class InitialContext {
    public Service lookup(String jndiName){
        if( jndiName.equalsIgnoreCase("Service1")){
            System.out.println("Looking up and creating a new service1 object.");
            return new Service1();
        } else if (jndiName.equalsIgnoreCase("Service2")) {
            System.out.println("Looking up and creating a new service2 object.");
            return new Service2();
        }
        return null;
    }
}
