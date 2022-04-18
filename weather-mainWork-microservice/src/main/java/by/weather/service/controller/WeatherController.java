package by.weather.service.controller;

import by.weather.service.MainWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    private MainWorkerService mainWorker;

    @GetMapping("/weather")
    public ResponseEntity<?> hello(@RequestParam(value = "cityName") String cityName) {
        return new ResponseEntity<>("Now The Weather in " + cityName
                + " " + mainWorker.getCityTemperature(cityName) + "°C", HttpStatus.OK);
    }
}
