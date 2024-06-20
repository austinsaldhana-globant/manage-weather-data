package com.example.manage_weather_data.repository;

import com.example.manage_weather_data.domain.WeatherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDetailRepository extends JpaRepository<WeatherDetail, Integer> {
}
