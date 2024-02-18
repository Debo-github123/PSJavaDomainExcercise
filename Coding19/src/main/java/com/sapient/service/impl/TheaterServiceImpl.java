package com.sapient.service.impl;

import com.sapient.dto.CityRequest;
import com.sapient.dto.MovieRequest;
import com.sapient.dto.ShowRequest;
import com.sapient.dto.TheaterRequest;
import com.sapient.entity.City;
import com.sapient.entity.Movie;
import com.sapient.entity.Show;
import com.sapient.entity.Theater;
import com.sapient.repository.*;
import com.sapient.service.TheaterService;
import com.sapient.validator.CaseStudyValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class TheaterServiceImpl implements TheaterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TheaterServiceImpl.class.getName());
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private CaseStudyValidator validator;

    @Override
    public Theater addTheater(long cityId, TheaterRequest theaterRequest) {
        City city = cityRepository.getOne(cityId);
        validator.validateCity(city);

        Theater theater = new Theater();
        theater.setName(theaterRequest.getName());
        theater.setCity(city);
        theater.setAddress(theaterRequest.getAddress());
        theaterRepository.save(theater);
        return theater;
    }

    @Override
    public City addCity(CityRequest cityRequest) {
        City city = new City();
        city.setName(cityRequest.getCityName());
        city.setState(cityRequest.getState());
        city.setCountry(cityRequest.getCountry());
        cityRepository.save(city);
        return city;
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public Movie createMovie(long theaterId, MovieRequest movieRequest) {
        Theater theater = theaterRepository.getOne(theaterId);
        validator.validateTheater(theater);
        Movie movie = new Movie();
        movie.setDuration(movieRequest.getDuration());
        movie.setGenre(movieRequest.getGenre());
        movie.setTitle(movieRequest.getTitle());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setTheater(theater);
        movieRepository.save(movie);
        theater.getMovies().add(movie);
        theaterRepository.save(theater);
        return movie;
    }

    @Override
    public Show addShow(long theaterId, long movieId, ShowRequest showRequest) {
        Theater theater = theaterRepository.getOne(theaterId);
        validator.validateTheater(theater);
        Movie movie = movieRepository.getOne(movieId);
        validator.validateMovie(movie);

        Show show = new Show();
        show.setTheater(theater);
        show.setMovie(movie);
        show.setDate(LocalDate.parse(showRequest.getDate())); //yyyy-MM-dd
        show.setStartTime(LocalTime.parse(showRequest.getStartTime()));
        show.setEndTime(LocalTime.parse(showRequest.getEndTime()));
        show.setPrice(showRequest.getPrice());
        showRepository.save(show);
        return show;
    }

}
