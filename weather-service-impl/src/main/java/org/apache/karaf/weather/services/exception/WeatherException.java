package org.apache.karaf.weather.services.exception;

/**
 * Custom made org.apache.karaf.weather.services.exception which shows that {@link WeatherException} was performed.
 */
public class WeatherException extends Exception {

   /**
    * Constructs a new org.apache.karaf.weather.services.exception with the specified detail message.
    * @param message the detail message
    */
   public WeatherException(String message) {
      super(message);
   }
}