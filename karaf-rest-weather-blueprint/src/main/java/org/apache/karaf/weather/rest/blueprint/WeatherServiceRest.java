package org.apache.karaf.weather.rest.blueprint;

import org.apache.karaf.weather.rest.api.GetWeatherService;
import org.apache.karaf.weather.services.WeatherServiceImpl;
import org.apache.karaf.weather.services.exception.WeatherException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class WeatherServiceRest implements GetWeatherService {
   @Override
   @Path("/{cityName}")
   @GET
   public String getWeather(@PathParam("cityName") String cityName) {
      try {
         System.out.println(WeatherServiceImpl.getInstance().getWeatherData(cityName));
      } catch (WeatherException e) {
         e.printStackTrace();
         System.out.println(e);
      }
      return null;
   }
}
