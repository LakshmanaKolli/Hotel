package com.epam.hotel.mapper;

import org.mapstruct.Mapper;

import com.epam.hotel.domain.Address;
import com.epam.hotel.dto.AddressDTO;

@Mapper(componentModel = "spring")
public interface AddressMapper {
	
	Address toAddress(AddressDTO dto);
	AddressDTO toAddressDTO(Address domain);
	
}
