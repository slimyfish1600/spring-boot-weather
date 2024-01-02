package com.example.springbootweather.services;

import com.example.springbootweather.models.Places;
import com.example.springbootweather.models.WeatherState;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.springbootweather.repository.WeatherStateRepo;

import java.util.List;

@Service
public class WeatherStateService implements WeatherStateRepo {
    private final JdbcTemplate jdbcTemplate;

    public WeatherStateService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertWeatherState(WeatherState weatherState) {
        String sql = "INSERT INTO WeatherState (city, country, temperature, humidity, windspeed, weather_condition, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                weatherState.getCity(), weatherState.getCountry(), weatherState.getTemperature(), weatherState.getHumidity(),
                weatherState.getWindspeed(), weatherState.getWeather_condition(), weatherState.getDate()
        );
    }
    @Override
    public List<WeatherState> getWeatherStatesByLocation(Places location) {
        String sql = "SELECT * FROM WeatherState WHERE places_id = ?";
        return jdbcTemplate.query(sql, new Object[]{location.getId()}, BeanPropertyRowMapper.newInstance(WeatherState.class));
    }
}

