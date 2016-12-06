package com.javapath.observer.normal;

import java.util.List;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/24 15:46 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 * //From: http://www.jianshu.com/p/d55ee6e83d66
 */
//场景
//        我们接到一个来自气象局的需求：气象局需要我们构建一套系统，这系统有两个公告牌，分别用于显示当前的实时天气和未来几天的天气预报。当气象局发布新的天气数据（WeatherData）后，两个公告牌上显示的天气数据必须实时更新。气象局同时要求我们保证程序拥有足够的可扩展性，因为后期随时可能要新增新的公告牌。
//
//        文／张磊BaronZhang（简书作者）

public class TestNormalWeatherData {
    private float temperature=2;
    private float humidity=3;
    private float pressure=4;
    private List<Float> forecastTemperatures;

    public void measurementsChanged() {


        float temperature = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();
        List<Float> forecastTemperatures = getForecastTemperatures();

        //更新公告牌
//        currentConditionsDisplay.update(temperature, humidity, pressure);
//        forecastDisplay.update(forecastTemperatures);


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
