package com.example.weather.controllers;

import com.example.weather.dtos.WeatherDataDto;
import com.example.weather.services.SearchService;
import com.example.weather.services.WeatherDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherDataService weatherDataService;
    private final SearchService searchService;

    @GetMapping(value = "/weather")
    public ResponseEntity<WeatherDataDto> getWeather(@RequestParam(value = "location") String location,
                                                     @RequestParam(value = "lat", required = false) Double lat,
                                                     @RequestParam(value = "lon", required = false) Double lon) {
        WeatherDataDto weatherData = searchService.search(location, lat, lon);

        if (weatherData != null) {
            // Save the weather data to the database
            weatherDataService.save(weatherData);

            // Return the weather data in the API response
            return ResponseEntity.ok(weatherData);
        } else {
            // No weather data available
            return ResponseEntity.notFound().build();
        }

    }
}
