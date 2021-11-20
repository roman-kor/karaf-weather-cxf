package org.apache.karaf.weather.rest.blueprint;

import lombok.extern.slf4j.Slf4j;
import org.apache.karaf.weather.services.WeatherService;
import org.apache.karaf.weather.services.WeatherServiceImpl;
import org.apache.karaf.weather.services.exception.WeatherException;

@Slf4j
public class WeatherServiceRestImpl implements WeatherServiceRest {

    private final WeatherService weatherService;

    public WeatherServiceRestImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
        System.out.println(this.getClass().toString() + " constr");
    }

    @Override
    public String getWeather(String cityName) {
        String response;
        try {
            response = weatherService.getWeatherResponse(cityName);
        } catch (WeatherException e) {
            log.error("An exception:{} occurred retrieving the weather for city:{}", e.getMessage(), cityName);
            response = "An exception occurred! Please, try again...";
        }
        return response;
    }

}
