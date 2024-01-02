package com.example.springbootweather.models;

import com.example.springbootweather.services.WeatherStateAPIService;
import com.example.springbootweather.services.WeatherStateService;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduledMethod {

    @Autowired
    private WeatherStateService weatherStateService;

    @Autowired
    private WeatherStateAPIService weatherStateAPIService;

    @Scheduled(fixedRate = 60000)
    //@PostConstruct
    public void retrieveWeatherData() {
        try {
            String City = "London";
            WeatherState weatherData = weatherStateAPIService.getWeatherState(City);
            if (weatherData != null) {
                weatherStateService.insertWeatherState(weatherData);
            } else {
                System.out.println("Failed to retrieve weather data for " + City);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
