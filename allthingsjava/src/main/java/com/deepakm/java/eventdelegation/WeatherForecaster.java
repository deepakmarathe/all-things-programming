package com.deepakm.java.eventdelegation;

import java.util.Observable;
import java.util.Random;

/**
 * Created by dmarathe on 10/30/16.
 */
public class WeatherForecaster extends Observable {
    private static String weather1 = "Weather Report Live. Its Bright and sunny...Let's play cricket!!";
    private static String weather2 = "Weather Report Live. Its Raining Heavily!..Let's have hot Pakodas!!";
    private static String weather3 = "Weather Report Live. Its Expected Rain!.. Let's not play!!";

    private static final String weatherBase[] = new String[]{
            weather1, weather2, weather3
    };

    public void generateNewWeather() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int r = random.nextInt(weatherBase.length);

        this.setChanged();
        this.notifyObservers(new WeatherChangeEvent(weatherBase[r]));
    }
}
