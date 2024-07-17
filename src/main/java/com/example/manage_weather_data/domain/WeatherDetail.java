package com.example.manage_weather_data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "weather_detail")
public class WeatherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "temp")
    private Double temp;

    @Column(name = "feels_like")
    private Double feelsLike;

    @Column(name = "temp_min")
    private Double tempMin;

    @Column(name = "temp_max")
    private Double tempMax;

    @Column(name = "pressure")
    private Integer pressure;

    @Column(name = "humidity")
    private Integer humidity;

    @Column(name = "sea_level")
    private Integer seaLevel;

    @Column(name = "grnd_level")
    private Integer grndLevel;

    @OneToOne
    @JoinColumn(name = "wi_id")
    private WeatherInfo weatherInfo;

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        //prevent endless loop
        if (sameAsFormer(weatherInfo))
            return;
        //set new facebook account
        WeatherInfo oldWeatherInfo = this.weatherInfo;
        this.weatherInfo = weatherInfo;
        //remove from the old facebook account
        if (oldWeatherInfo!=null)
            oldWeatherInfo.setMain(null);
        //set myself into new facebook account
        if (weatherInfo!=null)
            weatherInfo.setMain(this);
    }

    private boolean sameAsFormer(WeatherInfo newWeatherInfo) {
        return weatherInfo == null ?
                newWeatherInfo == null : weatherInfo.equals(newWeatherInfo);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Integer seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Integer getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Integer grndLevel) {
        this.grndLevel = grndLevel;
    }
}

