package com.example.weather.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "main")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Main {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temp;
    @Column(name = "feels_like")
    private Double feelsLike;
    @Column(name = "temp_min")
    private Double tempMin;
    @Column(name = "temp_max")
    private Double tempMax;
    private Integer pressure;
    private Integer humidity;
    @Column(name = "sea_level")
    private Integer seaLevel;
    @Column(name = "grnd_level")
    private Integer grndLevel;

    @OneToOne(mappedBy = "main")
    private WeatherData weatherData;
}
