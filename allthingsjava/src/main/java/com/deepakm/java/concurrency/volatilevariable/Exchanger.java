package com.deepakm.java.concurrency.volatilevariable;

/**
 * Created by dmarathe on 10/3/16.
 */
public class Exchanger {
    private Object object = null;
    private volatile boolean hasNewObject = false;

    public void put(Object o){
        while(hasNewObject){}
        object = o;
        hasNewObject = true;
    }
    public Object take() {
        while(!hasNewObject){

        }
        Object o = object ;
        hasNewObject = false;
        return o;
    }

}
