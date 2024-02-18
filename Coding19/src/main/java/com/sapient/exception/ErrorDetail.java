package com.sapient.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ErrorDetail {
    private int errorCode;
    private String title;
    private HttpStatus httpStatus;
}
