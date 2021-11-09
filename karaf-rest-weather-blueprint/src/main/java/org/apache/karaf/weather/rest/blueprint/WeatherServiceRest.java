package org.apache.karaf.weather.rest.blueprint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/weather")
public interface WeatherServiceRest {

   @GET
   @Path("city/{cityName}")
   String getWeather(@PathParam("cityName")String cityName);


}
