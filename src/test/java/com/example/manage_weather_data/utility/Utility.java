package com.example.manage_weather_data.utility;

import com.example.manage_weather_data.domain.Weather;
import com.example.manage_weather_data.domain.WeatherDetail;
import com.example.manage_weather_data.dto.MainWeatherDTO;
import com.example.manage_weather_data.dto.WeatherDetailDTO;
import com.example.manage_weather_data.dto.WeatherDTO;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static Weather getWeatherObj(){
        Weather weather = Weather.builder().id(501).description("moderate rain").
                main("Rain").icon("10d").build();
        WeatherDetail detail = WeatherDetail.builder()
                .temp(298.48d)
                .feelsLike(298.74d)
                .tempMin(297.56)
                .tempMax(300.05)
                .pressure(1015)
                .humidity(64)
                .seaLevel(1015)
                .grndLevel(933)
                .build();
        return weather;
    }

    public static WeatherDetail getWeatherDetailObj(){
        WeatherDetail detail = WeatherDetail.builder()
                .temp(298.48d)
                .feelsLike(298.74d)
                .tempMin(297.56)
                .tempMax(300.05)
                .pressure(1015)
                .humidity(64)
                .seaLevel(1015)
                .grndLevel(933)
                .build();
        return detail;
    }

    public static WeatherDTO getWeatherDataObj(){
        MainWeatherDTO detail = MainWeatherDTO.builder()
                .id(501).description("moderate rain").
                main("Rain").icon("10d").build();
        WeatherDetailDTO main = WeatherDetailDTO.builder()
                .temp(298.48d)
                .feelsLike(298.74d)
                .tempMin(297.56)
                .tempMax(300.05)
                .pressure(1015)
                .humidity(64)
                .seaLevel(1015)
                .grndLevel(933)
                .build();
        List<MainWeatherDTO> detailList = new ArrayList<>();
        detailList.add(detail);
//           WeatherDTO weatherDTO =  WeatherDTO.builder().
//        weather(detailList)
//                   .main(main)
//                   .city("Pune")
//        .build();
           return WeatherDTO.builder().build();
    }
}
