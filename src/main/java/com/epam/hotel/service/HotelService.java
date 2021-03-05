package com.epam.hotel.service;

import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.exception.HotelException;
import com.epam.hotel.exception.HotelNotFoundException;
import com.epam.hotel.response.SaveHotelResponse;
import com.epam.hotel.response.UpdateHotelResponse;

public interface HotelService {

	SaveHotelResponse saveHotelDetails(HotelDTO hotelDTO) throws HotelException;

	HotelDTO getHotelByHotelId(Integer hotelId) throws HotelNotFoundException;

	UpdateHotelResponse updateHotelDetails(HotelDTO dto, Integer hotelId) throws HotelNotFoundException;

}
