package com.sapient.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuditoriumRequest {
    private String name;
    private int seatCount;
    private List<Integer> seats;
}
