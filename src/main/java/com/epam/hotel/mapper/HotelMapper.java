package com.epam.hotel.mapper;

import org.mapstruct.Mapper;

import com.epam.hotel.domain.Hotel;
import com.epam.hotel.dto.HotelDTO;

@Mapper(componentModel = "spring")
public interface HotelMapper {
	
	Hotel toHotel(HotelDTO dto);
	HotelDTO toHotelDTO(Hotel domain);
}
