package com.example.weather.services;

import com.example.weather.dtos.WeatherDataDto;

public interface SearchService {
    WeatherDataDto search(String location, Double lon, Double lat);
}
