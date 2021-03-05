package com.epam.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.hotel.domain.Hotel;
import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.exception.HotelException;
import com.epam.hotel.mapper.HotelMapper;
import com.epam.hotel.repository.HotelRepository;
import com.epam.hotel.response.SaveHotelResponse;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelMapper mapper;
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public SaveHotelResponse saveHotelDetails(HotelDTO hotelDTO) throws HotelException {
		SaveHotelResponse response = new SaveHotelResponse();
		try {
		Hotel hotel = hotelRepository.save(mapper.toHotel(hotelDTO));
		if(null != hotel.getHotel_Id()) {
			response.setMessage("Hotel details saved successfully");
		}
		}
		catch(Exception ex) {
			throw new HotelException(ex.getMessage());
		}
		return response;
	}

}
