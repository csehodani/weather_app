package com.example.weather.services;

import com.example.weather.dtos.WeatherDataDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles({"test"})
public class SearchServiceUnitTest {
    @InjectMocks
    private SearchServiceImpl searchService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void testSearch_WithLocationName() {
        when(restTemplate.getForObject(anyString(), eq(WeatherDataDto.class))).thenReturn(new WeatherDataDto());

        WeatherDataDto result = searchService.search("Budapest", null, null);

        assertNotNull(result);
    }

    @Test
    public void testSearch_WithCoordinates() {
        when(restTemplate.getForObject(anyString(), eq(WeatherDataDto.class))).thenReturn(new WeatherDataDto());

        WeatherDataDto result = searchService.search("", 30.0, 20.0);

        assertNotNull(result);
    }

    @Test
    public void testSearch_WithCoordinatesAndLocationName() {
        when(restTemplate.getForObject(anyString(), eq(WeatherDataDto.class))).thenReturn(new WeatherDataDto());

        WeatherDataDto result = searchService.search("Al Burayqah", 30.0, 20.0);

        assertNotNull(result);
    }
}
