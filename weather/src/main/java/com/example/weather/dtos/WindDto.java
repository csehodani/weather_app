package com.example.weather.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WindDto {
    private Double speed;
    private Integer deg;
    private Double gust;
}
