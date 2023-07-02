package com.example.weather.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coord")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Coord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double lat;
    private Double lon;

    @OneToOne(mappedBy = "coord")
    private WeatherData weatherData;
}
