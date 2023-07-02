package com.example.weather.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MainDto {
    private Double temp;
    @JsonProperty(value = "feels_like")
    private Double feelsLike;
    @JsonProperty(value = "temp_min")
    private Double tempMin;
    @JsonProperty(value = "temp_max")
    private Double tempMax;
    private Integer pressure;
    private Integer humidity;
    @JsonProperty(value = "sea_level")
    private Integer seaLevel;
    @JsonProperty(value = "grnd_level")
    private Integer grndLevel;
}
