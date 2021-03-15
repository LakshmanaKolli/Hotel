package com.epam.hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.epam.hotel.controller.HotelController;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BaseContractTest {
	
	@Autowired
	HotelController hotelController;

	@BeforeEach
	void setup() {
		RestAssuredMockMvc.standaloneSetup(hotelController);
	}
}
