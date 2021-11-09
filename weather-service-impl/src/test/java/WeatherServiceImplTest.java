import org.apache.karaf.weather.services.dto.WeatherDataDto;
import org.apache.karaf.weather.services.exception.WeatherException;
import org.apache.karaf.weather.services.WeatherService;
import org.apache.karaf.weather.services.WeatherServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link WeatherServiceImpl} tests.
 */
class WeatherServiceImplTest {

   /**
    * {@link WeatherServiceImpl} object.
    */
   WeatherService weatherService;

   /**
    * Maximal temperature.
    */
   private final int MAX_TEMPERATURE = 60;

   /**
    * Minimal temperature.
    */
   private final int MIN_TEMPERATURE = -80;

   /**
    * Maximal humidity.
    */
   private final int MAX_HUMIDITY = 100;

   /**
    * Minimal humidity.
    */
   private final int MIN_HUMIDITY = 0;

   /**
    * {@link WeatherServiceImpl} tests.
    *
    */
   @Test
   public void serviceValidCases() throws WeatherException {
      //Asia-Europe
      checkValidationWeatherDataDto("Moscow");
      //Africa
      checkValidationWeatherDataDto("Ceuta");
      checkValidationWeatherDataDto("Melilla");
      checkValidationWeatherDataDto("Moyale");
      checkValidationWeatherDataDto("Walvis Bay");
//        North America
//        United States/Canada
      checkValidationWeatherDataDto("Juneau");
      checkValidationWeatherDataDto("Blaine");
      checkValidationWeatherDataDto("Sumas");
      checkValidationWeatherDataDto("Laurier");
      checkValidationWeatherDataDto("Portal");
      checkValidationWeatherDataDto("Gretna");
      checkValidationWeatherDataDto("Pembina");
      checkValidationWeatherDataDto("Evanston");
      checkValidationWeatherDataDto("Baudette");
      checkValidationWeatherDataDto(" Amherstburg");
      checkValidationWeatherDataDto("Wyandotte");
      checkValidationWeatherDataDto("Detroit");
      checkValidationWeatherDataDto("Algonac");
      checkValidationWeatherDataDto("Marysville");
      checkValidationWeatherDataDto("Buffalo");
      checkValidationWeatherDataDto("Lewiston");
      checkValidationWeatherDataDto("Cape Vincent");
      checkValidationWeatherDataDto("Morristown");
      checkValidationWeatherDataDto("Ogdensburg");
      checkValidationWeatherDataDto("Massena");
      checkValidationWeatherDataDto("Rouses Point");
      checkValidationWeatherDataDto("Canaan");
      checkValidationWeatherDataDto("Norton");
      checkValidationWeatherDataDto("Frenchville");
      checkValidationWeatherDataDto("Madawaska");
      checkValidationWeatherDataDto("Hamlin");
      checkValidationWeatherDataDto("Limestone");
      checkValidationWeatherDataDto("Easton");
      checkValidationWeatherDataDto("Blaine");
      checkValidationWeatherDataDto("Bridgewater");
      checkValidationWeatherDataDto("Monticello");
      checkValidationWeatherDataDto("Littleton");
      checkValidationWeatherDataDto("Houlton");
      checkValidationWeatherDataDto("Hodgdon");
      checkValidationWeatherDataDto("Cary");
      checkValidationWeatherDataDto("Amity");
      checkValidationWeatherDataDto("Orient");
      checkValidationWeatherDataDto("Weston");
      checkValidationWeatherDataDto("Danforth");
      checkValidationWeatherDataDto("Baileyville");
      checkValidationWeatherDataDto("Vanceboro");
      checkValidationWeatherDataDto("Baring");
      checkValidationWeatherDataDto("Calais");
      checkValidationWeatherDataDto("Robbinston");
      checkValidationWeatherDataDto("Perry");
      checkValidationWeatherDataDto("Eastport");
      checkValidationWeatherDataDto("Lubec");
//Within Canada
      checkValidationWeatherDataDto("Morrisburg");
      checkValidationWeatherDataDto("Lloydminster");
      checkValidationWeatherDataDto("Flin Flon");
      checkValidationWeatherDataDto("Ottawa");
      //United States/Mexico
      checkValidationWeatherDataDto("San Diego");
      checkValidationWeatherDataDto("Tecate");
      checkValidationWeatherDataDto("Calexico");
      checkValidationWeatherDataDto("Gadsden");
      checkValidationWeatherDataDto("Yuma");
      checkValidationWeatherDataDto("Sonoyta");
      checkValidationWeatherDataDto("Naco");
   }

   @Test
   public void serviceInvalidCases(){
      //Asia-Europe
      weatherServiceCheckException("Mossscow");
      //Africa
      weatherServiceCheckException("Cweeuta");
      weatherServiceCheckException("Mewlilla");
      weatherServiceCheckException("Moyaleee");
      weatherServiceCheckException("Walvise Bay");
//        North America
//        United States/Canada
      weatherServiceCheckException("Juneaue");
      weatherServiceCheckException("Blainee");
      weatherServiceCheckException("Sumase");
      weatherServiceCheckException("Lauriere");
//      weatherServiceCheckException("Portale");
//      weatherServiceCheckException("Gretna");
//      weatherServiceCheckException("Pembina");
//      weatherServiceCheckException("Evanston");
//      weatherServiceCheckException("Baudette");
//      weatherServiceCheckException(" Amherstburg");
//      weatherServiceCheckException("Wyandotte");
//      weatherServiceCheckException("Detroit");
//      weatherServiceCheckException("Algonac");
//      weatherServiceCheckException("Marysville");
//      weatherServiceCheckException("Buffalo");
//      weatherServiceCheckException("Lewiston");
//      weatherServiceCheckException("Cape Vincent");
//      weatherServiceCheckException("Morristown");
//      weatherServiceCheckException("Ogdensburg");
//      weatherServiceCheckException("Massena");
//      weatherServiceCheckException("Rouses Point");
//      weatherServiceCheckException("Canaan");
//      weatherServiceCheckException("Norton");
//      weatherServiceCheckException("Frenchville");
//      weatherServiceCheckException("Madawaska");
//      weatherServiceCheckException("Hamlin");
//      weatherServiceCheckException("Limestone");
//      weatherServiceCheckException("Easton");
//      weatherServiceCheckException("Blaine");
//      weatherServiceCheckException("Bridgewater");
//      weatherServiceCheckException("Monticello");
//      weatherServiceCheckException("Littleton");
//      weatherServiceCheckException("Houlton");
//      weatherServiceCheckException("Hodgdon");
//      weatherServiceCheckException("Cary");
//      weatherServiceCheckException("Amity");
//      weatherServiceCheckException("Orient");
//      weatherServiceCheckException("Weston");
//      weatherServiceCheckException("Danforth");
//      weatherServiceCheckException("Baileyville");
//      weatherServiceCheckException("Vanceboro");
//      weatherServiceCheckException("Baring");
//      weatherServiceCheckException("Calais");
//      weatherServiceCheckException("Robbinston");
//      weatherServiceCheckException("Perry");
//      weatherServiceCheckException("Eastport");
//      weatherServiceCheckException("Lubec");
////Within Canada
//      weatherServiceCheckException("Morrisburg");
//      weatherServiceCheckException("Lloydminster");
//      weatherServiceCheckException("Flin Flon");
//      weatherServiceCheckException("Ottawa");
//      //United States/Mexico
//      weatherServiceCheckException("San Diego");
//      weatherServiceCheckException("Tecate");
//      weatherServiceCheckException("Calexico");
//      weatherServiceCheckException("Gadsden");
//      weatherServiceCheckException("Yuma");
//      weatherServiceCheckException("Sonoyta");
//      weatherServiceCheckException("Naco");
   }


   /**
    * Checking that the temperature is less {@link #MAX_TEMPERATURE} and more than {@link #MIN_TEMPERATURE} and
    * humidity is less {@link #MAX_HUMIDITY} and more than {@link #MIN_HUMIDITY}. Also that there is a description
    * of the weather and an icon code.
    * @param city name of the city for searching weather
    */
   public void checkValidationWeatherDataDto(String city) throws WeatherException {
      WeatherDataDto weatherDataDto = weatherService.getWeatherData(city);

      assertFalse(weatherDataDto.getWeather().get(0).getDescription().isEmpty());
      assertFalse(weatherDataDto.getWeather().get(0).getIcon().isEmpty());

      assertTrue(weatherDataDto.getTemperatureInfo().getTemp() < MAX_TEMPERATURE);
      assertTrue(weatherDataDto.getTemperatureInfo().getTemp() > MIN_TEMPERATURE);

      assertTrue(weatherDataDto.getTemperatureInfo().getFeels_like() < MAX_TEMPERATURE);
      assertTrue(weatherDataDto.getTemperatureInfo().getFeels_like() > MIN_TEMPERATURE);

      assertTrue(weatherDataDto.getTemperatureInfo().getHumidity() <= MAX_HUMIDITY);
      assertTrue(weatherDataDto.getTemperatureInfo().getHumidity() >= MIN_HUMIDITY);
   }

   /**
    * Checking that an org.apache.karaf.weather.services.exception is performed.
    * @param city name of the city for searching weather
    */
   public void weatherServiceCheckException(String city)  {
      try {
         weatherService.getWeatherData(city);
         fail("Exception was not thrown");
      } catch (WeatherException e) {
         //if exceptions was thrown
      }
   }
}