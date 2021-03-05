package com.epam.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.epam.hotel.response.ErrorResponse;

@RestControllerAdvice
public class HotelExceptionHandler {

	@ExceptionHandler(HotelException.class)
	public final ResponseEntity<Object> hotelExceptionHandler(HotelException ex){
		ErrorResponse error = new ErrorResponse(ex.getMessage(), 500);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HotelNotFoundException.class)
	public final ResponseEntity<Object> hotelExceptionHandler(HotelNotFoundException ex){
		ErrorResponse error = new ErrorResponse(ex.getMessage(), 404);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
