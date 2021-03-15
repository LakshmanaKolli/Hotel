package com.epam.hotel;

import java.util.ArrayList;
import java.util.List;

import com.epam.hotel.dto.AddressDTO;
import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.dto.RoomDTO;
import com.epam.hotel.enums.RoomType;
import com.epam.hotel.mapper.HotelMapper;
import com.epam.hotel.mapper.HotelMapperImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractBaseTest {
	
	ObjectMapper mapper = new ObjectMapper();
	
	HotelMapper hotelMapper = new HotelMapperImpl();
	
	public HotelDTO getHotelDTOdetails() {
		HotelDTO dto = new HotelDTO();
		dto.setHotel_Id(1);
		dto.setName("AMX");
		dto.setPhoneNumber("123456789");
		dto.setDescription("Hotel with all amenities");
		dto.setRating("4.5");
		AddressDTO address = new AddressDTO(1, "IN", "AP", "VZM", "TGP", "12345");
		dto.setAddress(address);
		List<RoomDTO> rooms = new ArrayList<>();
		RoomDTO room = new RoomDTO(1, 1, 200, "Y", RoomType.DELUXE);
		rooms.add(room);
		dto.setRoom(rooms);
		return dto;
	}
}
