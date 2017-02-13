package com.deepakm.kstreams.sink;

/**
 * Created by deepakmarathe on 12/9/16.
 */
public class ConsoleSink implements Sink {
    public ConsoleSink() {
    }

    @Override
    public void setup() {

    }

    @Override
    public void pushMessage(String s) {
        System.out.println("message : " + s);
    }

    @Override
    public void close() {

    }
}
