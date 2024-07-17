package com.example.manage_weather_data.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "main")
    private String main;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @ManyToOne
    @JoinColumn(name="wi_id")
    private WeatherInfo weatherInfo;

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }


    public void setWeatherInfo(WeatherInfo weatherInfo) {
        //prevent endless loop
        if (sameAsFormer(weatherInfo))
            return ;
        //set new owner
        WeatherInfo oldWeatherInfo = this.weatherInfo;
        this.weatherInfo = weatherInfo;
        //remove from the old owner
        if (oldWeatherInfo!=null)
            oldWeatherInfo.removeWeather(this);
        //set myself into new owner
        if (weatherInfo!=null)
            weatherInfo.addWeather(this);
    }

    private boolean sameAsFormer(WeatherInfo newWeatherInfo) {
        return weatherInfo==null? newWeatherInfo == null : weatherInfo.equals(newWeatherInfo);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
