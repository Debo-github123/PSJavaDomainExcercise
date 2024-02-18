package com.sapient.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequest {
    private String date;

    private String startTime;

    private String endTime;

    private Double price;
}
