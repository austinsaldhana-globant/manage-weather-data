package com.example.manage_weather_data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MainWeatherDTO {

    private Integer id;

    private String main;

    private String description;

    private String icon;
}
