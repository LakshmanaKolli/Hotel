package com.epam.hotel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.epam.hotel.enums.RoomType;

import lombok.Data;

@Data
@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer room_id;
	
	private Integer room_number;
	
	private Integer room_rate; 
	
	private String room_availability;
	
	private RoomType type;
}
