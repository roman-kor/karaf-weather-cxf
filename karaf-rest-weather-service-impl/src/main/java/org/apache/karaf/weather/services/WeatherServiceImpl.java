package org.apache.karaf.weather.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.karaf.weather.services.dto.LocationInfo;
import org.apache.karaf.weather.services.dto.TemperatureInfo;
import org.apache.karaf.weather.services.dto.WeatherDataDto;
import org.apache.karaf.weather.services.dto.WeatherInfo;
import org.apache.karaf.weather.services.exception.WeatherException;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final GetWeatherDataService getWeatherDataService;
    /**
     * String format for formatting the bot's response for unknown geolocation.
     */
    private final String STRING_FORMAT_FOR_UNKNOWN_GEOLOCATION = "🌍 Unknown address\nLatitude: %.1f\nLongitude: %.1f\n%s";
    /**
     * String format for formatting the bot's response for geolocation.
     */
    private final String STRING_FORMAT_FOR_LOCATION = "🌍 %s, %s\n%s";
    /**
     * String format for formatting the bot's response for weather.
     */
    private final String STRING_FORMAT_FOR_WEATHER = "%s %s\n🌡 Temperature: %d°C\n📊 Feels like: %d°C\n💧 Humidity: %d%%";
    /**
     * Representing weather icon from the Open Weather API response in emojis.
     */
    private final Map<String, String> emojiOfWeather = new HashMap<String, String>() {
        {
            put("01d", "☀️");
            put("01n", "🌑");
            put("02d", "⛅");
            put("02n", "🌑☁️");
            put("03d", "☁️");
            put("03n", "☁️");
            put("04d", "☁️☁️");
            put("04n", "☁️☁️");
            put("09d", "🌧");
            put("09n", "🌧");
            put("10d", "🌦");
            put("10n", "🌑🌧");
            put("11d", "⛈");
            put("11n", "⛈");
            put("13d", "❄️");
            put("13n", "❄️");
            put("50d", "🌫");
            put("50n", "🌫");
        }
    };


    @Override
    public String getWeatherResponse(String cityName) throws WeatherException {
        String response;
        WeatherDataDto weatherDto = getWeatherDataService.getWeatherData(cityName);
        response = formattingResponse(weatherDto);
        return response;
    }

    private String formattingResponse(WeatherDataDto weatherDataDto) {
        TemperatureInfo temperatureInfo = weatherDataDto.getTemperatureInfo();
        WeatherInfo weatherInfo = weatherDataDto.getWeather().get(0);
        LocationInfo location = weatherDataDto.getLocation();
        String cityName = weatherDataDto.getCityName();
        String countryName = weatherDataDto.getSystemInfo().getCountry();
        String formattedResponse;
        String weather = String.format(STRING_FORMAT_FOR_WEATHER, emojiOfWeather.get(weatherInfo.getIcon()),
            weatherInfo.getDescription(), temperatureInfo.getTemp(),
            temperatureInfo.getFeels_like(), temperatureInfo.getHumidity());

        if (cityName == null || countryName == null) {
            formattedResponse = String.format(STRING_FORMAT_FOR_UNKNOWN_GEOLOCATION,
                location.getLatitude(), location.getLongitude(), weather);
        } else {
            formattedResponse = String.format(STRING_FORMAT_FOR_LOCATION, cityName, countryName, weather);
        }
        return formattedResponse;
    }
}
