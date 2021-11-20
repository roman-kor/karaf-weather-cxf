package org.apache.karaf.weather.rest.blueprint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/weather")
public interface WeatherServiceRest {

   @GET
   @Path("city/{cityName}")
   @Produces(MediaType.APPLICATION_JSON)
   String getWeather(@PathParam("cityName")String cityName);


}
