package com.example.manage_weather_data.repository;

import com.example.manage_weather_data.domain.Weather;
import com.example.manage_weather_data.utility.Utility;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class WeatherRepositoryTest {

    @Autowired
    private WeatherRepository weatherRepository;

    @Value("${activity.name}")
    private String activityName;

    @Test
    public void checkIfReturnsSavedWeather(){
        System.out.println("activityName\n"+activityName+"\n");
        Weather weather = Utility.getWeatherObj();
        Weather savedWeather = weatherRepository.save(weather);

        Assertions.assertThat(savedWeather).isNotNull();
        Assertions.assertThat(savedWeather.getId()).isGreaterThan(0);

    }

    @Test
    public void checkIfReturnMoreThenOneWeatherInfo() {
        Weather weather = Utility.getWeatherObj();
        Weather weather2 = Utility.getWeatherObj();

        weatherRepository.save(weather);
        weatherRepository.save(weather2);
        List<Weather> weatherList = weatherRepository.findAll();

        Assertions.assertThat(weatherList).isNotNull();
        Assertions.assertThat(weatherList.size()).isEqualTo(2);
    }

    @Test
    public void checkIfReturnWeather() {
        Weather weather = Utility.getWeatherObj();

        weatherRepository.save(weather);

        Weather weatherInfo = weatherRepository.findById(weather.getId()).get();

        Assertions.assertThat(weatherInfo).isNotNull();
    }
}
