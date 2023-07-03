package com.example.weather.services;

import com.example.weather.dtos.*;
import com.example.weather.models.*;
import com.example.weather.repositories.WeatherDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles({"test"})
public class WeatherDataServiceUnitTest {

    @InjectMocks
    private WeatherDataServiceImpl weatherDataService;

    @Mock
    private WeatherDataRepository weatherDataRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    public void save() {
        CloudsDto clouds = new CloudsDto();
        Clouds savedClouds = new Clouds();
        savedClouds.setId(1L);

        CoordDto coord = new CoordDto();
        Coord savedCoord = new Coord();
        savedCoord.setId(1L);

        MainDto main = new MainDto();
        Main savedMain = new Main();
        savedMain.setId(1L);

        WindDto wind = new WindDto();
        Wind savedWind = new Wind();
        savedWind.setId(1L);

        WeatherDataDto weatherData = new WeatherDataDto();
        weatherData.setClouds(clouds);
        weatherData.setMain(main);
        weatherData.setCoord(coord);
        weatherData.setWind(wind);

        WeatherData savedWeatherData = new WeatherData();
        savedWeatherData.setId(1L);
        savedWeatherData.setWind(savedWind);
        savedWeatherData.setMain(savedMain);
        savedWeatherData.setCoord(savedCoord);
        savedWeatherData.setClouds(savedClouds);

        when(weatherDataRepository.save(any())).thenReturn(savedWeatherData);

        assertDoesNotThrow(() -> weatherDataService.save(weatherData));
    }
}
