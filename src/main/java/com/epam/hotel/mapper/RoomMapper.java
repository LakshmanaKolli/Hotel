package com.epam.hotel.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.epam.hotel.domain.Room;
import com.epam.hotel.dto.RoomDTO;

@Mapper(componentModel = "spring")
public interface RoomMapper {

	List<Room> toListOfRoom(List<RoomDTO> dto);
	List<RoomDTO> toListOfRoomDTO(List<Room> domain);
	
}
