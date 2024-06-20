package com.example.manage_weather_data.domain;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "weather_id")
    private Integer weatherId;
    @Column(name = "main")
    private String main;
    @Column(name = "description")
    private String description;
    @Column(name = "icon")
    private String icon;
    @Column(name = "city")
    private String city;
    @OneToOne(mappedBy = "weather", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private WeatherDetail weatherDetail;
    @Column(name = "created_date")
    private Instant createdDate;

    public Weather() {
    }

    public Weather(Integer id, Integer weatherId, String main, String description, String icon, String city, WeatherDetail weatherDetail, Instant createdDate) {
        this.id = id;
        this.weatherId = weatherId;
        this.main = main;
        this.description = description;
        this.icon = icon;
        this.city = city;
        this.weatherDetail = weatherDetail;
        this.createdDate = createdDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public WeatherDetail getWeatherDetail() {
        return weatherDetail;
    }

    public void setWeatherDetail(WeatherDetail weatherDetail) {
        this.weatherDetail = weatherDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (id != null ? !id.equals(weather.id) : weather.id != null) return false;
        if (weatherId != null ? !weatherId.equals(weather.weatherId) : weather.weatherId != null) return false;
        if (main != null ? !main.equals(weather.main) : weather.main != null) return false;
        if (description != null ? !description.equals(weather.description) : weather.description != null) return false;
        if (icon != null ? !icon.equals(weather.icon) : weather.icon != null) return false;
        if (city != null ? !city.equals(weather.city) : weather.city != null) return false;
        if (weatherDetail != null ? !weatherDetail.equals(weather.weatherDetail) : weather.weatherDetail != null)
            return false;
        return createdDate != null ? createdDate.equals(weather.createdDate) : weather.createdDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (weatherId != null ? weatherId.hashCode() : 0);
        result = 31 * result + (main != null ? main.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (weatherDetail != null ? weatherDetail.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Weather{");
        sb.append("id=").append(id);
        sb.append(", weatherId=").append(weatherId);
        sb.append(", main='").append(main).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", weatherDetail=").append(weatherDetail);
        sb.append(", createdDate=").append(createdDate);
        sb.append('}');
        return sb.toString();
    }
}
