package com.epam.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.hotel.controller.HotelControllerImpl;
import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.service.HotelService;
import com.epam.hotel.service.HotelServiceImpl;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class BaseContractTest {
	
//	@Autowired
//	HotelService hotelService;

	@BeforeEach
	void setup() {
//		HotelDTO response = new HotelDTO();
//		response.setHotel_Id(1);
//		response.setName("AMB");
//		response.setDescription("near ASP");
//		response.setRating("4.5");
		RestAssuredMockMvc.standaloneSetup(new HotelServiceImpl());
	}
}
