package com.example.springbootweather.models;

import com.fasterxml.jackson.databind.JsonNode;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherState {

    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        city = value;
    }


    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        country = value;
    }

    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String value) {
        temperature = value;
    }

    private String humidity;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String value) {
        humidity = value;
    }

    private String windspeed;

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String value) {
        windspeed = value;
    }

    private String weather_condition;

    public String getWeather_condition() {
        return weather_condition;
    }

    public void setWeather_condition(String value) {
        weather_condition = value;
    }

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String value) {
        date = value;
    }

    private Long place_id;
    public Long getPlace_id() {
        return place_id;
    }
    public void setPlace_id(Long place_id) {
        this.place_id = place_id;
    }

    public WeatherState(Long id, String city, String country,String temperature, String humidity, String windspeed, String weather_condition, String date, Long place_id) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windspeed = windspeed;
        this.weather_condition = weather_condition;
        this.date = date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = dateFormat.format(new Date());
        this.place_id = place_id;
    }
}

