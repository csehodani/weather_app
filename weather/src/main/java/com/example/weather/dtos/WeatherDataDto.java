package com.example.weather.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WeatherDataDto {
    private Long id;
    private String name;
    private CloudsDto clouds;
    private MainDto main;
    private WindDto wind;
    private CoordDto coord;
    private int timezone;
}
