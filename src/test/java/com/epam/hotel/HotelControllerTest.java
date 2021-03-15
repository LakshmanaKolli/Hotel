package com.epam.hotel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.response.SaveHotelResponse;
import com.epam.hotel.response.UpdateHotelResponse;
import com.epam.hotel.service.HotelService;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelControllerTest extends AbstractBaseTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private HotelService hotelService;

	@WithMockUser(username = "username", password = "password")
	@Test
	void saveHotelDetails() throws Exception {
		HotelDTO hotelDTO = getHotelDTOdetails();
		SaveHotelResponse response = new SaveHotelResponse();
		response.setMessage("Hotel details saved successfully");
		Mockito.when(hotelService.saveHotelDetails(hotelDTO)).thenReturn(response);
		mockMvc.perform(post("/hotels/api/v1").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(hotelDTO))).andExpect(status().isCreated());
	}

	@WithMockUser(username = "username", password = "password")
	@Test
	void getHotelByHotelId() throws Exception {
		Integer hotelId = 1;
		Mockito.when(hotelService.getHotelByHotelId(hotelId)).thenReturn(getHotelDTOdetails());
		mockMvc.perform(get("/hotels/api/v1/hotelDetails/1")).andExpect(status().isOk());
	}

	@WithMockUser(username = "username", password = "password")
	@Test
	void updateHotelDetails() throws Exception {
		HotelDTO dto = getHotelDTOdetails();
		UpdateHotelResponse resp = new UpdateHotelResponse("Hotel details updated successfully");
		Mockito.when(hotelService.updateHotelDetails(dto, 1)).thenReturn(resp);
		mockMvc.perform(put("/hotels/api/v1/hotelChange/1")
				.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsBytes(dto))).andDo(print())
				.andExpect(status().isAccepted());
	}

}
