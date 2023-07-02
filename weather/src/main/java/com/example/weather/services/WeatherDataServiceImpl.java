package com.example.weather.services;

import com.example.weather.dtos.WeatherDataDto;
import com.example.weather.models.*;
import com.example.weather.repositories.WeatherDataRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WeatherDataServiceImpl implements WeatherDataService {
    private final WeatherDataRepository weatherDataRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void save(WeatherDataDto weatherData) {
        WeatherData modelWeatherData = modelMapper.map(weatherData, WeatherData.class);

        Main modelMain = modelWeatherData.getMain();
        modelMain.setWeatherData(modelWeatherData);

        Wind modelWind = modelWeatherData.getWind();
        modelWind.setWeatherData(modelWeatherData);

        Clouds modelClouds = modelWeatherData.getClouds();
        modelClouds.setWeatherData(modelWeatherData);

        Coord modelCoord = modelWeatherData.getCoord();
        modelCoord.setWeatherData(modelWeatherData);

        weatherDataRepository.save(modelWeatherData);
    }
}
