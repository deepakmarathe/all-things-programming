package com.deepakm.java.concurrency.immutability;

/**
 * Created by dmarathe on 10/5/16.
 */
public class ImmutableValue {
    private int value = 0;

    public ImmutableValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public ImmutableValue add(int valueToAdd){
        return new ImmutableValue(this.value + valueToAdd);
    }

    public static void main(String[] args) {
        ImmutableValue value = new ImmutableValue(10);
        value = value.add(20);
        System.out.println(value.getValue());
    }
}
