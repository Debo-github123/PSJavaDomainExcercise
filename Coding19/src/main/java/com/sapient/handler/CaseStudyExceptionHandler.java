package com.sapient.handler;

import com.sapient.exception.ErrorDetail;
import com.sapient.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CaseStudyExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ErrorDetail>  handleExceptions(ResourceNotFoundException exception) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setErrorCode(exception.getErrorCode());
        errorDetail.setTitle(exception.getErrorMessage());
        errorDetail.setHttpStatus(HttpStatus.NOT_FOUND);
        HttpHeaders headers = getHeaders();
        return new ResponseEntity<>(errorDetail, headers, HttpStatus.NOT_FOUND);

    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
