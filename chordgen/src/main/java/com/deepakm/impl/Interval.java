package com.deepakm.impl;

/**
 * Created by dmarathe on 11/10/16.
 */
public enum Interval {
    FLAT(-1),
    ZERO(0),
    SHARP(1);

    private short distance;

    private Interval(int distance) {
        this.distance = (short) distance;
    }

    public int getDistance() {
        return distance;
    }
}
