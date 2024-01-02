package com.example.springbootweather.services;


import com.example.springbootweather.models.Places;
import com.example.springbootweather.models.WeatherState;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherStateAPIService {

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final PlacesService placesService;
    private final WeatherStateService weatherStateService;

    public WeatherStateAPIService(RestTemplate restTemplate, ObjectMapper objectMapper, PlacesService placesService, WeatherStateService weatherStateService) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.placesService = placesService;
        this.weatherStateService = weatherStateService;
    }

    public WeatherState getWeatherState(String cityName) {
        String url = String.format("%s?q=%s&appid=%s", apiUrl, cityName, apiKey);
        try {
            String jsonResponse = restTemplate.getForObject(url, String.class);
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            String longitude = jsonNode.has("coord") ? jsonNode.get("coord").has("lon") ? jsonNode.get("coord").get("lon").asText() : null : null;
            String latitude = jsonNode.has("coord") ? jsonNode.get("coord").has("lat") ? jsonNode.get("coord").get("lat").asText() : null : null;



            Places existingLocation = placesService.findByLocation(cityName);

            if (existingLocation == null) {
                Places newLocation = new Places(cityName, longitude, latitude);
                placesService.insertPlaces(newLocation);
            }



            // Extract weather data
            String country = jsonNode.has("sys") ? jsonNode.get("sys").has("country") ? jsonNode.get("sys").get("country").asText() : null : null;
            String temperature = jsonNode.has("main") ? jsonNode.get("main").has("temp") ? jsonNode.get("main").get("temp").asText() : null : null;
            String humidity = jsonNode.has("main") ? jsonNode.get("main").has("humidity") ? jsonNode.get("main").get("humidity").asText() : null : null;
            String windspeed = jsonNode.has("wind") ? jsonNode.get("wind").has("speed") ? jsonNode.get("wind").get("speed").asText() : null : null;
            String weatherCondition = jsonNode.has("weather") ? (jsonNode.get("weather").isArray() ? (jsonNode.get("weather").get(0).has("description") ? jsonNode.get("weather").get(0).get("description").asText() : null) : null) : null;


            // Create a 'WeatherState' object
            WeatherState weatherState = new WeatherState(null, cityName, country, temperature, humidity, windspeed, weatherCondition, null, null);
            weatherState.setCity(cityName);
            weatherState.setCountry(country);
            weatherState.setTemperature(temperature);
            weatherState.setHumidity(humidity);
            weatherState.setWindspeed(windspeed);
            weatherState.setWeather_condition(weatherCondition);

            // Save 'WeatherState' object to the 'WeatherState' table
            weatherStateService.insertWeatherState(weatherState);

            return weatherState;
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
