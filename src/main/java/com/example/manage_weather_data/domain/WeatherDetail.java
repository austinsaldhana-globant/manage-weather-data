package com.example.manage_weather_data.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "weather_detail")
public class WeatherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;
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
    @MapsId
    @JoinColumn(name = "w_id")
    private Weather weather;


    public WeatherDetail() {
    }

    public WeatherDetail(Integer id, Double temp, Double feelsLike, Double tempMin, Double tempMax, Integer pressure,
                         Integer humidity, Integer seaLevel, Integer grndLevel, Weather weather) {
        Id = id;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
        this.weather = weather;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherDetail that = (WeatherDetail) o;

        if (Id != null ? !Id.equals(that.Id) : that.Id != null) return false;
        if (temp != null ? !temp.equals(that.temp) : that.temp != null) return false;
        if (feelsLike != null ? !feelsLike.equals(that.feelsLike) : that.feelsLike != null) return false;
        if (tempMin != null ? !tempMin.equals(that.tempMin) : that.tempMin != null) return false;
        if (tempMax != null ? !tempMax.equals(that.tempMax) : that.tempMax != null) return false;
        if (pressure != null ? !pressure.equals(that.pressure) : that.pressure != null) return false;
        if (humidity != null ? !humidity.equals(that.humidity) : that.humidity != null) return false;
        if (seaLevel != null ? !seaLevel.equals(that.seaLevel) : that.seaLevel != null) return false;
        if (grndLevel != null ? !grndLevel.equals(that.grndLevel) : that.grndLevel != null) return false;
        return weather != null ? weather.equals(that.weather) : that.weather == null;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (temp != null ? temp.hashCode() : 0);
        result = 31 * result + (feelsLike != null ? feelsLike.hashCode() : 0);
        result = 31 * result + (tempMin != null ? tempMin.hashCode() : 0);
        result = 31 * result + (tempMax != null ? tempMax.hashCode() : 0);
        result = 31 * result + (pressure != null ? pressure.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (seaLevel != null ? seaLevel.hashCode() : 0);
        result = 31 * result + (grndLevel != null ? grndLevel.hashCode() : 0);
        result = 31 * result + (weather != null ? weather.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeatherDetail{");
        sb.append("Id=").append(Id);
        sb.append(", temp=").append(temp);
        sb.append(", feelsLike=").append(feelsLike);
        sb.append(", tempMin=").append(tempMin);
        sb.append(", tempMax=").append(tempMax);
        sb.append(", pressure=").append(pressure);
        sb.append(", humidity=").append(humidity);
        sb.append(", seaLevel=").append(seaLevel);
        sb.append(", grndLevel=").append(grndLevel);
        sb.append('}');
        return sb.toString();
    }
}

