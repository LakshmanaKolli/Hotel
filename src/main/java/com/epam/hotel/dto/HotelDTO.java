package com.epam.hotel.dto;

import java.util.List;

import lombok.Data;

@Data
public class HotelDTO {
	
	private Integer hotel_Id;
	
	private String name;
	
	private String description;
	
	private String rating;
	
	private List<RoomDTO> room;
	
	private String phoneNumber;

	private AddressDTO address;

}
