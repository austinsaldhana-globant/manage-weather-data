package com.example.manage_weather_data.dto;

import com.example.manage_weather_data.domain.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherReport {

    private List<WeatherResponseDTO> weatherList = new ArrayList<>();

    public WeatherReport() {
    }

    public WeatherReport(List<WeatherResponseDTO> weatherList) {
        this.weatherList = weatherList;
    }

    public List<WeatherResponseDTO> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<WeatherResponseDTO> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherReport that = (WeatherReport) o;

        return weatherList != null ? weatherList.equals(that.weatherList) : that.weatherList == null;
    }

    @Override
    public int hashCode() {
        return weatherList != null ? weatherList.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeatherReport{");
        sb.append("weatherList=").append(weatherList);
        sb.append('}');
        return sb.toString();
    }
}
