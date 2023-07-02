CREATE TABLE main(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    temp DOUBLE,
    feels_like DOUBLE,
    temp_min DOUBLE,
    temp_max DOUBLE,
    pressure INT,
    humidity INT,
    sea_level INT,
    grnd_level INT
)