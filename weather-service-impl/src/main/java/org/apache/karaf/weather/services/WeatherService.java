package org.apache.karaf.weather.services;

import org.apache.karaf.weather.services.dto.WeatherDataDto;
import org.apache.karaf.weather.services.exception.WeatherException;

/**
 * Interface for weather services.
 */
public interface WeatherService {

/**
 * Get current weather by longitude and latitude.
 * @param cityName name of the city for weather search
 * @return WeatherDataDto POJO represents JSON response to OpenWeather API.
 *
 */
WeatherDataDto getWeatherData(String cityName) throws WeatherException;

}
