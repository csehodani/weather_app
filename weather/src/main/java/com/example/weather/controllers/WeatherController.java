package com.example.weather.controllers;

import com.example.weather.dtos.WeatherDataDto;
import com.example.weather.services.SearchService;
import com.example.weather.services.WeatherDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

        return Optional.ofNullable(weatherData)
                .map(it -> {
                    weatherDataService.save(it);
                    return ResponseEntity.ok(it);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
