CREATE TABLE weather_data(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL ,
    clouds_id INT UNIQUE,
    main_id INT UNIQUE,
    wind_id INT UNIQUE,
    coord_id INT UNIQUE,
    timezone INT,
    FOREIGN KEY (clouds_id) REFERENCES weather.clouds(id),
    FOREIGN KEY (main_id) REFERENCES weather.main(id),
    FOREIGN KEY (wind_id) REFERENCES weather.wind(id),
    FOREIGN KEY (coord_id) REFERENCES weather.coord(id)

)