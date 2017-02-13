package com.deepakm.java.eventdelegation;

/**
 * Created by dmarathe on 10/30/16.
 */
public class Driver {
    public static void main(String[] args) {
        WeatherForecaster forecaster = new WeatherForecaster();
        WeatherWatcher watcher = new WeatherWatcher();
        WeatherWatcher anotherWatcher = new WeatherWatcher();

        forecaster.addObserver(watcher);
        forecaster.addObserver(anotherWatcher);

        forecaster.generateNewWeather();
    }
}
