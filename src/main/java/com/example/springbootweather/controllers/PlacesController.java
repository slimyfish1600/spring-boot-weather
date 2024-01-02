package com.example.springbootweather.controllers;

import com.example.springbootweather.models.Places;
import com.example.springbootweather.models.WeatherState;
import com.example.springbootweather.services.PlacesService;
import com.example.springbootweather.services.WeatherStateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlacesController {

    private final PlacesService placesService;
    private final WeatherStateService weatherStateService;

    public PlacesController(PlacesService placesService, WeatherStateService weatherStateService) {
        this.placesService = placesService;
        this.weatherStateService = weatherStateService;
    }

    @PostMapping("/add")
    public String addPlace(@RequestBody Places places) {
        int result = placesService.insertPlaces(places);
        if (result > 0) {
            return "Place added successfully";
        } else {
            return "Failed to add place";
        }
    }

    @GetMapping("/{locationName}/weather")
    public List<WeatherState> getWeatherStatesByLocation(@PathVariable String locationName) {
        Places location = placesService.findByLocation(locationName);
        if (location != null) {
            return weatherStateService.getWeatherStatesByLocation(location);
        } else {
            return null;
        }
    }
}
