package com.deepakm.designpattern.servicelocator;

/**
 * Created by dmarathe on 2/9/16.
 */
public class ServiceLocator {

    private static final Cache cache = new Cache();

    public static Service getService(String jndiName){
        Service service = cache.getService(jndiName);
        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        service = context.lookup(jndiName);
        cache.addService(service);
        return service;
    }
}
