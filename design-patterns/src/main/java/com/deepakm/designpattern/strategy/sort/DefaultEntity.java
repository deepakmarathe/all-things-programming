package com.deepakm.designpattern.strategy.sort;

/**
 * Created by dmarathe on 11/17/15.
 */
public class DefaultEntity implements Entity {
    int id;

    public DefaultEntity(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
