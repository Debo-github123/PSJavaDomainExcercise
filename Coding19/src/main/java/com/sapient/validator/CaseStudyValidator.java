package com.sapient.validator;

import com.sapient.entity.*;
import com.sapient.exception.ResourceNotFoundException;
import com.sapient.exception.ExceptionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CaseStudyValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(CaseStudyValidator.class.getName());

    public void validateCity(City city) {
        if (city == null) {
            LOGGER.error(ExceptionConstants.ERROR_CITY_NOT_FOUND);
            throw new ResourceNotFoundException(ExceptionConstants.ERROR_CITY_NOT_FOUND, null, ExceptionConstants.ERROR_CODE_CITY_NOT_FOUND);
        }
    }

    public void validateTheater(Theater theater) {
        if (theater == null) {
            LOGGER.error(ExceptionConstants.ERROR_THEATER_NOT_FOUND);
            throw new ResourceNotFoundException(ExceptionConstants.ERROR_THEATER_NOT_FOUND, null, ExceptionConstants.ERROR_CODE_THEATER_NOT_FOUND);
        }
    }

    public void validateMovie(Movie movie) {
        if (movie == null) {
            LOGGER.error(ExceptionConstants.ERROR_MOVIE_NOT_FOUND);
            throw new ResourceNotFoundException(ExceptionConstants.ERROR_MOVIE_NOT_FOUND, null, ExceptionConstants.ERROR_CODE_MOVIE_NOT_FOUND);
        }
    }

    public void validateShow(Show show) {
        if (show == null) {
            LOGGER.error(ExceptionConstants.ERROR_SHOW_NOT_FOUND);
            throw new ResourceNotFoundException(ExceptionConstants.ERROR_SHOW_NOT_FOUND, null, ExceptionConstants.ERROR_CODE_SHOW_NOT_FOUND);
        }
    }

    public void validateBooking(Booking booking) {
        if (booking == null) {
            LOGGER.error(ExceptionConstants.ERROR_BOOKING_NOT_FOUND);
            throw new ResourceNotFoundException(ExceptionConstants.ERROR_BOOKING_NOT_FOUND, null, ExceptionConstants.ERROR_CODE_BOOKING_NOT_FOUND);
        }
    }
}
