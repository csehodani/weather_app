package com.example.weather.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wind")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double speed;
    private Integer deg;
    private Double gust;

    @OneToOne(mappedBy = "wind")
    private WeatherData weatherData;
}
