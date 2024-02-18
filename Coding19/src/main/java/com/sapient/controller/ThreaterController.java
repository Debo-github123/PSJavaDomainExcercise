package com.sapient.controller;

import com.sapient.dto.CityRequest;
import com.sapient.dto.MovieRequest;
import com.sapient.dto.ShowRequest;
import com.sapient.dto.TheaterRequest;
import com.sapient.entity.City;
import com.sapient.entity.Movie;
import com.sapient.entity.Show;
import com.sapient.entity.Theater;
import com.sapient.service.TheaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ThreaterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreaterController.class.getName());

    @Autowired
    private TheaterService theaterService;

    @PostMapping(value = "/city")
    public City addCity(@RequestBody @Valid CityRequest city) {
        LOGGER.info("adding city");
        return theaterService.addCity(city);
    }

    @GetMapping(value = "/cities")
    public List<City> getAllCities() {
        LOGGER.info("Get all cities");
        return theaterService.getAllCities();
    }

    @PostMapping(value = "/{cityId}/theater")
    public Theater addTheater(@PathVariable(value = "cityId") long cityId, @RequestBody @Valid TheaterRequest requestbody) {
        LOGGER.info("adding theater for cityId {}", cityId);
        return theaterService.addTheater(cityId, requestbody);
    }

    @PostMapping("/{theaterId}/movie")
    public Movie createMovie(@PathVariable(value = "theaterId") long theaterId, @Valid @RequestBody MovieRequest movieRequest) {
        LOGGER.info("Registering a movie for theaterId {}", theaterId);
        return theaterService.createMovie(theaterId, movieRequest);
    }


    @PostMapping("/{theaterId}/{movieId}/show")
    public Show addShow(@PathVariable(value = "theaterId") long theaterId,
                        @PathVariable(value = "movieId") long movieId,
                        @RequestBody @Valid ShowRequest showRequest) {
        LOGGER.info("Adding a show for  theaterId {}, movieId {}", theaterId, movieId);
        return theaterService.addShow(theaterId, movieId, showRequest);
    }
}
