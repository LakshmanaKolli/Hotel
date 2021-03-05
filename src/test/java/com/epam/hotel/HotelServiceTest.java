package com.epam.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.hotel.domain.Hotel;
import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.exception.HotelException;
import com.epam.hotel.repository.HotelRepository;
import com.epam.hotel.response.SaveHotelResponse;
import com.epam.hotel.service.HotelService;

@SpringBootTest
public class HotelServiceTest extends AbstractBaseTest{

	@MockBean
	private HotelRepository hotelRepository;
	
	@Autowired
	private HotelService hotelService;
	
	@Test
	void saveHotelDetails_success() throws Exception{
		Hotel domain = hotelMapper.toHotel(getHotelDTOdetails());
		Mockito.when(hotelRepository.save(domain)).thenReturn(domain);
		SaveHotelResponse resp = hotelService.saveHotelDetails(getHotelDTOdetails());
		assertEquals("Hotel details saved successfully", resp.getMessage());
	}
	
	@Test
	void saveHotelDetails_error() throws Exception{
		Exception ex = assertThrows(HotelException.class, () -> hotelService.saveHotelDetails(new HotelDTO()));
		assertEquals("Cannot invoke \"com.epam.hotel.domain.Hotel.getHotel_Id()\" because \"hotel\" is null", ex.getMessage());
	}
	
	@Test
	void getHotelByHotelId() throws Exception{
		Optional<Hotel> domain = Optional.of(hotelMapper.toHotel(getHotelDTOdetails()));
		Mockito.when(hotelRepository.findById(1)).thenReturn(domain);
		assertEquals(1, hotelService.getHotelByHotelId(1).getHotel_Id());
	}
}
