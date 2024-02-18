package com.sapient.service.impl;

import com.sapient.dto.BookingRequest;
import com.sapient.entity.*;
import com.sapient.repository.*;
import com.sapient.service.UserService;
import com.sapient.validator.CaseStudyValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class.getName());
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookedSeatRepository bookedSeatRepository;

    @Autowired
    private CaseStudyValidator validator;

    @Override
    public List<Show> getShowsByCityAndMovie(long cityId, long movieId, String date) {
        City city = cityRepository.getOne(cityId);
        validator.validateCity(city);
        Movie movie = movieRepository.getOne(movieId);
        validator.validateMovie(movie);

        LocalDate localDate = null;
        if (!StringUtils.isEmpty(date)) {
            localDate = LocalDate.parse(date);
        }

        List<Theater> theaterList = city.getTheTheater();
        List<Show> showList = new ArrayList<>();

        for (Theater theater : theaterList) {

            for (Show show : theater.getShows()) {
                System.out.println(show.getMovie().getId());
                System.out.println(show.getDate());

                if (show.getMovie() == movie && (localDate == null || (show.getDate() == localDate))) {
                    showList.add(show);
                }
            }
        }
        return showList;
    }

    @Override
    public List<Seat> getAvailableSeats(long showId) {
        Show show = showRepository.getOne(showId);
        validator.validateShow(show);

        List<Seat> allSeats = show.getTheater().getSeats();
        List<Seat> availableSeats = allSeats.stream().filter(seat -> !show.getBookedSeats().contains(seat)).collect(Collectors.toList());
        return availableSeats;
    }

    @Override
    public Booking bookSeatsForShow(long showId, BookingRequest bookingRequest) {
        Show show = showRepository.getOne(showId);
        validator.validateShow(show);
        Booking booking = new Booking();
        booking.setBooked(true);
        for (Seat seat : bookingRequest.getRequestedSeats()) {
            BookedSeat bookedSeat = new BookedSeat();
            bookedSeat.setSeat(seat);
            bookedSeat.setShow(show);
            bookedSeat.setBooking(booking);
            booking.getBookedSeats().add(bookedSeat);
            bookedSeatRepository.save(bookedSeat);
        }
        bookingRepository.save(booking);
        return booking;
    }
}
