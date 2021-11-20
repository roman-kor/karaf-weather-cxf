package org.apache.karaf.weather.rest.blueprint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.karaf.weather.services.GetWeatherDataService;
import org.apache.karaf.weather.services.WeatherService;
import org.apache.karaf.weather.services.WeatherServiceImpl;
import org.apache.karaf.weather.services.exception.WeatherException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WeatherServiceRestImplTest {

    private WeatherServiceRest weatherServiceRest;
    private WeatherService weatherService;

    @Test
    public void testResponse() throws WeatherException {
        weatherService = Mockito.mock(WeatherServiceImpl.class);
        weatherServiceRest = new WeatherServiceRestImpl(weatherService);
        String city = "kiev";
        String expectedResponse = "foo";
        when(weatherService.getWeatherResponse(city)).thenReturn(expectedResponse);
        String actualResponse = weatherServiceRest.getWeather(city);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testException() throws WeatherException {
        weatherService = new WeatherServiceImpl(new GetWeatherDataService());
        weatherServiceRest = new WeatherServiceRestImpl(weatherService);
        String city = "k123ev";
        String expectedResponse = "An exception occurred! Please, try again...";
        String actualResponse = weatherServiceRest.getWeather(city);
        assertEquals(expectedResponse, actualResponse);
    }

}