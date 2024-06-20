package com.example.manage_weather_data.controller;

import com.example.manage_weather_data.domain.Weather;
import com.example.manage_weather_data.dto.WeatherData;
import com.example.manage_weather_data.dto.WeatherReport;
import com.example.manage_weather_data.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherReportController {

    @Autowired
    WeatherReportService weatherReportService;

    @PostMapping(value = "/saveWeatherData", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Weather> saveWeatherData(@RequestBody WeatherData weatherData) {
        return weatherReportService.saveWeatherData(weatherData);
    }

    @GetMapping(value = "/weatherHistory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherReport> getWeatherHistory() {
        return weatherReportService.getWeatherHistory();
    }
}
