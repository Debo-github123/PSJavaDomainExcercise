package com.sapient.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter
@Getter
public class TheaterRequest implements Serializable {
    private String name;
    private String address;

}
