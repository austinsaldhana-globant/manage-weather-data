package com.example.manage_weather_data.repository;

import com.example.manage_weather_data.domain.WeatherInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Integer> {
    Page<WeatherInfo> findByCity(String city, Pageable pageable);
}
