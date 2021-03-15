package com.epam.hotel.dto;

import com.epam.hotel.enums.RoomType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

	private Integer room_id;
	
	private Integer room_number;
	
	private Integer room_rate; 
	
	private String room_availability;
	
	private RoomType type;
}
