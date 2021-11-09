package org.apache.karaf.weather.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents location from JSON response to OpenWeather API.
 */
public class LocationInfo {
   /**
    * Longitude
    */
   double longitude;

   /**
    * Latitude
    */
   double latitude;

   /**
    * Method that get longitude.
    * @return longitude
    */
   @JsonProperty("lon")
   public double getLongitude() {
      return this.longitude;
   }

   /**
    * Method that get latitude.
    * @return latitude
    */
   @JsonProperty("lat")
   public double getLatitude() {
      return this.latitude;
   }

   /**
    * Method that set longitude.
    */
   public void setLongitude(double longitude) {
      this.longitude = longitude;
   }

   /**
    * Method that set latitude.
    */
   public void setLatitude(double latitude) {
      this.latitude = latitude;
   }
}
