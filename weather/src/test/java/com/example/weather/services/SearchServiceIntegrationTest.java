package com.example.weather.services;

import com.example.weather.dtos.WeatherDataDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles({"test"})
public class SearchServiceIntegrationTest {
    @Autowired
    private SearchService searchService;

    @Test
    public void testSearch_WithLocationName() {
        WeatherDataDto result = searchService.search("Budapest", null, null);
        assertNotNull(result);
        assertEquals("Budapest", result.getName());
    }

    @Test
    public void testSearch_WithCoordinates() {
        WeatherDataDto result = searchService.search("", 20.0, 30.0);
        assertNotNull(result);
        assertEquals("Al Burayqah", result.getName());
    }

    @Test
    public void testSearch_WithCoordinatesAndLocationName() {
        WeatherDataDto result = searchService.search("Al Burayqah", 20.0, 30.0);
        assertNotNull(result);
        assertEquals("Al Burayqah", result.getName());
    }
}
