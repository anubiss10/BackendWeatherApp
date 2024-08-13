package com.travelcraft.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @Value("${visualcrossing.api.key}")
    private String apiKey;

    private final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline";

    @CrossOrigin(origins = "https://travelcraft.netlify.app")
    @GetMapping("/weather")
    public ResponseEntity<String> getWeather(@RequestParam String location, @RequestParam String date) {
        try {
            String url = String.format("%s/%s/%s?unitGroup=metric&key=%s&include=days", BASE_URL, location, date, apiKey);
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            // Logging para ver la respuesta
            System.out.println("Response from Visual Crossing: " + response);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Logging para ver el error
            System.err.println("Error fetching weather data: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching weather data");
        }
    }
}
