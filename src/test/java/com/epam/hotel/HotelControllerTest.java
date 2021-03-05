package com.epam.hotel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.response.SaveHotelResponse;
import com.epam.hotel.service.HotelService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class HotelControllerTest extends AbstractBaseTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private HotelService hotelService;

	@Test
	void saveHotelDetails() throws Exception {
		HotelDTO hotelDTO = getHotelDTOdetails();
		SaveHotelResponse response = new SaveHotelResponse();
		response.setMessage("Hotel details saved successfully");
		Mockito.when(hotelService.saveHotelDetails(hotelDTO)).thenReturn(response);
		mockMvc.perform(post("/hotels/api/v1").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(hotelDTO))).andExpect(status().isCreated());
	}
	
	@Test
	void getHotelByHotelId() throws Exception{
		Integer hotelId = 1;
		Mockito.when(hotelService.getHotelByHotelId(hotelId)).thenReturn(getHotelDTOdetails());
		mockMvc.perform(get("/hotels/api/v1/hotelDetails/1")).andExpect(status().isOk());
	}

}
