package com.example.manage_weather_data.service;

import com.example.manage_weather_data.domain.Weather;
import com.example.manage_weather_data.dto.*;
import com.example.manage_weather_data.repository.WeatherDetailRepository;
import com.example.manage_weather_data.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherReportService {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    WeatherDetailRepository weatherDetailRepository;

    public ResponseEntity<Weather> saveWeatherData(WeatherData weatherData){
       Weather weather = new Weather();
       weather.setWeatherId(weatherData.getWeather().get(0).getId());
       weather.setMain(weatherData.getWeather().get(0).getMain());
       weather.setDescription(weatherData.getWeather().get(0).getDescription());
       weather.setIcon(weatherData.getWeather().get(0).getIcon());
       weather.setCity(weatherData.getCity());
        weather.setCreatedDate(Instant.now());
       MainWeatherDetail weatherDetail = weatherData.getMain();
        com.example.manage_weather_data.domain.WeatherDetail detail = new com.example.manage_weather_data.domain.WeatherDetail();
        detail.setWeather(weather);
        detail.setFeelsLike(weatherDetail.getFeelsLike());
        detail.setGrndLevel(weatherDetail.getGrndLevel());
        detail.setHumidity(weatherDetail.getHumidity());
        detail.setPressure(weatherDetail.getPressure());
        detail.setSeaLevel(weatherDetail.getSeaLevel());
        detail.setTemp(weatherDetail.getTemp());
        detail.setTempMax(weatherDetail.getTempMax());
        detail.setTempMin(weatherDetail.getTempMin());
        weatherDetailRepository.save(detail);
         weather = weatherRepository.save(weather);
        return new ResponseEntity<>(weather, HttpStatus.OK);

    }

    public ResponseEntity<WeatherReport> getWeatherHistory(){

        WeatherReport weatherReport = new WeatherReport();
        List<WeatherResponseDTO> weatherResponseDTOS = new ArrayList<>();
        List<Weather> weatherList = weatherRepository.findAll();
        for(Weather weather :weatherList){
            WeatherResponseDTO responseDTO = new WeatherResponseDTO();
            responseDTO.setWeatherId(weather.getWeatherId());
            responseDTO.setCreatedDate(weather.getCreatedDate());
            responseDTO.setDescription(weather.getDescription());
            responseDTO.setMain(weather.getMain());
            responseDTO.setIcon(weather.getIcon());
            responseDTO.setCity(weather.getCity());
            WeatherDetailResponseDTO detailResponseDTO = new WeatherDetailResponseDTO();
            detailResponseDTO.setFeelsLike(weather.getWeatherDetail().getFeelsLike());
            detailResponseDTO.setPressure(weather.getWeatherDetail().getPressure());
            detailResponseDTO.setHumidity(weather.getWeatherDetail().getHumidity());
            detailResponseDTO.setGrndLevel(weather.getWeatherDetail().getGrndLevel());
            detailResponseDTO.setSeaLevel(weather.getWeatherDetail().getSeaLevel());
            detailResponseDTO.setTemp(weather.getWeatherDetail().getTemp());
            detailResponseDTO.setTempMax(weather.getWeatherDetail().getTempMax());
            detailResponseDTO.setTempMin(weather.getWeatherDetail().getTempMin());
            responseDTO.setWeatherDetail(detailResponseDTO);
            weatherResponseDTOS.add(responseDTO);
        }
        weatherReport.setWeatherList(weatherResponseDTOS);
        return new ResponseEntity<>(weatherReport, HttpStatus.OK);
    }
}
