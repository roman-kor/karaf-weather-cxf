package org.apache.karaf.weather.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.karaf.weather.services.dto.WeatherDataDto;
import org.apache.karaf.weather.services.exception.WeatherException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class WeatherServiceImpl implements WeatherService {

   /**
    * Bad Request response status code indicates that the server cannot or
    * will not process the request due to something that is perceived to be a client error.
    */
   private final int ERROR_CODE = 400;


/**
 * Get current weather by longitude and latitude.
 *
 * @param cityName name of the city for weather search
 * @return WeatherDataDto POJO represents JSON response to OpenWeather API.
 */
   public WeatherDataDto getWeatherData(String cityName) throws WeatherException {
      ObjectMapper mapper;
      URL url;
      try {
         url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" +
                 cityName.replaceAll(" ","%20") + "&appid=dc4a1aa311220f57155e56dba5f8a561&units=metric");
         if (log.isInfoEnabled()) {
            log.info("Generated url:{}", url);
         }
         HttpURLConnection http = (HttpURLConnection) url.openConnection();
         int statusCode = http.getResponseCode();
         if (statusCode >= ERROR_CODE) {
            throw new WeatherException(cityName);
         }
         mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         return mapper.readValue(url, WeatherDataDto.class);
      } catch (IOException e) {
         throw new WeatherException(cityName);
      }
   }
}
