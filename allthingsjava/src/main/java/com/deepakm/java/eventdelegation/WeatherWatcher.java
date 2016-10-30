package com.deepakm.java.eventdelegation;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by dmarathe on 10/30/16.
 */
public class WeatherWatcher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherForecaster) {
            WeatherChangeEvent event = (WeatherChangeEvent) arg;
            System.out.println(event);
        }
    }
}
