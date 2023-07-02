package com.example.weather.dtos;

import lombok.*;

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
