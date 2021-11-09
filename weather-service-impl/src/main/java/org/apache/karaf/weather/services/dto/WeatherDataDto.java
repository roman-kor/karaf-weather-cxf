package org.apache.karaf.weather.services.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * POJO representation of a json from Open Weather API response.
 * <p>
 *     Example of Open Weather API response.
 * <p>
 *    <i>
 * { <br>
 *    "coord":{ <br>
 *       "lon":55, <br>
 *       "lat":-12 <br>
 *    }, <br>
 *    "weather":[ <br>
 *       { <br>
 *          "id":800, <br>
 *          "main":"Clear", <br>
 *          "description":"clear sky", <br>
 *          "icon":"01n" <br>
 *       } <br>
 *    ], <br>
 *    "base":"stations", <br>
 *    "main":{ <br>
 *       "temp":28.34, <br>
 *       "feels_like":30.72, <br>
 *       "temp_min":28.34, <br>
 *       "temp_max":28.34, <br>
 *       "pressure":1010, <br>
 *       "humidity":73,<br>
 *       "sea_level":1010,<br>
 *       "grnd_level":1010 <br>
 *    }, <br>
 *    "visibility":10000, <br>
 *    "wind":{ <br>
 *       "speed":4.11, <br>
 *       "deg":103 <br>
 *    }, <br>
 *    "clouds":{ <br>
 *       "all":3 <br>
 *    }, <br>
 *    "dt":1612820129, <br>
 *    "sys":{ <br>
 *       "sunrise":1612837080, <br>
 *       "sunset":1612882232 <br>
 *    }, <br>
 *    "timezone":14400, <br>
 *    "id":0, <br>
 *    "name":"", <br>
 *    "cod":200 <br>
 * } <br>
 *     <i>
 * @see <a href="https://openweathermap.org/weather-conditions"> Open Weather API
 * documentation to learn more about respone from API.
 */
public class WeatherDataDto {
   /**
    * Object of class {@link LocationInfo} which contains latitude and longitude.
    */
   LocationInfo location;

   /**
    * Object of class {@link WeatherInfo} which contains description and icon of weather.
    */
   List<WeatherInfo> weather;

   /**
    * Object of class {@link TemperatureInfo} which contains humidity, temperature and fells like.
    */
   TemperatureInfo temperatureInfo;

   /**
    * Object of class {@link SystemInfo} which contains country name.
    */
   SystemInfo systemInfo;

   /**
    * City name.
    */
   String cityName;

   /**
    * Method that get object of {@link LocationInfo} class.
    * @return object of {@link LocationInfo} class
    */
   @JsonProperty("coord")
   public LocationInfo getLocation() {
      return this.location;
   }

   /**
    * Method that get object of {@link WeatherInfo} class.
    * @return object of {@link WeatherInfo} class
    */
   @JsonProperty("weather")
   public List<WeatherInfo> getWeather() {
      return this.weather;
   }

   /**
    * Method that get object of {@link TemperatureInfo} class.
    * @return object of {@link TemperatureInfo} class
    */
   @JsonProperty("main")
   public TemperatureInfo getTemperatureInfo() {
      return this.temperatureInfo;
   }

   /**
    * Method that get object of {@link SystemInfo} class.
    * @return object of {@link SystemInfo} class
    */
   @JsonProperty("sys")
   public SystemInfo getSystemInfo() {
      return this.systemInfo;
   }

   /**
    * Method that get city name.
    * @return city name
    */
   @JsonProperty("name")
   public String getCityName() {
      return this.cityName;
   }

   /**
    * Method that set object of {@link SystemInfo} class.
    * @param location object of {@link SystemInfo} class
    */
   public void setLocation(LocationInfo location) {
      this.location = location;
   }

   /**
    * Method that set object of {@link WeatherInfo} class.
    * @param weather object of {@link WeatherInfo} class
    */
   public void setWeather(List<WeatherInfo> weather) {
      this.weather = weather;
   }

   /**
    * Method that set object of {@link TemperatureInfo} class.
    * @param temperatureInfo object of {@link TemperatureInfo} class
    */
   public void setTemperatureInfo(TemperatureInfo temperatureInfo) {
      this.temperatureInfo = temperatureInfo;
   }

   /**
    * Method that set object of {@link SystemInfo} class.
    * @param systemInfo object of {@link SystemInfo} class
    */
   public void setSystemInfo(SystemInfo systemInfo) {
      this.systemInfo = systemInfo;
   }

   /**
    * Method that set city name.
    * @param cityName name of the city
    */
   public void setCityName(String cityName) {
      this.cityName = cityName;
   }


   @Override
   public String toString() {
      return "WeatherDataDto{" +
              "location=" + location +
              ", weather=" + weather +
              ", temperatureInfo=" + temperatureInfo +
              ", systemInfo=" + systemInfo +
              ", cityName='" + cityName + '\'' +
              '}';
   }
}
