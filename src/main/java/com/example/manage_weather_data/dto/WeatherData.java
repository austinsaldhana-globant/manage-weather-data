package com.example.manage_weather_data.dto;

import java.util.ArrayList;
import java.util.List;


public class WeatherData {
    private List<WeatherDetail> weather = new ArrayList<>();
    private MainWeatherDetail main;
    private String city;

    public WeatherData(List<WeatherDetail> weather, MainWeatherDetail main, String city) {
        this.weather = weather;
        this.main = main;
        this.city = city;
    }

    public List<WeatherDetail> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDetail> weather) {
        this.weather = weather;
    }

    public MainWeatherDetail getMain() {
        return main;
    }

    public void setMain(MainWeatherDetail main) {
        this.main = main;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherData that = (WeatherData) o;

        if (weather != null ? !weather.equals(that.weather) : that.weather != null) return false;
        if (main != null ? !main.equals(that.main) : that.main != null) return false;
        return city != null ? city.equals(that.city) : that.city == null;
    }

    @Override
    public int hashCode() {
        int result = weather != null ? weather.hashCode() : 0;
        result = 31 * result + (main != null ? main.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeatherData{");
        sb.append("weather=").append(weather);
        sb.append(", main=").append(main);
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


