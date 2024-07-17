package com.example.manage_weather_data.controller;

import com.example.manage_weather_data.dto.WeatherDTO;
import com.example.manage_weather_data.dto.WeatherReport;
import com.example.manage_weather_data.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class WeatherReportController {

    @Autowired
    WeatherReportService weatherReportService;

    @PostMapping(value = "/weather-info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveWeatherData(@RequestBody WeatherDTO weatherDTO) {

        return new ResponseEntity<>(weatherReportService.saveWeatherData(weatherDTO),
                HttpStatus.CREATED);

    }

    @GetMapping(value = "/weather-info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherReport> getWeatherHistory( @RequestParam(value = "pageNo",
            defaultValue = "0", required = false) int pageNo, @RequestParam(value = "pageSize",
            defaultValue = "10", required = false) int pageSize,
                                                            @RequestParam(value = "city",  required = false) String city) {
        return new ResponseEntity<>(weatherReportService.getWeatherHistory(pageNo, pageSize, city), HttpStatus.OK);
    }
}
