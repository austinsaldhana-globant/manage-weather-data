package com.example.manage_weather_data.repository;


import com.example.manage_weather_data.domain.Weather;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    Page<Weather> findAll(Pageable pageable);

    //Page<Weather> findByCity(String city, Pageable pageable);
}