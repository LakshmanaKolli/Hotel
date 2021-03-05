package com.epam.hotel.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel_id") 
	private List<Room> room;
	
	private String phoneNumber;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "address_id")
	private Address address;

}
