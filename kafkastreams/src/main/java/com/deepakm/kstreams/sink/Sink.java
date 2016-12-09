package com.deepakm.kstreams.sink;

/**
 * Created by deepakmarathe on 12/9/16.
 */
public interface Sink {
    void setup();
    void pushMessage(String s);
    void close();
}
