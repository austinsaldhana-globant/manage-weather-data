package com.example.manage_weather_data.dto;


import java.time.Instant;

public class WeatherResponseDTO {
    private Integer weatherId;
    private String main;
    private String description;
    private String icon;
    private WeatherDetailResponseDTO weatherDetail;
    private Instant createdDate;
    private String city;

    public WeatherResponseDTO() {
    }

    public WeatherResponseDTO(Integer weatherId, String main, String description, String icon, WeatherDetailResponseDTO weatherDetail, Instant createdDate, String city) {
        this.weatherId = weatherId;
        this.main = main;
        this.description = description;
        this.icon = icon;
        this.weatherDetail = weatherDetail;
        this.createdDate = createdDate;
        this.city = city;
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

    public WeatherDetailResponseDTO getWeatherDetail() {
        return weatherDetail;
    }

    public void setWeatherDetail(WeatherDetailResponseDTO weatherDetail) {
        this.weatherDetail = weatherDetail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherResponseDTO that = (WeatherResponseDTO) o;

        if (weatherId != null ? !weatherId.equals(that.weatherId) : that.weatherId != null) return false;
        if (main != null ? !main.equals(that.main) : that.main != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (weatherDetail != null ? !weatherDetail.equals(that.weatherDetail) : that.weatherDetail != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        return city != null ? city.equals(that.city) : that.city == null;
    }

    @Override
    public int hashCode() {
        int result = weatherId != null ? weatherId.hashCode() : 0;
        result = 31 * result + (main != null ? main.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (weatherDetail != null ? weatherDetail.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeatherResponseDTO{");
        sb.append("weatherId=").append(weatherId);
        sb.append(", main='").append(main).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", icon='").append(icon).append('\'');
        sb.append(", weatherDetail=").append(weatherDetail);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
