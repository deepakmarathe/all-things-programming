package com.deepakm.designpattern.servicelocator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmarathe on 2/9/16.
 */
public class Cache {
    private List<Service> services;

    public Cache(){
        this.services = new ArrayList<>();
    }

    public Service getService(String serviceName){
        for(Service service : services){
            if (service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached " + serviceName + " object.");
                return service;
            }
        }
        return null;
    }

    public void addService(Service service){
        if (!services.contains(service.getName())) {
            services.add(service);
        }
    }
}
