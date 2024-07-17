package com.example.manage_weather_data.mapper;

import com.example.manage_weather_data.domain.WeatherInfo;
import com.example.manage_weather_data.dto.WeatherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherMapper {

    WeatherMapper mapper = Mappers.getMapper(WeatherMapper.class);

    @Mapping(expression = "java(new java.util.Date())", target = "addedDate")
    WeatherInfo mapToWeather(WeatherDTO weatherDTO);


}
