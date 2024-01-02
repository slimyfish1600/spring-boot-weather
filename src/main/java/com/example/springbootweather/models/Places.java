package com.example.springbootweather.models;


public class Places {
    private String location;
    private String longitude;
    private String latitude;

    private Long id;

    // Constructors
    public Places(String location, String longitude, String latitude) {
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Places() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
