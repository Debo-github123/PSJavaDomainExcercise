package com.sapient.service;

import com.sapient.dto.BookingRequest;
import com.sapient.entity.Booking;
import com.sapient.entity.Seat;
import com.sapient.entity.Show;

import java.util.List;

public interface UserService {
    List<Show> getShowsByCityAndMovie(long cityId,
                                      long movieId,
                                      String dates);

    List<Seat> getAvailableSeats(long showId);

    Booking bookSeatsForShow(long showId, BookingRequest bookingRequest);
}
