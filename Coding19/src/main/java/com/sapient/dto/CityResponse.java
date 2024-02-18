package com.sapient.dto;

import lombok.Data;

@Data
public class CityResponse {
    private long id;
    private String cityName;
    private String country;
    private String state;
    private String pinCode;
}
