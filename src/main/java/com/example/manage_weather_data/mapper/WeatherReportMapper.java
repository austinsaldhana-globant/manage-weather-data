package com.example.manage_weather_data.mapper;

import com.example.manage_weather_data.domain.WeatherInfo;
import com.example.manage_weather_data.dto.WeatherReport;
import com.example.manage_weather_data.dto.WeatherResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface WeatherReportMapper {

    WeatherReportMapper mapper = Mappers.getMapper(WeatherReportMapper.class);

    @Mapping(source= "content", target= "content", qualifiedByName="mapWeatherResponseDTOList")
    @Mapping(source= "number", target= "pageNo")
    @Mapping(source= "size", target= "pageSize")
    @Mapping(source= "totalElements", target= "totalElements")
    @Mapping(source= "totalPages", target= "totalPages")
    @Mapping(source= "last", target= "last")
    WeatherReport mapWeatherReport(Page<WeatherInfo> weatherPage);


    @Named("mapWeatherResponseDTOList")
    default List<WeatherResponseDTO> mapWeatherResponseDTOList(List<WeatherInfo> weatherInfoList){
        List<WeatherResponseDTO> weatherResponseDTOS = new ArrayList<>();
            for(WeatherInfo weatherInfo : weatherInfoList){
                weatherResponseDTOS.add(mapWeatherResponseDTO(weatherInfo));
            }
        return weatherResponseDTOS;
    }

    WeatherResponseDTO mapWeatherResponseDTO(WeatherInfo weatherInfo);

}
