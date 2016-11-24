package com.demo.java.observer;

import com.demo.java.observer.inter.DisplayElement;
import com.demo.java.observer.inter.Observer;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/24 15:53 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
//显示当前天气的公告牌
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;

    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前温度为：" + this.temperature + "℃");
        System.out.println("当前湿度为：" + this.humidity);
        System.out.println("当前气压为：" + this.pressure);
    }

    @Override
    public void update() {
        this.temperature = this.weatherData.getTemperature();
        this.humidity = this.weatherData.getHumidity();
        this.pressure = this.weatherData.getPressure();
        display();
    }
}