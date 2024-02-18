package com.sapient.dto;

import com.sapient.entity.Seat;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class BookingRequest {
    private long user_id;
    private List<Seat> requestedSeats;
    private LocalTime bookingTime;

}
