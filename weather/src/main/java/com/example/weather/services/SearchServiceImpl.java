package com.example.weather.services;

import com.example.weather.dtos.WeatherDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    @Value("${openweathermap.api.url}")
    private String API_BASE_URL;

    @Value("${openweathermap.api.key}")
    private String API_KEY;

    private final RestTemplate restTemplate;

    @Override
    public WeatherDataDto search(String location, Double lon, Double lat) {
        String apiUrl = API_BASE_URL + "?q=" + location + "&lon=" + lon + "&lat=" + lat + "&appid=" + API_KEY;

        return restTemplate.getForObject(apiUrl, WeatherDataDto.class);
    }
}
