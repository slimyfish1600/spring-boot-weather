package com.example.springbootweather.services;

import com.example.springbootweather.models.Places;
import com.example.springbootweather.repository.PlacesRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PlacesService implements PlacesRepository {

    private final JdbcTemplate jdbcTemplate;

    public PlacesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Places findByLocation(String location) {
        String sql = "SELECT * FROM Places WHERE location = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{location}, BeanPropertyRowMapper.newInstance(Places.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
    public int insertPlaces(Places places) {
        String sql = "INSERT INTO places(location, Longitude, Latitude) VALUES(?, ?, ?)";
        try {
            return jdbcTemplate.update(sql, places.getLocation(), places.getLongitude(), places.getLatitude());
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error inserting places", ex);
        }
    }

    @Override
    public boolean locationExists(String location) {
        return false;
    }

}
