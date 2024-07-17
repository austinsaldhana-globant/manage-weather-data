package com.example.manage_weather_data.service;

import com.example.manage_weather_data.domain.Weather;
import com.example.manage_weather_data.domain.WeatherDetail;
import com.example.manage_weather_data.domain.WeatherInfo;
import com.example.manage_weather_data.dto.WeatherDTO;
import com.example.manage_weather_data.dto.WeatherReport;
import com.example.manage_weather_data.mapper.WeatherMapper;
import com.example.manage_weather_data.mapper.WeatherReportMapper;
import com.example.manage_weather_data.repository.WeatherDetailRepository;
import com.example.manage_weather_data.repository.WeatherInfoRepository;
import com.example.manage_weather_data.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportService {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    WeatherDetailRepository weatherDetailRepository;

    @Autowired
    WeatherInfoRepository weatherInfoRepository;

    public Object saveWeatherData(WeatherDTO weatherDTO) {
        WeatherInfo weatherInfo = WeatherMapper.mapper.mapToWeather(weatherDTO);
        weatherInfoRepository.save(weatherInfo);
        Weather weather = weatherInfo.getWeather().stream().findFirst().get();
        weather.setWeatherInfo(weatherInfo);
        weatherRepository.save(weather);
        WeatherDetail detail = weatherInfo.getMain();
        detail.setWeatherInfo(weatherInfo);
        weatherDetailRepository.save(detail);
        return weatherInfo;

    }

    public WeatherReport getWeatherHistory(int pageNo, int pageSize, String city) {
        Page<WeatherInfo> weatherInfoPage = null;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        if (city != null && !city.isEmpty()) {
            weatherInfoPage = weatherInfoRepository.findByCity(city, pageable);
        } else {
            weatherInfoPage = weatherInfoRepository.findAll(pageable);
        }
        WeatherReport weatherReport = WeatherReportMapper.mapper.mapWeatherReport(weatherInfoPage);
        return weatherReport;

    }
}
