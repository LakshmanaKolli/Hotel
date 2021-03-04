package com.epam.hotel.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.epam.hotel.enums.RoomType;

import lombok.Data;

@Data
@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer hotel_Id;
	
	private String name;
	
	private String description;
	
	private String rating;
	
	private Rooms rooms;
	
	private String phoneNumber;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "room_id", referencedColumnName = "room_id")
	private RoomType type;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

}
