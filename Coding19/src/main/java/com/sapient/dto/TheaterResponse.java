package com.sapient.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter
@Getter
public class TheaterResponse implements Serializable {
    private long id;
    private String name;
    private String address;
    private long cityId;

}
