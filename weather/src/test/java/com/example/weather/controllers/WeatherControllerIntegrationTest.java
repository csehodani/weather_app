package com.example.weather.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.net.http.HttpRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles({"test"})
public class WeatherControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getWeather_GetDataWithLocation_StatusIsOk() throws Exception {
        mockMvc.perform(get("/weather?location=Baja"))
                .andExpect(status().isOk());
    }

    @Test
    public void getWeather_GetDataWithCoordinates_StatusIsOk() throws Exception {
        mockMvc.perform(get("/weather?location=&lat=40&lon=30"))
                .andExpect(status().isOk());
    }

    @Test
    public void getWeather_GetDataWithCoordinatesAndLocation_StatusIsOk() throws Exception {
        mockMvc.perform(get("/weather?location=Pazaryeri&lat=40&lon=30"))
                .andExpect(status().isOk());
    }
}
