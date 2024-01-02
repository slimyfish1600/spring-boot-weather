package com.example.springbootweather.repository;

import com.example.springbootweather.models.Places;

public interface PlacesRepository {
    Places findByLocation(String location);

    int insertPlaces(Places places);

    boolean locationExists(String location);

}
