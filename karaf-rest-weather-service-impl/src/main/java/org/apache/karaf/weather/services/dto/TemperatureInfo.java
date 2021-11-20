package org.apache.karaf.weather.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents temperature information from JSON response to OpenWeather API.
 */
public class TemperatureInfo {

   /**
    * Temperature.
    */
   int temp;

   /**
    * Temperature feels like.
    */
   int feels_like;

   /**
    * Humidity.
    */
   int humidity;

   /**
    * Method that get temperature.
    *
    * @return temperature
    */
   @JsonProperty("temp")
   public int getTemp() {
      return this.temp;
   }

   /**
    * Method that get temperature feels like.
    *
    * @return temperature feels like
    */
   @JsonProperty("feels_like")
   public int getFeels_like() {
      return this.feels_like;
   }

   /**
    * Method that get humidity.
    *
    * @return humidity
    */
   @JsonProperty("humidity")
   public int getHumidity() {
      return this.humidity;
   }

   /**
    * Method that set temperature.
    *
    * @param temp temperature
    */
   public void setTemp(int temp) {
      this.temp = temp;
   }

   /**
    * Method that set temperature.
    *
    * @param feels_like temperature feels like
    */
   public void setFeels_like(int feels_like) {
      this.feels_like = feels_like;
   }

   /**
    * Method that set humidity.
    *
    * @param humidity humidity
    */
   public void setHumidity(int humidity) {
      this.humidity = humidity;
   }
}
