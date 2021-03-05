package com.epam.hotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.exception.HotelException;

@RequestMapping("/hotels/api/v1")
public interface HotelController {
	
	@PostMapping
	public ResponseEntity<Object> saveHotelDetails(@RequestBody HotelDTO hotelDTO) throws HotelException;
}
