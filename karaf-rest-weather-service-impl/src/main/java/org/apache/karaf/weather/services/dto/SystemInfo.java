package org.apache.karaf.weather.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents system information from JSON response to OpenWeather API.
 */
public class SystemInfo {
   /**
    * Country name.
    */
   String country;

   /**
    * Method that get country name.
    * @return country name
    */
   @JsonProperty("country")
   public String getCountry() {
      return this.country;
   }

   /**
    * Method that set country name.
    */
   public void setCountry(String country) {
      this.country = country;
   }
}

