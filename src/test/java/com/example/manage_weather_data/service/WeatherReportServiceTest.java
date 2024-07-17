package com.example.manage_weather_data.service;

import com.example.manage_weather_data.domain.Weather;
import com.example.manage_weather_data.domain.WeatherDetail;
import com.example.manage_weather_data.dto.WeatherDTO;
import com.example.manage_weather_data.dto.WeatherReport;
import com.example.manage_weather_data.repository.WeatherRepository;
import com.example.manage_weather_data.utility.Utility;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
public class WeatherReportServiceTest {

    @InjectMocks
    WeatherReportService weatherReportService;

    @Mock
    WeatherRepository weatherRepository;

    private Weather weather;
    private WeatherDetail weatherDetail;
    private WeatherDTO weatherDTO;

    @BeforeEach
    public void init() {
        weather = Utility.getWeatherObj();
        weatherDetail = Utility.getWeatherDetailObj();
        weatherDTO = Utility.getWeatherDataObj();

    }

    @Test
    public void WeatherReportService_SaveWeatherData_ReturnsWeather() {


        Mockito.when(weatherRepository.save(Mockito.any(Weather.class))).thenReturn(weather);

        //Weather savedWeather = weatherReportService.saveWeatherData(weatherDTO);

       // Assertions.assertThat(savedWeather).isNotNull();
    }

    @Test
    public void WeatherReportService_GetWeatherHistory_ReturnsResponseDto() {
        Page<Weather> weatherPage = Mockito.mock(Page.class);

        Mockito.when(weatherRepository.findAll(Mockito.any(Pageable.class))).thenReturn(weatherPage);

        //WeatherReport weatherReport = weatherReportService.getWeatherHistory(0,10,null);

        //Assertions.assertThat(weatherReport).isNotNull();
    }



}
