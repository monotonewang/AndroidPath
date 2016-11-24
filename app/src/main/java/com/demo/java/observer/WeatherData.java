package com.demo.java.observer;

import com.demo.java.observer.inter.Observer;
import com.demo.java.observer.inter.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/24 15:52 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class WeatherData implements Subject {
    private List<Observer> observers;

    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压
    private List<Float> forecastTemperatures;//未来几天的温度

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity,
                                float pressure, List<Float> forecastTemperatures) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.forecastTemperatures = forecastTemperatures;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public List<Float> getForecastTemperatures() {
        return forecastTemperatures;
    }
}
