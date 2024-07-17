package com.example.manage_weather_data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDTO {

    private List<MainWeatherDTO> weather = new ArrayList<>();

    private WeatherDetailDTO main;

    private String city;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm aa")
    private Date addedDate;
}


