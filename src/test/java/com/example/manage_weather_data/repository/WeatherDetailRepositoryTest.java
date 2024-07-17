package com.example.manage_weather_data.repository;

import com.example.manage_weather_data.domain.WeatherDetail;
import com.example.manage_weather_data.utility.Utility;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class WeatherDetailRepositoryTest {

    @Autowired
    private WeatherDetailRepository weatherDetailRepository;

    @Test
    public void checkIfReturnsSavedWeatherDetail(){
        WeatherDetail detail = Utility.getWeatherDetailObj();
        WeatherDetail savedDetail = weatherDetailRepository.save(detail);

        Assertions.assertThat(savedDetail).isNotNull();
        Assertions.assertThat(savedDetail.getId()).isGreaterThan(0);

    }

    @Test
    public void checkIfReturnWeatherDetail() {
        WeatherDetail detail = Utility.getWeatherDetailObj();

        weatherDetailRepository.save(detail);

        WeatherDetail weatherDetail = weatherDetailRepository.findById(detail.getId()).get();

        Assertions.assertThat(weatherDetail).isNotNull();
    }
}
