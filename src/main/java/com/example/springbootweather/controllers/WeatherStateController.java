package com.example.springbootweather.controllers;

import com.example.springbootweather.models.WeatherState;
import com.example.springbootweather.services.WeatherStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/WeatherState")
public class WeatherStateController {

    private final WeatherStateService weatherStateService;

    @Autowired
    public WeatherStateController(WeatherStateService weatherStateService) {
        this.weatherStateService = weatherStateService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveWeatherState(@RequestBody WeatherState weatherState) {
        int result = weatherStateService.insertWeatherState(weatherState);

        if (result > 0) {
            return ResponseEntity.ok("WeatherState saved successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to save WeatherState");
        }
    }

}


