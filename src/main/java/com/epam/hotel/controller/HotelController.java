package com.epam.hotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.exception.HotelException;
import com.epam.hotel.exception.HotelNotFoundException;
import com.epam.hotel.response.SaveHotelResponse;
import com.epam.hotel.response.UpdateHotelResponse;

@RequestMapping("/hotels/api/v1")
public interface HotelController {
	
	@PostMapping
	public ResponseEntity<SaveHotelResponse> saveHotelDetails(@RequestBody HotelDTO hotelDTO) throws HotelException;
	
	@GetMapping("/hotelDetails/{hotelId}")
	public ResponseEntity<HotelDTO> getHotelByHotelId(@PathVariable Integer hotelId) throws HotelNotFoundException;
	
	@PutMapping("/hotelChange/{hotelId}")
	public ResponseEntity<UpdateHotelResponse> updateHotelDetails(@RequestBody HotelDTO hotelDTO, @PathVariable Integer hotelId) throws HotelNotFoundException;
}
