package com.example.springbootweather.repository;

import com.example.springbootweather.models.Places;
import com.example.springbootweather.models.WeatherState;

import java.util.List;

public interface WeatherStateRepo {
    int insertWeatherState(WeatherState weatherState);

    List<WeatherState> getWeatherStatesByLocation(Places location);
}
