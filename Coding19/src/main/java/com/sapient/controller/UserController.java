package com.sapient.controller;

import com.sapient.dto.BookingRequest;
import com.sapient.entity.Booking;
import com.sapient.entity.Seat;
import com.sapient.entity.Show;
import com.sapient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping("/{cityId}/{movieId}/show")
    public List<Show> getShowsByCityAndMovie(@PathVariable(value = "cityId") long cityId,
                                             @PathVariable(value = "movieId") long movieId,
                                             @RequestParam(required = false) String date) {
        LOGGER.info("Getting Show details for cityID {}, movieId {}", cityId, movieId);
        return userService.getShowsByCityAndMovie(cityId, movieId, date);
    }

    @GetMapping("/show/{showId}/seats")
    public List<Seat> getAvailableSeat(@PathVariable(value = "showId") long showId) {
        return userService.getAvailableSeats(showId);
    }


    @PostMapping("/show/{showId}/bookings")
    public Booking bookSeatsForShow(@PathVariable(value = "showId") long showId, @Valid @RequestBody BookingRequest bookingRequest) {
        return userService.bookSeatsForShow(showId, bookingRequest);
    }


}
