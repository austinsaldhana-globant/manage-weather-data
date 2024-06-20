package com.example.manage_weather_data.repository;


import com.example.manage_weather_data.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}