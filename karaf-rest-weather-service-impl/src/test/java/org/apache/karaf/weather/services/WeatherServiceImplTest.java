package org.apache.karaf.weather.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.apache.karaf.weather.services.dto.LocationInfo;
import org.apache.karaf.weather.services.dto.SystemInfo;
import org.apache.karaf.weather.services.dto.TemperatureInfo;
import org.apache.karaf.weather.services.dto.WeatherDataDto;
import org.apache.karaf.weather.services.dto.WeatherInfo;
import org.apache.karaf.weather.services.exception.WeatherException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WeatherServiceImplTest {

    private GetWeatherDataService dataService;
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        dataService = Mockito.mock(GetWeatherDataService.class);
        weatherService = new WeatherServiceImpl(dataService);
    }

    @Test
    public void testWeatherResponse() throws WeatherException {
        WeatherDataDto weatherDto = createWeatherDTO("kiev", "UA", -6, -8, 56);
        when(dataService.getWeatherData("kiev")).thenReturn(weatherDto);
        String expectedFormattedResponse = "\uD83C\uDF0D kiev, UA\n"
            + "null clear sky\n"
            + "\uD83C\uDF21 Temperature: -6°C\n"
            + "\uD83D\uDCCA Feels like: -8°C\n"
            + "\uD83D\uDCA7 Humidity: 56%";
        String actualFormattedResponse = weatherService.getWeatherResponse("kiev");
        assertEquals(expectedFormattedResponse, actualFormattedResponse);
    }

    @Test
    public void testException() {
//        Throwable throwable = Assertions.catchThrowable(() -> dataService.getWeatherData("k1ev"));
////        Assertions.assertThrows(WeatherException.class,()->weatherServiceRest.getWeather("k1ev"));
//        Assertions.assertThat(throwable)
//            .isInstanceOf(WeatherException.class);
    }

    /**
     * Create the weather data dto with the parameters that would be mocked through the test.
     *
     * @param cityName the city name
     * @param countryCode the country code
     * @param temperature the temperature
     * @param tempFeelsLike the temp feels like
     * @param humidity the humidity
     * @return the weather data dto
     */
    private WeatherDataDto createWeatherDTO(String cityName, String countryCode, int temperature, int tempFeelsLike, int humidity) {
        WeatherDataDto weatherDataDto = new WeatherDataDto();
        double longitude = 23.3424;
        double latitude = 23.3424;
        String weatherDescription = "clear sky";
        TemperatureInfo temperatureInfo = new TemperatureInfo();
        temperatureInfo.setTemp(temperature);
        temperatureInfo.setFeels_like(tempFeelsLike);
        temperatureInfo.setHumidity(humidity);
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setDescription(weatherDescription);
        List<WeatherInfo> weatherList = new ArrayList<>();
        weatherList.add(weatherInfo);

        LocationInfo locationInfo = new LocationInfo();
        locationInfo.setLatitude(latitude);
        locationInfo.setLongitude(longitude);

        weatherDataDto.setWeather(weatherList);
        weatherDataDto.setLocation(locationInfo);

        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setCountry(countryCode);

        weatherDataDto.setSystemInfo(systemInfo);
        weatherDataDto.setCityName(cityName);
        weatherDataDto.setTemperatureInfo(temperatureInfo);
        return weatherDataDto;
    }

}