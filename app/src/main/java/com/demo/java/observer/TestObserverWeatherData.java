package com.demo.java.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/24 14:23 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
//观察者模式介绍
//        观察者模式面向的需求是：A对象（观察者）对B对象（被观察者）的某种变化高度敏感，
//        需要在B变化的一瞬间做出反应。
//        举个例子，新闻里喜闻乐见的警察抓小偷，警察需要在小偷伸手作案的时候实施抓捕。
//        在这个例子里，警察是观察者、小偷是被观察者，警察需要时刻盯着小偷的一举一动，
//        才能保证不会错过任何瞬间。程序里的观察者和这种真正的【观察】略有不同，
//        观察者不需要时刻盯着被观察者（例如A不需要每隔1ms就检查一次B的状态），
//        二是采用注册(_Register_)或者成为订阅(_Subscribe_)的方式告诉被观察者：
//        我需要你的某某状态，你要在它变化时通知我。采取这样被动的观察方式，
//        既省去了反复检索状态的资源消耗，也能够得到最高的反馈速度
public class TestObserverWeatherData {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        List<Float> forecastTemperatures = new ArrayList<Float>();
        forecastTemperatures.add(22f);
        forecastTemperatures.add(-1f);
        forecastTemperatures.add(9f);
        forecastTemperatures.add(23f);
        forecastTemperatures.add(27f);
        forecastTemperatures.add(30f);
        forecastTemperatures.add(10f);
        weatherData.setMeasurements(22f, 0.8f, 1.2f, forecastTemperatures);
    }
}
