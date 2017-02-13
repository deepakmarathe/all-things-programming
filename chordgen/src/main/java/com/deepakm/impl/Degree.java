package com.deepakm.impl;

/**
 * Created by dmarathe on 11/8/16.
 */
public enum Degree {
    I(),
    II(),
    III(),
    IV,
    V,
    VI,
    VII,
    DOMINENT(V),
    SUBDOMINANT(IV);


    private short degree;

    private Degree() {
        this.degree = (short) this.ordinal();
    }


    private Degree(Degree degree) {
        this.degree = (short) degree.ordinal();
    }

    public short getDegree() {
        return degree;
    }

}
