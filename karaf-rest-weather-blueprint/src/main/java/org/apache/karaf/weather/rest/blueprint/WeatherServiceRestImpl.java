package org.apache.karaf.weather.rest.blueprint;

import org.apache.karaf.weather.services.WeatherService;
import org.apache.karaf.weather.services.WeatherServiceImpl;
import org.apache.karaf.weather.services.exception.WeatherException;

public class WeatherServiceRestImpl implements WeatherServiceRest {
   private final WeatherService weatherService;

   public WeatherServiceRestImpl(WeatherServiceImpl weatherService) {
      this.weatherService = weatherService;
   }

   @Override
   public String getWeather(String cityName) {
      String response;
      try {
         response = weatherService.getWeatherData(cityName).toString();
      } catch (WeatherException e) {
         e.printStackTrace();
         response = e.getMessage();
      }
      return response;
   }
}
