package com.sapient.service;

import com.sapient.dto.CityRequest;
import com.sapient.dto.MovieRequest;
import com.sapient.dto.ShowRequest;
import com.sapient.dto.TheaterRequest;
import com.sapient.entity.City;
import com.sapient.entity.Movie;
import com.sapient.entity.Show;
import com.sapient.entity.Theater;

import java.util.List;

public interface TheaterService {
    Theater addTheater(long cityId, TheaterRequest theaterRequest);

    City addCity(CityRequest cityRequest);

    List<City> getAllCities();

    Movie createMovie(long theaterId, MovieRequest movieRequests);

    Show addShow(long theaterId, long movieId, ShowRequest showRequest);
}
