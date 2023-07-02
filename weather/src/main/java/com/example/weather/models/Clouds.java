package com.example.weather.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clouds")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Clouds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "all_data")
    private Integer all;

    @OneToOne(mappedBy = "clouds")
    private WeatherData weatherData;
}
