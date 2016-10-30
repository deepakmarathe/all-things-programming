package com.deepakm.java.eventdelegation;

import java.util.Observable;

/**
 * Created by dmarathe on 10/30/16.
 */
public class WeatherChangeEvent {
    private final String weatherChange;

    public WeatherChangeEvent(String weatherUpdate) {
        this.weatherChange = new String(weatherUpdate);
    }

    public String toString() {
        return this.weatherChange;
    }
}
