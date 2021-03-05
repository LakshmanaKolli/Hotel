package com.epam.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.hotel.domain.Hotel;
import com.epam.hotel.repository.HotelRepository;
import com.epam.hotel.service.HotelService;

public class HotelServiceTest extends AbstractBaseTest{

	@MockBean
	private HotelRepository hotelRepository;
	
	@Autowired
	private HotelService hotelService;
	
	@Test
	public void saveHotelDetails() throws Exception{
		Hotel domain = hotelMapper.toHotel(getHotelDTOdetails());
		Mockito.when(hotelRepository.save(domain)).thenReturn(domain);
		assertEquals("Hotel details saved successfully", hotelService.saveHotelDetails(getHotelDTOdetails()).getMessage());
	}
}
