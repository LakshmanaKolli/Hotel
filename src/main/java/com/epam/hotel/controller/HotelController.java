package com.epam.hotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.hotel.dto.HotelDTO;
import com.epam.hotel.exception.HotelException;
import com.epam.hotel.exception.HotelNotFoundException;
import com.epam.hotel.response.SaveHotelResponse;
import com.epam.hotel.response.UpdateHotelResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@ApiResponse(description = "Hotel Service")
@RequestMapping("/hotels/api/v1")
public interface HotelController {
	
	@Operation(summary = "Saves hotel details")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Saved hotel details", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = SaveHotelResponse.class)) }) })
	@PostMapping
	public ResponseEntity<SaveHotelResponse> saveHotelDetails(@RequestBody HotelDTO hotelDTO) throws HotelException;
	
	@Operation(summary = "Fetches hotel details")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fetched hotel details", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = HotelDTO.class)) }) })
	@GetMapping("/hotelDetails/{hotelId}")
	public ResponseEntity<HotelDTO> getHotelByHotelId(@PathVariable Integer hotelId) throws HotelNotFoundException;
	
	@Operation(summary = "Updates hotel details")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Updated hotel details", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UpdateHotelResponse.class)) }) })
	@PutMapping("/hotelChange/{hotelId}")
	public ResponseEntity<UpdateHotelResponse> updateHotelDetails(@RequestBody HotelDTO hotelDTO, @PathVariable Integer hotelId) throws HotelNotFoundException;
}
