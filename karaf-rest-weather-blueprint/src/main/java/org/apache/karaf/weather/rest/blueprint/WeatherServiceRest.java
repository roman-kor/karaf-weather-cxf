package org.apache.karaf.weather.rest.blueprint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/weather")
public interface WeatherServiceRest {

   @GET
   @Path("city/{cityName}")
   String getWeather(String cityName);


}
