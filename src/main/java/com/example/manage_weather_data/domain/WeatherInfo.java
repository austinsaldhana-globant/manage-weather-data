package com.example.manage_weather_data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class WeatherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "weatherInfo")
    private List<Weather> weather = new ArrayList<Weather>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wd_id")
    private WeatherDetail main;

    @Column(name = "city")
    private String city;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date addedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public WeatherDetail getMain() {
        return main;
    }

    public void setMain(WeatherDetail main) {
        this.main = main;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    /**
     * Returns a collection with owned twitter accounts. The
     * returned collection is a defensive copy.
     *
     * @return a collection with owned twitter accounts
     */
    public List<Weather> getWeather() {
        //defensive copy, nobody will be able to change
        //the list from the outside
        return new ArrayList<Weather>(weather);
    }

    /**
     * Add new account to the person. The method keeps
     * relationships consistency:
     * * this person is set as the account owner
     */
    public void addWeather(Weather w) {
        //prevent endless loop
        if (weather.contains(w))
            return ;
        //add new account
        weather.add(w);
        //set myself into the twitter account
        w.setWeatherInfo(this);
    }

    /**
     * Removes the account from the person. The method keeps
     * relationships consistency:
     * * the account will no longer reference this person as its owner
     */
    public void removeWeather(Weather w) {
        //prevent endless loop
        if (!weather.contains(w))
            return ;
        //remove main weather info
        weather.remove(w);
        //remove myself from the main weather list
        w.setWeatherInfo(null);
    }



}
