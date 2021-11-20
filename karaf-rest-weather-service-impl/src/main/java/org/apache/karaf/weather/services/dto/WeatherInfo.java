package org.apache.karaf.weather.services.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents weather information from JSON response to OpenWeather API.
 */
public class WeatherInfo {

   /**
    * Weather description.
    */
   String description;

   /**
    * Weather icon id.
    */
   String icon;

   /**
    * Method that get weather description.
    *
    * @return weather description
    */
   @JsonProperty("description")
   public String getDescription() {
      return this.description;
   }

   /**
    * Method that get weather icon id.
    *
    * @return weather icon id
    */
   @JsonProperty("icon")
   public String getIcon() {
      return this.icon;
   }

   /**
    * Method that set weather description.
    *
    * @param description weather description
    */
   public void setDescription(String description) {
      this.description = description;
   }

   /**
    * Method that get weather icon id.
    *
    * @param icon weather icon id
    */
   public void setIcon(String icon) {
      this.icon = icon;
   }
}
