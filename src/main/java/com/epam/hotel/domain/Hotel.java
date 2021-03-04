package com.epam.hotel.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.epam.hotel.enums.HotelType;

import lombok.Data;

@Data
@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	
	private String name;
	
	private String description;
	
	private String rating;
	
	HotelType type;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	Address address;

}
