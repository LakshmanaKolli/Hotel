package com.epam.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.exception.HotelException;
import com.epam.hotel.exception.HotelNotFoundException;
import com.epam.hotel.response.SaveHotelResponse;
import com.epam.hotel.response.UpdateHotelResponse;
import com.epam.hotel.service.HotelService;

@RestController
public class HotelControllerImpl implements HotelController{
	
	@Autowired
	private HotelService hotelService;
	
	@Override
	public ResponseEntity<SaveHotelResponse> saveHotelDetails(HotelDTO hotelDTO) throws HotelException{
		return new ResponseEntity<>(hotelService.saveHotelDetails(hotelDTO), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<HotelDTO> getHotelByHotelId(Integer hotelId) throws HotelNotFoundException {
		return new ResponseEntity<>(hotelService.getHotelByHotelId(hotelId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UpdateHotelResponse> updateHotelDetails(HotelDTO hotelDTO, Integer hotelId) throws HotelNotFoundException {
		return new ResponseEntity<>(hotelService.updateHotelDetails(hotelDTO, hotelId), HttpStatus.ACCEPTED);
	}

}
