package com.demo.java.observer;

import com.demo.java.observer.inter.DisplayElement;
import com.demo.java.observer.inter.Observer;

import java.util.List;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/24 15:56 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
//显示未来几天的天气
public class ForecastDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;

    private List<Float> forecastTemperatures;//未来几天的温度

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("未来几天的气温");
        int count = forecastTemperatures.size();
        for (int i = 0; i < count; i++) {
            System.out.println("第" + i + "天:" + forecastTemperatures.get(i) + "℃");
        }
    }

    @Override
    public void update() {
        this.forecastTemperatures = this.weatherData.getForecastTemperatures();
        display();
    }
}