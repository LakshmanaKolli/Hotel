package com.epam.hotel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String area;
	
	private String pincode;
	
}
